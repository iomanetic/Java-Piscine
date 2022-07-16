package edu.school21.printer.app;

import edu.school21.printer.logic.ImageToChar;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        if(args.length != 3 || (args[0].length() != 1 || args[1].length() != 1)) {
            System.err.println("Invalid arguments:\n"
                                + "example - program . 0 path/to/image");
            System.exit(-1);
        }

        ImageToChar converter = new ImageToChar(args[2], args[0].charAt(0), args[1].charAt(0));

        char[][] convertArr = converter.convertImageToChar();

        for(int y = 0; y < convertArr.length; y++) {
            System.out.println(convertArr[y]);
        }
    }
}