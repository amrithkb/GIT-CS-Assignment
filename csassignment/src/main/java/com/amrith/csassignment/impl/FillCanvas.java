package com.amrith.csassignment.impl;

import com.amrith.csassignment.Color;
import com.amrith.csassignment.DrawCommand;
import com.amrith.csassignment.ICanvas;

public class FillCanvas implements DrawCommand {

    private ICanvas canvas = null;
    private Color color = null;
    private int x = 0;
    private int y = 0;

    public FillCanvas(ICanvas canvas, Color color, int x, int y) {
        this.canvas = canvas;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public void draw() throws Exception {
        this.canvas.fill(x, y, color);

    }

}
