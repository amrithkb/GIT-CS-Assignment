package com.amrith.csassignment;

public interface ICanvas {

    public void create(int height, int width);

    public void drawLine(int x1, int y1, int x2, int y2) throws Exception;

    public void drawRectangle(int x1, int y1, int x2, int y2) throws Exception;

    public void fill(int x, int y, Color color) throws Exception;

}
