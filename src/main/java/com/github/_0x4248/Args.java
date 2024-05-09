/**
 * XC
 * XML Command Line Tool
 * GitHub: https://www.github.com/0x4248/XC
 * Licence: GNU General Public License v3.0
 * Author: 0x4248
 *
 * Args - Argument parsing functions
 */

package com.github._0x4248;

public class Args {

    /**
     * parseArgs - Parse the command line arguments
     * @param args
     */
    public static void parseArgs(String[] args) {
        for (String arg : args) {
            Logger.debug("Parsing argument: " + arg);
            if (arg.startsWith("-f=")) {
                Main.file = arg.substring(3);
                Logger.debug("File: " + Main.file);
            } else if (arg.startsWith("-l=")) {
                Main.location = arg.substring(3);
                Logger.debug("Location: " + Main.location);
            } else if (arg.startsWith("-m=")) {
                Main.mode = arg.substring(3);
                Logger.debug("Mode: " + Main.mode);
            } else if (arg.startsWith("-i=")) {
                Main.input = arg.substring(3);
                Logger.debug("Input: " + Main.input);
            } else if (arg.startsWith("-")) {
                Main.flags.add(arg.substring(1));
                Logger.debug("Flag: " + arg.substring(1));
            }

            checkForMissingArgs();
        }
    }

    /**
     * checkForMissingArgs - Check for missing arguments and
     * exit if any are missing
     */
    public static void checkForMissingArgs() {
        Logger.debug("Checking for missing arguments");
        if (Main.file.isEmpty()) {
            Logger.error("No file provided");
            System.exit(1);
        }

        if (Main.location.isEmpty()) {
            Logger.error("No location provided");
            System.exit(1);
        }


        if (Main.mode.isEmpty()) {
            Logger.error("No mode provided");
            System.exit(1);
        }
    }
}
