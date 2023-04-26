
public class Dealer extends Player {
    private boolean revealFirstCard;

    public Dealer() {
        super("dealer");
        this.revealFirstCard = false;
    }

    public void revealFirstCard() {
        this.revealFirstCard = true;
    }

    public void printHand() {
        if (!this.revealFirstCard) {
            System.out.printf("XX %s%n", this.getHandValue());
        } else {
            super.printHand();
        }
    }

    public boolean wantsHit(Player opponent) {
        int dealerScore = this.getHandValue();
        int opponentScore = opponent.getHandValue();

        if (dealerScore < 17) {
            return true;
        } else if (dealerScore == 17 && opponentScore < 17) {
            return true;
        } else {
            return false;
        }
    }

    public void discardCards() {
        super.discardCards();
        this.revealFirstCard = false;
    }
}
