package cards;

import static cards.Face.*;
import static cards.Suit.*;

public class Card {
    public static Face[] faces = {ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT,SEVEN };
    public static Suit[] suits = {CLUBS, DIAMONDS, HEARTS , SPADES};

    private int face;
    private int suit;

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face < faces.length ? face : 0;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit < suits.length ? suit : 0;
    }

    public Card(int face, int suit) {
        this.setFace(face);
        this.setSuit(suit);
    }

    public String getSuitName()
    {
        return suits[suit].toString();
    }

    @Override
    public String toString() {
        return faces[face].toString() + " of " + getSuitName();
    }
}
