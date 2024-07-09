package piece;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import main.Board;

import javax.imageio.ImageIO;

import static javax.imageio.ImageIO.read;


public class Piece {
    public BufferedImage image;
    public int x,y;
    public int row,col,preRow,preCol;
    public int color;

    public Piece(int col, int row, int color){
        this.col = col;
        this.row = row;
        this.color = color;
        x = getX(col);
        y = getY(row);
        preCol = col;
        preRow = row;

    }

    public BufferedImage getImage(String imagePath){
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));

        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }
    public int getX(int col){
        return col * Board.SQUARE_SIZE;

    }
    public int getY(int row){
        return row * Board.SQUARE_SIZE;

    }
    public int getCol(int x){
        return (x + Board.HALF_SQUARE_SIZE)/Board.SQUARE_SIZE;
    }
    public int getRow(int y){
        return (y + Board.HALF_SQUARE_SIZE)/Board.SQUARE_SIZE;
    }
    public void draw(Graphics2D g2){
        g2.drawImage(image, x, y,Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
    }
}
