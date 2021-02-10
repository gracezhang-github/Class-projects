// This program will produce an image that demonstrates the Café
// Wall illusion. 

import java.awt.*;
public class CafeWall {
    public static final int MORTAR = 2;

    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(650, 400);
        panel.setBackground(Color.GRAY);
        Graphics brush = panel.getGraphics();
        
        drawRow(brush, 0, 0, 20, 4);
        drawRow(brush, 50, 70, 30, 5);
        drawGrid(brush, 400, 20, 35, 2, 35);
        drawGrid(brush, 10, 150, 25, 4, 0);
        drawGrid(brush, 250, 200, 25, 3, 10);
        drawGrid(brush, 425, 180, 20, 5, 10);
    }

    // With given x, y, size and row pair dimensions
    // this method will allow the graphics brush (graphics object)
    // to draw out the specified rows
    public static void drawRow(Graphics brush, int x, int y, int size, int pairNum) {
        for (int i = 0; i < pairNum; i++) {
            brush.setColor(Color.BLACK);
            brush.fillRect(x+2*size*i, y, size, size);

            brush.setColor(Color.BLUE);
            brush.drawLine(x+2*size*i, y, x+2*size*i+size, y+size);
            brush.drawLine(x+2*size*i+size, y, x+2*size*i, y+size);

            brush.setColor(Color.WHITE);
            brush.fillRect(x+2*size*i+size, y, size, size);
        } 
    }

    // With the given x, y, size, row pairs, and offset dimensions
    // this method will utilize the Graphics brush (graphics object)
    // to draw out the desired grid
    public static void drawGrid(Graphics brush, int x, int y, int size, 
                                    int pairNum, int offset) {
        for (int i = 0; i < pairNum * 2; i++) {
            drawRow(brush, x+offset*(i%2), y+MORTAR*i+size*i, size, pairNum);
        }
    }
}
