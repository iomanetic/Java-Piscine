package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageToChar {

    private final String pathToImage;
    private final char symbWhite;
    private final char symbBlack;

    public ImageToChar(String pathToImage, char symbWhite, char symbBlack) {
        this.pathToImage = pathToImage;
        this.symbWhite = symbWhite;
        this.symbBlack = symbBlack;
    }

    public char[][] convertImageToChar() throws IOException {
        FileInputStream file = new FileInputStream(this.pathToImage);
        BufferedImage image = ImageIO.read(file);
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
        file.close();
        return (imageToChar);
    }

    public String getPathToImage() {
        return (pathToImage);
    }

    public char getSymbWhite() {
        return (symbWhite);
    }

    public char getSymbBlack() {
        return (symbBlack);
    }
}
