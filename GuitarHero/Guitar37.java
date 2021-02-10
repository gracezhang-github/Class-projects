// This program is a different implementation of the Guitar interface,
// this will model a guitar with 37 different strings.

import java.util.*;

public class Guitar37 implements Guitar {
    public static final String KEYBOARD =
        "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout

    private GuitarString[] strings;
    private int ticNum;
    
    /*
     * Constructs an implementation of the Guitar Interface,
     *      creates GuitarString object with 37 strings on the
     *      chromatic scale from 110Hz to 880Hz
    */ 
    public Guitar37() {
        ticNum = 0;
        strings = new GuitarString[KEYBOARD.length()];
        for (int i = 0; i < KEYBOARD.length(); i++) {
            strings[i] = new GuitarString(440.0 * Math.pow(2, ((i - 24.0) / 12.0)));
        }
    }

    /*
     * Plays a given note by passing in a pitch, where illegal
     *      pitches will be ignored. In this case, the allowed 
     *      legal pitch range will be from 110Hz to 880Hz
     * @param pitch - an integer where the value 0 represents
     *                concert-A and all other notes are specified
     *                relative to concert A using a chromatic scale.
     *                Illegal pitches will be ignored, legal pitches
     *                are classified between 110Hz - 880 Hz
    */ 
    public void playNote(int pitch) {
        int index = pitch + 24;
        if ((index < KEYBOARD.length()) && (index >= 0)) {
            strings[index].pluck();
        } 
    }

    /*
     * Verifies if a particular input key in the guitar
     * @param key - the inputted key to verify
     * @return - returns true if the key is in the guitar,
     *           return false if not
    */ 
    public boolean hasString(char key) {
        return KEYBOARD.indexOf(key) != -1;
    }

    /*
     * Checks if the key is legal for the guitar
     * Decides which note to play with the specified character
     *      given by client and then produce the appropriate output 
     * @throws - IllegalArgumentException if the key is not one of the 
     *           37 keys it's designed to play/checks if the key is legal
     * @param key - the inputted key to check for legality and to play the
     *              appropriate output
    */ 
    public void pluck(char key) {
        if (!hasString(key)) {
            throw new IllegalArgumentException();
        }
        strings[KEYBOARD.indexOf(key)].pluck();
    }

    /*
     * Retrieves the current sound sumple
     * @return - the total current sound sample
    */ 
    public double sample() {
        double sampleSum = 0.0;
        for (int i = 0; i < KEYBOARD.length(); i++) {
            sampleSum += strings[i].sample();
        }
        return sampleSum;
    }

    /*
     * Advances the time forward one tic
    */ 
    public void tic() {
        for (int i = 0; i < KEYBOARD.length(); i++) {
            strings[i].tic();
        }
        ticNum++;
    }
    /*
     * Determines the current time - number of times tic has been called
     * @return - the total number of times tic was called
    */ 
    public int time() {
        return ticNum;
    }

}
