package com.amrith.csassignment.impl;

import com.amrith.csassignment.DrawCommand;
import com.amrith.csassignment.ICanvas;

public class DrawRectangle implements DrawCommand {

    private ICanvas canvas = null;
    private int x1 = 0;
    private int y1 = 0;
    private int x2 = 0;
    private int y2 = 0;

    public DrawRectangle(ICanvas canvas, int x1, int y1, int x2, int y2) {
        this.canvas = canvas;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void draw() throws Exception {
        this.canvas.drawRectangle(x1, y1, x2, y2);
    }

}
