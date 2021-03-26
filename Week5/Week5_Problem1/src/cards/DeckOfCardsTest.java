// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing application.
package cards;
public class DeckOfCardsTest
{
   // execute application
   public static void main( String args[] )
   {
      DeckOfCards myDeckOfCards = new DeckOfCards();
      myDeckOfCards.shuffle(); // place Cards in random order

      Card[] leftHand = myDeckOfCards.dealHand();
      Card[] rightHand = myDeckOfCards.dealHand();

      System.out.printf("%-20s%-20s\n", "Left hand:", "Right hand: ");
      for ( int i = 0; i < leftHand.length; i++ ){
         System.out.printf("%-20s%-20s\n", leftHand[i], rightHand[i]);
      }

      System.out.printf("\n%-20s\n", "Hand values:");
      int[] leftHandStrength = strengths(leftHand, myDeckOfCards);
      int[] rightHandStrength = strengths(rightHand, myDeckOfCards);

      for (int i = 0; i < leftHandStrength.length; i++){
         if(leftHandStrength[i] > rightHandStrength[i]){
            System.out.println("Result: left hand is better");
            System.exit(0);
         }
         if(leftHandStrength[i] < rightHandStrength[i]){
            System.out.println("Result: right hand is better");
            System.exit(0);
         }
      }
      /*
      // print all 52 Cards in the order in which they are dealt
      for ( int i = 0; i < 13; i++ )
      {
         // deal and print 4 Cards
         System.out.printf( "%-20s%-20s%-20s%-20s\n",
            myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),
            myDeckOfCards.dealCard(), myDeckOfCards.dealCard() );
      } // end for

       */
   } // end main

   public static int[] strengths(Card[] hand, DeckOfCards deck){
      int strengths[] = new int[7];

      int couples = deck.pairs(hand);
      int triples = deck.triples(hand);

      if(deck.fourOfAKind(hand)){
         strengths[0] = 1;
         System.out.printf("%-20s", "Four of a Kind");
         return strengths;
      }
      if(deck.fullHouse(couples,triples)){
         strengths[1] = 1;
         System.out.printf("%-20s", "Full House");
         return strengths;
      }
      if(deck.flush(hand)){
         strengths[2] = 1;
         System.out.printf("%-20s", "Flush");
         return strengths;
      }
      if(deck.straight(hand)){
         strengths[3] = 1;
         System.out.printf("%-20s", "Straight");
         return strengths;
      }
      if(deck.threeOfAKind(triples)){
         strengths[4] = 1;
         System.out.printf("%-20s", "Three of a Kind");
         return strengths;
      }
      if(deck.twoPair(couples)){
         strengths[5] = 1;
         System.out.printf("%-20s", "Two Pair");
         return strengths;
      }
      if(deck.pair(couples)){
         strengths[6] = 1;
         System.out.printf("%-20s", "One Pair");
         return strengths;
      }
      System.out.printf("%-20s", "None");
      return strengths;
   }
} // end class DeckOfCardsTest

