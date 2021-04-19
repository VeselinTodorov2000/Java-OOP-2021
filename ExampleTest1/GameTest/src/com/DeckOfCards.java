package com;

import cards.Card;
import cards.FaceOfCard;
import cards.SuitOfCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    private final static int CARDS_NUMBER = 52;
    private final static String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private final static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private ArrayList<Card> cards;
    private int currentCard;

    public DeckOfCards()
    {
        cards = new ArrayList<Card>();

        //loop for faces
        for(int counter = 0; counter < 52; counter++)
        {
            //create needed card
            Card toAdd = new Card(new FaceOfCard(faces[counter % 13]), new SuitOfCard(suits[counter / 13]));
            //add the card to the array list
            cards.add(toAdd);
        }
        currentCard = 0;
    }

    public void shuffleCards()
    {
        Random r = new Random();

        for (int i = 0; i < 52; i++)
        {
            int chosenCard = r.nextInt(CARDS_NUMBER);

            Card temp = cards.get(chosenCard);
            cards.set(chosenCard, cards.get(i));
            cards.set(i, temp);
        }

        currentCard = 0;
    }

    public Card[] dealFive()
    {
        Card[] dealed = new Card[5];
        for (int cardsDealed = 0; cardsDealed < dealed.length; cardsDealed++)
        {
            if(currentCard < CARDS_NUMBER)
            {
                dealed[cardsDealed] = cards.get(currentCard);
                currentCard++;
            }
            else
            {
                dealed[cardsDealed] = null;
            }
        }

        return dealed;
    }

    public static void sortByFaceCards(ArrayList<Card> list)
    {
        for(int i = 0; i < faces.length; i++)
        {
            for (Card current : list)
            {
                if(current.getFace().getFace().compareTo(faces[i]) == 0)
                {
                    System.out.println(current.toString());
                }
            }
        }
    }

    public void printBySuits()
    {
        for(int i = 0; i < suits.length; i++)
        {
            System.out.println(suits[i]);
            System.out.println("-------");
            for (Card current : this.cards)
            {
                if(current.getSuit().getSuit().compareTo(suits[i]) == 0)
                {
                    System.out.println(current.toString());
                }
            }
        }
    }

    public ArrayList<FaceOfCard> getDistinctFaces(Card[] cards)
    {
        ArrayList<FaceOfCard> distinctFaces = new ArrayList<FaceOfCard>();

        for(int i = 0; i < faces.length; i++)
        {
            for (int card = 0; card < cards.length; card++)
            {
                if(cards[card].getFace().getFace().compareTo(faces[i]) == 0)
                {
                    distinctFaces.add(new FaceOfCard(faces[i]));
                    break;
                }
            }
        }
        return distinctFaces;
    }

    public static void main(String[] args) {
        DeckOfCards d = new DeckOfCards();
        d.shuffleCards();
        Card[] deal = d.dealFive();
        sortByFaceCards(d.cards);
        ArrayList<FaceOfCard> dist = d.getDistinctFaces(deal);
        for(FaceOfCard f : dist)
        {
            System.out.println(f.getFace());
        }
    }
}
