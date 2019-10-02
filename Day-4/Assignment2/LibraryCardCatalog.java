import java.util.*;
public class LibraryCardCatalog {
    Card [] cards;
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
    public void printCatalog() {
        for (int i = 0; i<cardCount; i++) {
            if (this.cards[i] != null) {
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