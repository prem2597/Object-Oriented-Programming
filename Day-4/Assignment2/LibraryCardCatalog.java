import java.util.*;
import java.util.Scanner;
public class LibraryCardCatalog {
    Card[] cards;
    int cardCount = 0;

    LibraryCardCatalog() {
        this.cardCount = 0;
        this.cards = new Card[10];
    }
    public void addCard(Card cardList) {
        cards[cardCount] = cardList;
        cardCount++;
    }
    public Card searchCardByTitle(String searchTitle) {
        for (int i = 0; i < cardCount; i++) {
            if (cards[i].getTitle().equals(searchTitle)) {
                return cards[i];
            }
        }
        return null;
    }
    public Card searchCardByAuthor(String author) {
        for (int i = 0; i < cardCount; i++) {
            if (cards[i].getAuthor().equals(author)) {
                return cards[i];
            }
        }
        return null;
    }
    public Card searchCardBySubject(String subject) {
        for (int i = 0; i < cardCount; i++) {
            if (cards[i].getSubject().equals(subject)) {
                return cards[i];
            }
        }
        return null;
    }
    public void removeTitle(String removeTitle) {
        for (int i = 0; i < cardCount; i++) {
            if (cards[i].getTitle().equals(removeTitle)) {
                cards[i] = null;
            }
        }
    }
    public static Card[] sortByAuthor(Card[] card) {
        Card temp;
        int y=0;
        for (int i=0; i<card.length; i++) {
            for (int j=0;j<card.length; j++) {
                if (card[j+1]==null) {
                    y=1;
                    break;
                }
                int x = card[j].getAuthor().compareTo(card[j+1].getAuthor());
                if (x>0) {
                    temp = card[j];
                    card[j] = card[j+1];
                    card[j+1] = temp;
                }
            }
            if (y==1) {
                break;
            }
        }
        return card;
    }
    public static Card[] sortByTitle(Card[] card) {
        Card temp;
        int y=0;
        for (int i=0; i<card.length; i++) {
            for (int j=0;j<card.length; j++) {
                if (card[j+1]==null) {
                    y=1;
                    break;
                }
                int x = card[j].getTitle().compareTo(card[j+1].getTitle());
                if (x>0) {
                    temp = card[j];
                    card[j] = card[j+1];
                    card[j+1] = temp;
                }
            }
            if (y==1) {
                break;
            }
        }
        return card;
    }
    public static Card[] sortBySubject(Card[] card) {
        Card temp;
        int y=0;
        for (int i=0; i<card.length; i++) {
            for (int j=0;j<card.length; j++) {
                if (card[j+1]==null) {
                    y=1;
                    break;
                }
                int x = card[j].getSubject().compareTo(card[j+1].getSubject());
                if (x>0) {
                    temp = card[j];
                    card[j] = card[j+1];
                    card[j+1] = temp;
                }
            }
            if (y==1) {
                break;
            }
        }
        return card;
    }
    public void printCatalog() {
        // Card [] s = new Card[10];
        for (int i = 0; i<cardCount; i++) {
            if (this.cards[i] != null) {
                // s[i] = cards[i];
                System.out.println(cards[i]);
            }
        }
    }
    public static void main(String [] args) {
        Card firstCard = new Card("Harry Potter","J.K.Rowling","Fiction");
        Card secondCard = new Card("A Song of Ice and Fire","George R.R Martin","Fantasy");
        Card thirdCard = new Card("A Brief History of Time","Stephen Hawking","Science");
        LibraryCardCatalog aCard = new LibraryCardCatalog();
        aCard.addCard(firstCard);
        aCard.addCard(secondCard);
        aCard.addCard(thirdCard);
        aCard.printCatalog();
    }
}
