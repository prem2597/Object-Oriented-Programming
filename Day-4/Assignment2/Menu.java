public class Menu {
    public static void main(String [] args) {
        
    }
}


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
    public Card searchCard(String searchTitle) {
        for(int i=0; i<cardCount; i++) {
            if(cards[i].getTitle().equals(searchTitle)) {
                return cards[i];
            }
        }
        return null;
    }
    public Card searchCardByAuthor(String author) {
        for(int i=0; i<cardCount; i++) {
            if(cards[i].getAuthor().equals(author)) {
                return cards[i];
            }
        }
        return null;
    }
}