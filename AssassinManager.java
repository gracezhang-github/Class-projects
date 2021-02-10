// This program models the Assassin game, where this will keep track of 
// who is stalking and killing whom

import java.util.*;

public class AssassinManager {
    private AssassinNode frontKill;
    private AssassinNode frontGraveyard;
    
    /*
     * Constructs and initializes a new assassin manager with the given list of names
     * @throws - IllegalArgumentException if the given list is empty
     * @param names - the given list of people names
    */ 
    public AssassinManager(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (int i = names.size() - 1; i >= 0; i--) {
            frontKill = new AssassinNode(names.get(i), frontKill);
        }
    }

    /*
     * Prints out the names of the people in the kill ring
    */ 
    public void printKillRing() {
        AssassinNode current = frontKill;
        while (current.next != null) {
            System.out.println("    " + current.name + " is stalking " + current.next.name);
            current = current.next;
        }
        System.out.println("    " + current.name + " is stalking " + frontKill.name);
    }

    /*
     * Prints out the names of the people in the graveyard
    */ 
    public void printGraveyard() {
        AssassinNode current = frontGraveyard;
        while (current != null) {
            System.out.println("    " + current.name + " was killed by " + frontGraveyard.killer);
            current = current.next;
        }
    }

    /*
     * Returns true if the given name (where the cases of letters are ignored) 
     * is in the current kill ring, if not, return false.
     * @param name - the given name to check if they are in the kill ring
     * @return - returns true if the given name is in the kill ring, return
     * false otherwise
    */ 
    public boolean killRingContains(String name) {
        return contains(name, frontKill);
    }

    /*
     * Constructs a helper method to avoid redundancy for both
     * the killRingContains and the graveyardContains method
     * @param name, type - the given name to check if they are in 
     *                     the AssassinNode type (killRing or Graveyard)
     * @return - returns true if the given name is in the type (specified
     *           when its called by either killRingContains or graveyardContains),
     *           return false if not
    */
    private boolean contains(String name, AssassinNode type) {
        AssassinNode current = type;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /*
     * Returns true if the given name (where the cases of letters are ignored) 
     * is in the current graveyard, if not, return false.
     * @param name - the given name to check if they are in the graveyard
     * @return - returns true if the given name is in the graveyard, return
     * false otherwise
    */ 
    public boolean graveyardContains(String name) {
        return contains(name, frontGraveyard);
    }

    /* Game is over if the kill ring contains only one person
     * @return - Returns true if the game is over and returns false if not
    */ 
    public boolean gameOver() {
        return frontKill.next == null;
    }

    /*
     * The winner will be the last person in the kill ring
     * @return - returns the name of the winner of the game,
     *           if game is not over, return null
    */ 
    public String winner() {
        if (!gameOver()) {
            return null;
        }
        return frontKill.name;
    }

    /*
     * Records the assassination of the person with the given name, 
     * (where the cases of the name is ignored)
     * then moves the person to the graveyard
     * @param name - the given name to record the assassination of
     * @throws - IllegalStateException if the game is over and if both the 
     *           conditions of game is over and the given name is not part of
     *           the kill ring is met
     * @throws - IllegalArgumentException if the given name is not part
     *           of the kill ring
    */ 
    public void kill(String name) {
        AssassinNode current = frontKill;
        AssassinNode died = frontGraveyard;
        if (gameOver()) {
            throw new IllegalStateException();
        } else if (!killRingContains(name)) {
            throw new IllegalArgumentException();
        }

        if (current.name.equalsIgnoreCase(name)) {
            died = current;
            while (current.next != null) {
                current = current.next;
            }
            frontKill = frontKill.next;
        } else {
            while (!current.next.name.equalsIgnoreCase(name)) {
                current = current.next;
            }
            died = current.next;
            current.next = current.next.next;
        }
        died.killer = current.name;
        died.next = frontGraveyard;
        frontGraveyard = died;
    }
}
