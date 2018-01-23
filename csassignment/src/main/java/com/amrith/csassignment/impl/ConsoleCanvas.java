package com.amrith.csassignment.impl;

import com.amrith.csassignment.Color;
import com.amrith.csassignment.ICanvas;

public class ConsoleCanvas implements ICanvas {
    // console is represented as matrix and each element as pixel for better control
    private char[][] canvas = null;

    // variable to store the console height
    private int canvasHeight = 0;

    // variable to store the console width
    private int canvasWidth = 0;

    /**
     * Default constructor.
     */
    public ConsoleCanvas() {
    }

    /**
     * Create the canvas and initialize it with boundary
     */
    public void create(int width, int height) {
        // add two more lines to capture boundary
        this.canvasWidth = width + 2;
        // add two more lines to capture boundary
        this.canvasHeight = height + 2;
        // define the canvas with set height and width
        this.canvas = new char[this.canvasHeight][this.canvasWidth];
        // set canvas boundary elements with | or - character
        populateBoundary();
    }

    /**
     * Method sets the boundary chars to represent canvas on console
     */
    private void populateBoundary() {
        for (int i = 0; i < this.canvasHeight; i++) {
            for (int j = 0; j < this.canvasWidth; j++) {
                if ((i == 0 || i == this.canvasHeight - 1) && j >= 0) {
                    this.canvas[i][j] = '-';
                } else if ((i > 0 && j == 0) || (i > 0 && j == this.canvasWidth - 1)) {
                    this.canvas[i][j] = '|';
                }
            }
        }

        renderCanvas();
    }

