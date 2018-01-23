package com.amrith.csassignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.amrith.csassignment.impl.ConsoleCanvas;
import com.amrith.csassignment.impl.CreateCanvas;
import com.amrith.csassignment.impl.DrawLine;
import com.amrith.csassignment.impl.DrawRectangle;
import com.amrith.csassignment.impl.ExitApplication;
import com.amrith.csassignment.impl.FillCanvas;

public class RunAssignment {
    /**
     * Main method to run the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        System.out.println("*************************************************************");
        System.out.println("*           Welcome to console canvas application           *");
        System.out.println("*************************************************************");
        System.out.println("Please enter command:");
        RunAssignment application = new RunAssignment();
        application.runApplication();
    }

    public void runApplication() {
        DrawCommand command = null;
        ICanvas canvas = new ConsoleCanvas();

        BufferedReader reader = null;

        while (true) {
            try {
                // create BufferReader object for inputstream
                reader = new BufferedReader(new InputStreamReader(System.in));
                String inputCommand = reader.readLine();
                // validate command to ensure it is as per defined format. If the command is as per
                // defined format method checkCommand returns the object of DrawCommand
                command = checkCommand(inputCommand.trim(), canvas);

                // call method on command to perform the action.
                if (command != null) {
                    command.draw();
                } else {
                    System.out.println("Invalid command");
                }
                System.out.println("Please enter command:");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {

            }
        }
    }

    /**
     * Method to validates command string and returns appropriate command object for processing
     * 
     * @param inputCommand
     * @param canvas
     * @return
     */
    private DrawCommand checkCommand(String inputCommand, ICanvas canvas) {
        DrawCommand command = null;
        
        String strippedCommand = removeExtraSpace(inputCommand);
        String[] commandArgs = strippedCommand.split(" ");

        try {
            if (commandArgs[0].equals("Q")) {
                command = new ExitApplication();
            } else if (commandArgs[0].equalsIgnoreCase("C")) {

                if (commandArgs.length == 3 && Integer.parseInt(commandArgs[1]) > 0 && Integer.parseInt(commandArgs[2]) > 0) {
                    command = new CreateCanvas(canvas, Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]));
                }

            } else if (commandArgs[0].equalsIgnoreCase("L")) {

                if (commandArgs.length == 5 && Integer.parseInt(commandArgs[1]) > 0 && Integer.parseInt(commandArgs[2]) > 0
                        && Integer.parseInt(commandArgs[3]) > 0 && Integer.parseInt(commandArgs[4]) > 0) {

                    command = new DrawLine(canvas, Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]),
                            Integer.parseInt(commandArgs[3]), Integer.parseInt(commandArgs[4]));
                }
            } else if (commandArgs[0].equalsIgnoreCase("R")) {

                if (commandArgs.length == 5 && Integer.parseInt(commandArgs[1]) > 0 && Integer.parseInt(commandArgs[2]) > 0
                        && Integer.parseInt(commandArgs[3]) > 0 && Integer.parseInt(commandArgs[4]) > 0) {

                    command = new DrawRectangle(canvas, Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]),
                            Integer.parseInt(commandArgs[3]), Integer.parseInt(commandArgs[4]));
                }
            } else if (commandArgs[0].equalsIgnoreCase("B")) {

                if (commandArgs.length == 4 && Integer.parseInt(commandArgs[1]) > 0 && Integer.parseInt(commandArgs[2]) > 0) {
                    Color color = new Color(commandArgs[3].toCharArray()[0]);
                    command = new FillCanvas(canvas, color, Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]));
                }

            }
        } catch (Exception e) {
            // System.out.println(e.getMessage());
        }

        return command;
    }

    /**
     * Strips extra spaces within command
     * 
     * @param command
     * @return
     */
    private String removeExtraSpace(String command) {
        StringBuilder str = new StringBuilder();
        boolean hasSpace = false;

        for (char c : command.toCharArray()) {
            if (c != ' ') {
                str.append(c);
                hasSpace = false;
            } else if (c == ' ' && !hasSpace) {
                str.append(c);
                hasSpace = true;
            }
        }

        return str.toString();
    }

}
