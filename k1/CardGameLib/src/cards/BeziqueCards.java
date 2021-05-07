package cards;

import java.util.Random;

public class BeziqueCards {
    private Card[] cards;
    private Card[] hand;
    private Suit trump;
    private Random random;
    private int currentCard;

    public BeziqueCards()
    {
        cards = new Card[64];
        for(int count = 0; count < cards.length; count++)
        {
            Card current = new Card(count % 8, (count / 8) % 4);
            cards[count] = current;
        }
        random = new Random();
        int trumpIndex = random.nextInt(4);

        switch(trumpIndex)
        {
            case 0: trump = Suit.CLUBS; break;
            case 1: trump = Suit.DIAMONDS; break;
            case 2: trump = Suit.HEARTS; break;
            case 3: trump = Suit.SPADES; break;
        }

        currentCard = 0;
    }

    public Suit getTrump() {
        return trump;
    }

    public void shuffleCards()
    {
        for(int count = 0; count < cards.length; count++)
        {
            int secondCard = random.nextInt(64);

            Card temp = cards[count];
            cards[count] = cards[secondCard];
            cards[secondCard] = temp;
        }
        currentCard = 0;
    }

    public String printCards()
    {
        String converted = hand[0].toString();
        int rowIndex = 1;
        for(int i = 1; i < hand.length - 1; i++)
        {
            if(rowIndex == 0)
            {
                converted = String.format("%s%s", converted, hand[i].toString());
                rowIndex++;
                continue;
            }
            converted = String.format("%s, %s", converted, hand[i].toString());
            rowIndex++;
            if(rowIndex == 3)
            {
                converted = String.format("%s,\n", converted);
                rowIndex = 0;
            }
        }
        return String.format("%s, %s", converted, hand[hand.length-1].toString());
    }

    public boolean dealHand()
    {
        if(currentCard == cards.length)
        {
            return false;
        }

        if(cards.length - currentCard < 14)
        {
            hand = new Card[cards.length - currentCard];
        }
        else
        {
            hand = new Card[14];
        }

        int count = 0;
        while(currentCard < cards.length && count != hand.length)
        {
            hand[count] = cards[currentCard];
            count++;
            currentCard++;
        }

        return true;
    }

    public boolean hasMarriage()
    {
        boolean hasK = false;
        boolean hasQ = false;
        for(int i = 0; i < hand.length; i++)
        {
            if(getTrump() == Card.suits[hand[i].getSuit()] && Card.faces[hand[i].getFace()] == Face.KING)
            {
                hasK = true;
            }
            if(getTrump() == Card.suits[hand[i].getSuit()] && Card.faces[hand[i].getFace()] == Face.QUEEN)
            {
                hasQ = true;
            }
        }

        return hasK && hasQ;
    }

    public boolean hasAKQJ10()
    {
        boolean hasA = false;
        boolean has10 = false;
        boolean hasJ = false;

        for(int i = 0; i < hand.length; i++)
        {
            if(getTrump() == Card.suits[hand[i].getSuit()] && Card.faces[hand[i].getFace()] == Face.ACE)
            {
                hasA = true;
            }
            if(getTrump() == Card.suits[hand[i].getSuit()] && Card.faces[hand[i].getFace()] == Face.TEN)
            {
                has10 = true;
            }
            if(getTrump() == Card.suits[hand[i].getSuit()] && Card.faces[hand[i].getFace()] == Face.JACK)
            {
                hasJ = true;
            }
        }

        return hasA && has10 && hasJ && hasMarriage();
    }
}
