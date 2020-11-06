package ex00;

import java.io.*;
import java.util.*;

public class FileTypeTest {
	private static final int BUFFER_SIZE = 4096;
	private static final int MAX_SIGNATURE_SIZE = 8;

	private Map<String, Integer[]> signatureMap;

	private Integer[] getAllSignatureParts(String str) {
		Scanner scan = new Scanner(str);
		ArrayList<Integer> res = new ArrayList<>();

		while (scan.hasNextShort(16)) {
			res.add((int) scan.nextShort(16));
		}

		return res.toArray(new Integer[0]);
	}

	public FileTypeTest() {
		signatureMap = new HashMap<String, Integer[]>();
		try (Scanner scan = new Scanner(new File("ex00/signatures.txt")).useDelimiter("[,\\n]")) {
			while (scan.hasNext()) {
				signatureMap.put(scan.next(), getAllSignatureParts(scan.next()));
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe);
		}
	}

	public String getFileType(File file, boolean mode) throws IOException {
		byte[] buffer = new byte[BUFFER_SIZE];
		try (InputStream in = new FileInputStream(file)) {
			int n = in.read(buffer, 0, BUFFER_SIZE);
			int m = n;
			while ((m < MAX_SIGNATURE_SIZE) && (n > 0)) {
				n = in.read(buffer, m, BUFFER_SIZE - m);
				m += n;
			}

			String fileType = "UNDEFINED";
			for (Iterator<String> i = signatureMap.keySet().iterator(); i.hasNext(); ) {
				String key = i.next();
				if (matchesSignature(signatureMap.get(key), buffer, m)) {
					fileType = "PROCESSED";
					writeResultToFile(key, mode);
					break;
				}
			}
			return fileType;
		}
	}

	private static boolean matchesSignature(Integer[] signature, byte[] buffer, int size) {
		if (size < signature.length) {
			return false;
		}

		boolean b = true;
		for (int i = 0; i < signature.length; i++) {
			if (signature[i] != (buffer[i])) {
				b = false;
				break;
			}
		}

		return b;
	}

	public void printMapSignature() {
		for (String signature : signatureMap.keySet()) {
			String value = Arrays.toString(signatureMap.get(signature));
			System.out.println(signature + " " + value);
		}
	}

	private void writeResultToFile(String res, boolean isFirst) throws IOException {
		try {
			File myObj = new File("result.txt");
			if (isFirst) {
				if (myObj.exists()) {
					if (!myObj.delete()) {
						throw new IOException();
					}
				}
				if (myObj.createNewFile()) {
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt", true));
						writer.write(res);
						writer.newLine();
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				if (!myObj.exists()) {
					if (!myObj.createNewFile()) {
						throw new IOException();
					}
				}
				if (myObj.exists() && !myObj.isDirectory()) {
					BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt", true));
					writer.write(res);
					writer.newLine();
					writer.close();
				}
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}