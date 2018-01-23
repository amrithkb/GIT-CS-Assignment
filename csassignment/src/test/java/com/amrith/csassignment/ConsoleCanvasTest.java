package com.amrith.csassignment;

import com.amrith.csassignment.ICanvas;
import com.amrith.csassignment.impl.ConsoleCanvas;
import com.amrith.csassignment.impl.CreateCanvas;
import com.amrith.csassignment.impl.DrawLine;
import com.amrith.csassignment.impl.DrawRectangle;
import com.amrith.csassignment.impl.FillCanvas;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.MatcherAssert.assertThat;

import junit.framework.TestCase;

public class ConsoleCanvasTest extends TestCase {
    /**
     * Junit testcase Constructor
     * 
     * @param testName
     */
    public ConsoleCanvasTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testCanvasConsoleCreate() {
        System.out.println("Running create canvas test");
        ICanvas consoleCanvas = new ConsoleCanvas();
        DrawCommand command = new CreateCanvas(consoleCanvas, 10, 4);
        try {
            command.draw();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        char[][] canvas = { { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                { '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };

        assertThat(consoleCanvas, hasProperty("canvas", is(canvas)));
    }

    /**
     * Test the DrawLine command feature
     */
    public void testDrawLine() {
        System.out.println("Running single line create test");
        ICanvas consoleCanvas = new ConsoleCanvas();
        DrawCommand command = null;
        try {
            command = new CreateCanvas(consoleCanvas, 10, 4);
            command.draw();
            command = new DrawLine(consoleCanvas, 1, 2, 5, 2);
            command.draw();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        char[][] canvas = { { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                { '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '|', 'x', 'x', 'x', 'x', 'x', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };

        assertThat(consoleCanvas, hasProperty("canvas", is(canvas)));
    }

    public void testDrawMultipleLine() {
        System.out.println("Running multiple line creation test");
        ICanvas consoleCanvas = new ConsoleCanvas();
        DrawCommand command = null;
        try {
            command = new CreateCanvas(consoleCanvas, 10, 4);
            command.draw();
            command = new DrawLine(consoleCanvas, 1, 2, 5, 2);
            command.draw();
            command = new DrawLine(consoleCanvas, 5, 3, 5, 4);
            command.draw();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        char[][] canvas = { { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                { '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '|', 'x', 'x', 'x', 'x', 'x', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '|', '\u0000', '\u0000', '\u0000', '\u0000', 'x', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '|', '\u0000', '\u0000', '\u0000', '\u0000', 'x', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };

        assertThat(consoleCanvas, hasProperty("canvas", is(canvas)));
    }
    
    /**
     * Test Rectangle draw
     */
    public void testDrawRectangle() {
        System.out.println("Running rectanle draw test");
        ICanvas consoleCanvas = new ConsoleCanvas();
        DrawCommand command = null;
        try {
            command = new CreateCanvas(consoleCanvas, 10, 4);
            command.draw();            
            command = new DrawRectangle(consoleCanvas, 2, 1, 6, 4);
            command.draw();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        char[][] canvas = { { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                { '|', '\u0000', 'x', 'x', 'x', 'x', 'x', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '|', '\u0000', 'x', ' ', ' ', ' ', 'x', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '|', '\u0000', 'x', ' ', ' ', ' ', 'x', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '|', '\u0000', 'x', 'x', 'x', 'x', 'x', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
                { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };

        assertThat(consoleCanvas, hasProperty("canvas", is(canvas)));
    }
    
    /**
     * Test Fill Canvas without line or rectangle
     */
    public void testFillCanvas() {
        System.out.println("Running fill canvas test");
        ICanvas consoleCanvas = new ConsoleCanvas();
        DrawCommand command = null;
        try {
            command = new CreateCanvas(consoleCanvas, 10, 4);
            command.draw();
            command = new FillCanvas(consoleCanvas, new Color('o'), 2, 3);
            command.draw();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        char[][] canvas = { { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                            { '|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|' },
                            { '|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|' },
                            { '|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|' },
                            { '|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|' },
                            { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };

        assertThat(consoleCanvas, hasProperty("canvas", is(canvas)));
    }
    
    /**
     * Test Fill Canvas wit line
     */
    public void testFillCanvasWithLine() {
        System.out.println("Running fill canvas test with line");
        ICanvas consoleCanvas = new ConsoleCanvas();
        DrawCommand command = null;
        try {
            command = new CreateCanvas(consoleCanvas, 10, 4);
            command.draw();
            //Draw a line and then fill
            command = new DrawLine(consoleCanvas, 1, 2, 5, 2);
            command.draw();
            command = new FillCanvas(consoleCanvas, new Color('o'), 2, 3);
            command.draw();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        char[][] canvas = { { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                            { '|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|' },
                            { '|', 'x', 'x', 'x', 'x', 'x', 'o', 'o', 'o', 'o', 'o', '|' },
                            { '|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|' },
                            { '|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|' },
                            { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };

        assertThat(consoleCanvas, hasProperty("canvas", is(canvas)));
    }
    
    /**
     * Test Fill Canvas wit rectangle
     */
    public void testFillCanvasWithRectangle() {
        System.out.println("Running fill canvas test with rectangle");
        ICanvas consoleCanvas = new ConsoleCanvas();
        DrawCommand command = null;
        try {
            command = new CreateCanvas(consoleCanvas, 10, 4);
            command.draw();
            //Draw a line and then fill
            command = new DrawRectangle(consoleCanvas, 2, 1, 6, 4);
            command.draw();
            command = new FillCanvas(consoleCanvas, new Color('o'), 7, 3);
            command.draw();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        char[][] canvas = { { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                            { '|', '\u0000', 'x', 'x', 'x', 'x', 'x', 'o', 'o', 'o', 'o', '|' },
                            { '|', 'o', 'x', ' ', ' ', ' ', 'x', 'o', 'o', 'o', 'o', '|' },
                            { '|', 'o', 'x', ' ', ' ', ' ', 'x', 'o', 'o', 'o', 'o', '|' },
                            { '|', '\u0000', 'x', 'x', 'x', 'x', 'x', 'o', 'o', 'o', 'o', '|' },
                            { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };

        assertThat(consoleCanvas, hasProperty("canvas", is(canvas)));
    }

}
