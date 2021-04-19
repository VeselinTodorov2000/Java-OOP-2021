package cards;

public class Card
{
    private FaceOfCard face; //face of the card
    private SuitOfCard suit; //suit of the card

    //getter for face
    public FaceOfCard getFace() {
        return face;
    }

    //setter for face
    public void setFace(FaceOfCard face) {
        this.face = face != null ? new FaceOfCard(face.getFace()) : new FaceOfCard("Ace"); //if is invalid set "Ace" by default
    }

    //getter for suit
    public SuitOfCard getSuit() {
        return suit;
    }

    //setter for suit
    public void setSuit(SuitOfCard suit) {
        this.suit = suit != null ? new SuitOfCard(suit.getSuit()) : new SuitOfCard("Spades"); //if is invalid set "Spades" by default
    }

    //construct object with validating
    public Card(FaceOfCard face, SuitOfCard suit) {
        this.setFace(face);
        this.setSuit(suit);
    }

    //to string inherits object
    @Override
    public String toString() {
        return face.getFace() + " " + suit.getSuit();
    }
}
