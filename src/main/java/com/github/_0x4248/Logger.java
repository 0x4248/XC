/**
 * XC
 * XML Command Line Tool
 * GitHub: https://www.github.com/0x4248/XC
 * Licence: GNU General Public License v3.0
 * Author: 0x4248
 *
 * Logger - Basic logging functions.
 */

package com.github._0x4248;

/**
 * Logger - A simple logger for logging messages to the console
 */
class Logger {
    public static boolean debug = false;
    public static boolean verbose = false;

    /**
     * debug - Log a debug message
     *
     * @param message - The message to log
     */
    public static void debug(String message) {

        if (debug) {
            System.out.println("[  " + Colour.setColour("cyan") + "DBG" + Colour.setColour(null) + "  ] " + message);
        }
    }

    /**
     * log - Log a message
     *
     * @param message - The message to log
     */
    public static void log(String message) {
        if (verbose) {
            System.out.println("[  " + Colour.setColour("green") + "LOG" + Colour.setColour(null) + "  ] " + message);
        }
    }

    /**
     * error - Log an error message
     *
     * @param message - The message to log
     */
    public static void error(String message) {
        System.out.println("[  " + Colour.setColour("red") + "ERR" + Colour.setColour(null) + "  ] " + message);
    }
}
