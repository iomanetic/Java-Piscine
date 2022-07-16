package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageToChar {

    private final char symbWhite;
    private final char symbBlack;

    public ImageToChar(char symbWhite, char symbBlack) {
        this.symbWhite = symbWhite;
        this.symbBlack = symbBlack;
    }

    public char[][] convertImageToChar() throws IOException {
        BufferedImage image = ImageIO.read(ImageToChar.class.getResource("/resources/it.bmp"));
        int xSizeImage = image.getWidth();
        int ySizeImage = image.getHeight();
        char[][] imageToChar = new char[ySizeImage][xSizeImage];
        int pixelColor;

        for(int y = 0; y < ySizeImage; y++) {
            for(int x = 0; x < xSizeImage; x++) {
                pixelColor = image.getRGB(x, y);
                if(pixelColor == Color.WHITE.getRGB()) {
                    imageToChar[y][x] = symbWhite;
                }
                else if(pixelColor == Color.BLACK.getRGB()) {
                    imageToChar[y][x] = symbBlack;
                } else {
                    imageToChar[y][x] = ' ';
                }
            }
        }
        return (imageToChar);
    }

    public char getSymbWhite() {
        return (symbWhite);
    }

    public char getSymbBlack() {
        return (symbBlack);
    }
}