    /**
     * Display the canvas on console
     */
    private void renderCanvas() {
        for (int i = 0; i < this.canvasHeight; i++) {
            for (int j = 0; j < this.canvasWidth; j++) {
                System.out.print(this.canvas[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Draw line command was issued. Determine the elements of the canvas that needs to set with required characters
     */
    public void drawLine(int startX, int startY, int endX, int endY) throws Exception {
        if (this.canvasHeight == 0 || this.canvasWidth == 0) {
            throw new Exception("Initialize canvas with proper width and height using command \"C width height\"");
        }

        // validate if the coordinates are within the canvas area. If the cooridnates lie outside then throw exception
        if ((startX > 0 && startX < this.canvasWidth - 1) && (endX > 0 && endX < this.canvasWidth - 1)
                && (startY > 0 && startY < this.canvasHeight - 1) && (endY > 0 && endY < this.canvasHeight - 1)) {
            // Draw Vertical line
            if (startX == endX) {
                if (endY > startY) {
                    for (int i = startY - 1; i <= endY; i++) {
                        this.canvas[i][startX] = 'x';
                    }
                } else if (startY > endY) {
                    for (int i = startY - 1; i > endY; i--) {
                        this.canvas[i][startX] = 'x';
                    }
                }
            } else if (startY == endY) {// Draw Horizontal line
                if (endX > startX) {
                    for (int i = startX; i <= endX; i++) {
                        this.canvas[startY][i] = 'x';
                    }
                } else if (startX > endX) {
                    for (int i = startX; i >= endX; i--) {
                        this.canvas[startY][i] = 'x';
                    }
                }
            } else {
                throw new Exception("Cannot draw line, either x co-ordinates or y co-ordinates should be same ");
            }
        } else {
            throw new Exception("Cannot draw line, invalid co-ordinates");
        }

        renderCanvas();
    }

    /**
     * Draw rectangle command was issued. Determine the rectangle elements that need to be set and set them with character x
     */
    public void drawRectangle(int startX, int startY, int endX, int endY) throws Exception {
        if (this.canvasHeight == 0 || this.canvasWidth == 0) {
            throw new Exception("Initialize canvas with proper width and height");
        }
        // validate if the coordinates are within the canvas area. If the coordinates lie outside then throw exception
        if ((startX > 0 && startX < this.canvasWidth - 1) && (endX > 0 && endX < this.canvasWidth - 1)
                && (startY > 0 && startY < this.canvasHeight - 1) && (endY > 0 && endY < this.canvasHeight - 1)) {

            // ensure the coordinates are not representing line
            if (startX != endX && startY != endY) {
                if ((endX > startX) && endY > startY) {
                    for (int i = startY; i <= endY; i++) {
                        for (int j = startX; j <= endX; j++) {
                            if ((i == startY || i == endY) && j >= startX) {
                                this.canvas[i][j] = 'x';
                            } else if ((i > startY && j == startX) || (i > startY && j == endX)) {
                                this.canvas[i][j] = 'x';
                            } else {
                                this.canvas[i][j] = ' ';
                            }
                        }
                    }
                }
            }

        } else {
            throw new Exception("Cannot draw rectangle, invalid cooridnate");
        }

        renderCanvas();
    }

    /**
     * Method acts as the fill function in paint.
     */
    public void fill(int pointX, int pointY, Color color) throws Exception {
        if (this.canvasHeight == 0 || this.canvasWidth == 0) {
            throw new Exception("Initialize canvas with proper width and height");
        }

        if ((pointX > 0 && pointX < this.canvasWidth - 1) && (pointY > 0 && pointY < this.canvasHeight - 1)) {
            if (this.canvas[pointY][pointX] != 'x') {

                // Fill the all elements below the given coordinates
                for (int i = pointY; i < this.canvasHeight - 1; i++) {
                    // Method fills left and right side of the coordinates
                    fillCanvas(pointX, i, color, "up");
                }

                // Fill all the elements above the given coordinates
                for (int i = pointY; i > 0; i--) {
                    // Method fills left and right side of the coordinates
                    fillCanvas(pointX, i, color, "down");
                }

            } else {
                throw new Exception("Invalid location to fill Canvas");
            }
        } else {
            throw new Exception("Cannot fill canvas, invalid coordinate");
        }

        renderCanvas();
    }

    /**
     * Method to fill the canvas or rectangle.
     * 
     * @param x
     * @param y
     * @param color
     */
    private void fillCanvas(int pointX, int pointY, Color color, String direction) {

        int charCount = 0;
        boolean existsLineorRect = false;
        for (int j = pointX; j < this.canvasWidth - 1; j++) {
            if (this.canvas[pointY][j] != 'x' && this.canvas[pointY][j] != ' ' && !existsLineorRect) {
                this.canvas[pointY][j] = color.getColor();
            } else {
                if (this.canvas[pointY][j] == 'x') {
                    if (existsLineorRect) {
                        charCount--;
                        if (charCount == 0) {
                            existsLineorRect = false;
                        }
                    } else {
                        charCount++;
                        existsLineorRect = true;
                    }
                }
            }
        }

        existsLineorRect = false;

        for (int j = pointX; j > 0; j--) {
            if (this.canvas[pointY][j] != 'x' && this.canvas[pointY][j] != ' ' && !existsLineorRect) {
                this.canvas[pointY][j] = color.getColor();
            } else {
                if (this.canvas[pointY][j] == 'x') {
                    if (existsLineorRect) {
                        charCount--;
                        if (charCount == 0) {
                            existsLineorRect = false;
                        }
                    } else {
                        charCount++;
                        existsLineorRect = true;
                    }
                }
            }
        }

        if (direction.equals("up")) {
            if (((pointY + 1) < this.canvasHeight - 1) && this.canvas[pointY + 1][pointX] == 'x') {
                return;
            }
        } else if (direction.equals("down")) {
            if (((pointY - 1) < this.canvasHeight - 1) && this.canvas[pointY - 1][pointX] == 'x') {
                return;
            }
        }
    }
    
    public int getCanvasHeight() {
        return this.canvasHeight;
    }
    
    public int getCanvasWidth() {
        return this.canvasWidth;
    }
    
    public char[][] getCanvas(){
        return this.canvas;
    }

}
