package eduedu.school21.printer.app;

import java.io.IOException;
import eduedu.school21.printer.logic.seeBMPImage;

public class Program {

    public Program() throws IOException {
    }

    public static void main (String[] args) throws IOException {
        seeBMPImage it = new seeBMPImage();
        it.seeBMPImage();
    }
}
