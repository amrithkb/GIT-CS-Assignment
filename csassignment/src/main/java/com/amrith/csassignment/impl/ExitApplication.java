package com.amrith.csassignment.impl;

import com.amrith.csassignment.DrawCommand;

public class ExitApplication implements DrawCommand {

    public ExitApplication() {
    }

    /**
     * This method call will terminate the application
     */
    public void draw() throws Exception {
        System.out.println("Terminating Application");
        System.exit(0);
    }

}
