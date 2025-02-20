//Card Collection System

import java.util.*;

class Card {
    private String suit;
    private String rank;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return Objects.equals(suit, card.suit) && Objects.equals(rank, card.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }
}

class CardCollection {
    private Map<String, Set<Card>> cardMap;

    public CardCollection() {
        cardMap = new HashMap<>();
    }

    public void addCard(String rank, String suit) {
        Card card = new Card(rank, suit);
        cardMap.putIfAbsent(suit, new HashSet<>());
        if (!cardMap.get(suit).add(card)) {
            System.out.println("Error: Card \"" + card + "\" already exists.");
        } else {
            System.out.println("Card added: " + card);
        }
    }

    public void removeCard(String rank, String suit) {
        if (cardMap.containsKey(suit)) {
            Set<Card> suitCards = cardMap.get(suit);
            Card cardToRemove = new Card(rank, suit);
            if (suitCards.remove(cardToRemove)) {
                System.out.println("Card removed: " + cardToRemove);
                if (suitCards.isEmpty()) {
                    cardMap.remove(suit);
                }
            } else {
                System.out.println("Error: Card not found.");
            }
        } else {
            System.out.println("Error: Suit not found.");
        }
    }

    public void findCardsBySuit(String suit) {
        if (cardMap.containsKey(suit) && !cardMap.get(suit).isEmpty()) {
            for (Card card : cardMap.get(suit)) {
                System.out.println(card);
            }
        } else {
            System.out.println("No cards found for " + suit + ".");
        }
    }

    public void displayAllCards() {
        if (cardMap.isEmpty()) {
            System.out.println("No cards found.");
        } else {
            for (Set<Card> suitCards : cardMap.values()) {
                for (Card card : suitCards) {
                    System.out.println(card);
                }
            }
        }
    }
}

public class CardCollectionSystem {
    public static void main(String[] args) {
        CardCollection cardCollection = new CardCollection();

        // Test Case 1: No Cards Initially
        System.out.println("Test Case 1: No Cards Initially");
        cardCollection.displayAllCards();
        System.out.println();

        // Test Case 2: Adding Cards
        System.out.println("Test Case 2: Adding Cards");
        cardCollection.addCard("Ace", "Spades");
        cardCollection.addCard("King", "Hearts");
        cardCollection.addCard("10", "Diamonds");
        cardCollection.addCard("5", "Clubs");
        System.out.println();

        // Test Case 3: Finding Cards by Suit
        System.out.println("Test Case 3: Finding Cards by Suit");
        cardCollection.findCardsBySuit("Hearts");
        System.out.println();

        // Test Case 4: Searching Suit with No Cards
        System.out.println("Test Case 4: Searching Suit with No Cards");
        cardCollection.findCardsBySuit("Diamonds");
        System.out.println();

        // Test Case 5: Displaying All Cards
        System.out.println("Test Case 5: Displaying All Cards");
        cardCollection.displayAllCards();
        System.out.println();

        // Test Case 6: Preventing Duplicate Cards
        System.out.println("Test Case 6: Preventing Duplicate Cards");
        cardCollection.addCard("King", "Hearts");
        System.out.println();

        // Test Case 7: Removing a Card
        System.out.println("Test Case 7: Removing a Card");
        cardCollection.removeCard("10", "Diamonds");
        System.out.println();
    }
}



//OUTPUT

Test Case 1: No Cards Initially
No cards found.

Test Case 2: Adding Cards
Card added: Ace of Spades
Card added: King of Hearts
Card added: 10 of Diamonds
Card added: 5 of Clubs

Test Case 3: Finding Cards by Suit
King of Hearts

Test Case 4: Searching Suit with No Cards
10 of Diamonds

Test Case 5: Displaying All Cards
Ace of Spades
King of Hearts
10 of Diamonds
5 of Clubs

Test Case 6: Preventing Duplicate Cards
Error: Card "King of Hearts" already exists.

Test Case 7: Removing a Card
Card removed: 10 of Diamonds

