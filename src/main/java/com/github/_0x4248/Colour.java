/**
 * XC
 * XML Command Line Tool
 * GitHub: https://www.github.com/0x4248/XC
 * Licence: GNU General Public License v3.0
 * Author: 0x4248
 *
 * Colour - Colouring and styling for the console
 */

package com.github._0x4248;

/**
 * Colour - A simple class for setting
 */
class Colour {
    /**
     * colour_on - A boolean to enable or disable the colouring
     */
    public static boolean colour_on = true;

    /**
     * setColour - Set the colour of the text
     * <br>
     * <br>
     * If the colour is not provided, the default colour is reset (resets the colour to the default)
     * <br>
     * <br>
     * <blockquote><pre>
     *     Colour.setColour("red") - Sets the colour to red
     *     Colour.setColour(null) - Resets the colour to the default
     *     Colour.setColour("green") - Sets the colour to green
     *     Colour.setColour("yellow") - Sets the colour to yellow
     *     Colour.setColour("blue") - Sets the colour to blue
     * </pre></blockquote>
     *
     * @param colour - The colour of the text (red, green, yellow, blue, magenta, cyan, white, black)
     * @return - The colour code for the text
     */
    public static String setColour(String colour) {
        if (colour_on) {
            return switch (colour) {
                case "red" -> "\u001B[31m";
                case "green" -> "\u001B[32m";
                case "yellow" -> "\u001B[33m";
                case "blue" -> "\u001B[34m";
                case "magenta" -> "\u001B[35m";
                case "cyan" -> "\u001B[36m";
                case "white" -> "\u001B[37m";
                case "black" -> "\u001B[30m";
                case null, default -> "\u001B[0m";
            };
        } else {
            return "";
        }
    }

}
