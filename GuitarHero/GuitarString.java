// This program models a vibrating guitar string of a given frequency.

import java.util.*;

public class GuitarString {
    public static final double ENERGY_DECAY = 0.996;
    private Queue<Double> ringBuffer;
    
    /*
     * Constructs a GuitarString with the given frequency 
     * This will initialize the ring buffer to represent a guitar
     * string at rest by filling the ring buffer with zeros.
     * @throws - IllegalArgumentException if the frequnecy is less than
     *           or equal to 0 and if the capacity of the ringbuffer is
     *           less than 2
     * @param frequency - the given frequency; initializes the ring buffer
     *                    with all zeros to represent that the string is at rest
    */ 
    public GuitarString(double frequency) {
        double capacityN = (int) (Math.round(StdAudio.SAMPLE_RATE / frequency));
        if (frequency <= 0 || capacityN < 2) {
            throw new IllegalArgumentException();
        }
        ringBuffer = new LinkedList<Double>();
        for (int i = 0; i < capacityN; i++) {
            ringBuffer.add(0.0);
        }
    }

    /*
     * Constructs a GuitarString and initializes the contents of the ring buffer
     * @throws - IllegalArgumentException if the size of the given values is less
     *           than 2
     * @param init - the inital values given; initializes the ring buffer to be filled 
     *               with init's contents
    */ 
    public GuitarString(double[] init) {
        if (init.length < 2) {
            throw new IllegalArgumentException();
        }
        ringBuffer = new LinkedList<Double>();
        for (int i = 0; i < init.length; i++) {
            ringBuffer.add(init[i]);
        }
    }

    /*
     * Replaces the ring buffer with white noise
    */ 
    public void pluck() {
        for (int i = 0; i < ringBuffer.size(); i++) {
            ringBuffer.add(Math.random() - 0.5);
            ringBuffer.remove();
        }
    }

    /*
     * Updates the simulation once through the Karplus-Strong Synthesis
    */ 
    public void tic() {
        double front = ringBuffer.remove();
        double second = ringBuffer.peek();
        double average = ((front + second) / 2) * ENERGY_DECAY;
        ringBuffer.add(average);
    }

    /*
     * Returns the current sample
     * @return - returns the current sample
    */ 
    public double sample() {
        return ringBuffer.peek();
    }
}
