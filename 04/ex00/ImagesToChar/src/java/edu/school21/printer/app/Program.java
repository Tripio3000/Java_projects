package edu.school21.printer.app;

import java.io.IOException;
import edu.school21.printer.logic.seeBMPImage;

public class Program {

    public Program() throws IOException {
    }

    public static void main (String[] args) throws IOException {
        if (args.length != 3) {
            System.exit(-1);
        }
        String black = args[0];
        String white = args[1];
        String path = args[2];
        seeBMPImage it = new seeBMPImage(path);
        it.seeBMPImage(black, white);
    }
}
