package com.toy;

import com.toy.commands.CommandParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File inputFile = null;
        if (0 < args.length) {
            inputFile = new File(args[0]);
        } else {
            System.err.println("Invalid arguments count:" + args.length);
            System.exit(0);
        }

        BufferedReader br = null;

        try {
            String command;
            CommandParser commandParser = new CommandParser();
            br = new BufferedReader(new FileReader(inputFile));
            while ((command = br.readLine()) != null) {
                commandParser.parse(command.trim().toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
