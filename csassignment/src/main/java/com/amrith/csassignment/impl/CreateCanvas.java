package com.amrith.csassignment.impl;

import com.amrith.csassignment.DrawCommand;
import com.amrith.csassignment.ICanvas;

public class CreateCanvas implements DrawCommand {

    private ICanvas canvas = null;
    private int width = 0;
    private int height = 0;

    public CreateCanvas(ICanvas canvas, int height, int width) {
        this.canvas = canvas;
        this.width = width;
        this.height = height;
    }

    public void draw() throws Exception {
        this.canvas.create(this.height, this.width);
    }

}
