
import java.util.*;

public class Player {
    private String name;
    private Card[] hand;
    private int numCards;

    public Player(String name) {
        this.name = name;
        hand = new Card[Blackjack.MAX_CARDS_PER_PLAYER];
        numCards = 0;
    }

    public String getName() {
        return name;
    }

    public int getNumCards() {
        return numCards;
    }

    public String toString() {
        return name;
    }

    public void addCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null");
        }
        if (numCards >= Blackjack.MAX_CARDS_PER_PLAYER) {
            throw new IllegalArgumentException("Player already has maximum number of cards");
        }
        hand[numCards] = card;
        numCards++;
    }

    public Card getCard(int index) {
        if (index < 0 || index >= numCards) {
            throw new IllegalArgumentException("Invalid index");
        }
        return hand[index];
    }

    public void printHand() {
        for (int i = 0; i < numCards; i++) {
            System.out.print(hand[i] + " ");
        }
        System.out.println("(value = " + getHandValue() + ")");
    }

    public int getHandValue() {
        int value = 0;
        int numAces = 0;
        for (int i = 0; i < numCards; i++) {
            Card card = hand[i];
            if (card.getRank() == 1) { // Ace
                numAces++;
                value += 11;
            } else if (card.getRank() >= 10) { // Face card
                value += 10;
            } else { // Number card
                value += card.getRank();
            }
        }
        // Handle Aces
        while (numAces > 0 && value > 21) {
            value -= 10;
            numAces--;
        }
        return value;
    }

    public boolean wantsHit(Scanner console, Player dealer) {
        if (getHandValue() >= 21) {
            return false;
        }
        System.out.print("Do you want to hit? ");
        String response = console.nextLine();
        return response.toLowerCase().startsWith("y");
    }

    public void discardCards() {
        Arrays.fill(hand, null);
        numCards = 0;
    }
}
