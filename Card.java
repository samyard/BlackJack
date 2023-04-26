/*
 * Card.java
 *
 * A blueprint class for objects that represent a single playing card
 * that has a rank and a suit.
 * 
 * starter code: CS 112 Staff (cs112-staff@cs.bu.edu)
 * completed by: <sam yard ; samyard@bu.edu>
 */

public class Card {
    /* constants for the ranks of non-numeric cards */
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    
    /* other constants for the ranks */
    public static final int FIRST_RANK = 1;
    public static final int LAST_RANK = 13;
    
    private int rank;
    private char suit;

    /* 
     * class-constant array containing the string representations
     * of all of the card ranks. 
     * The string for the numeric rank r is given by RANK_STRINGS[r].
     */
    public static final String[] RANK_STRINGS = {
      null, "A", "2", "3", "4", "5", "6",
      "7", "8", "9", "10", "J", "Q", "K"
    };
    
    /* 
     * class-constant array containing the char representations
     * of all of the possible suits.
     */
    public static final char[] SUITS = {'C', 'D', 'H', 'S'};

    
    /* Put the rest of the class definition below. */
    public Card(int rank, char suit) {
      if (rank < 1 || rank > 13) {
          throw new IllegalArgumentException("Invalid rank: " + rank);
      }
      if (!isValidSuit(suit)) {
          throw new IllegalArgumentException("Invalid suit: " + suit);
      }
      this.rank = rank;
      this.suit = suit;
    }
  
    public Card(String cardString) {
      if (cardString == null || cardString.length() < 2 || cardString.length() > 3) {
          throw new IllegalArgumentException("Invalid card string: " + cardString);
      }
  
      String rankString = cardString.substring(0, cardString.length() - 1);
      char suit = cardString.charAt(cardString.length() - 1);
  
      int rank = rankNumFor(rankString);
  
      if (!isValidSuit(suit)) {
          throw new IllegalArgumentException("Invalid suit: " + suit);
      }
      this.rank = rank;
      this.suit = suit;
    }

    public static int rankNumFor(String rankString) {
      for (int i = 1; i < RANK_STRINGS.length; i++) {
          if (RANK_STRINGS[i].equals(rankString)) {
              return i;
          }
      }
      throw new IllegalArgumentException("Invalid rank string: " + rankString);
    }

    public static boolean isValidSuit(char suit) {
      for (int i = 0; i < SUITS.length; i++) {
          if (SUITS[i] == suit) {
              return true;
          }
      }
      return false;
    }

    public int getRank() {
      return this.rank;
    }
  
    public char getSuit() {
      return this.suit;
    }
  
    public boolean isAce() {
      return this.rank == ACE;
    }
  
    public boolean isFaceCard() {
      return this.rank == JACK || this.rank == QUEEN|| this.rank == KING;
    }
  
    public int getValue() {
      if (this.isFaceCard()) {
          return 10;
      } else {
          return this.rank;
      }
    }
    
    public String toString() {
      return RANK_STRINGS[rank] + suit;
    }
    
    public boolean sameSuitAs(Card other) {
      if (other == null) {
          return false;
      }
      return this.suit == other.suit;
    }
  
    public boolean equals(Card other) {
      if (other == null) {
          return false;
      }
      return this.rank == other.rank && this.suit == other.suit;
    }


    public static void main(String[] args) {
      // Testing rankNumFor()
      System.out.println(rankNumFor("Q") );
      System.out.println(rankNumFor("A"));
      System.out.println(rankNumFor("10"));
      // Testing isValidSuit()
      System.out.println(isValidSuit('D'));
      System.out.println(isValidSuit('B'));
    }
}
