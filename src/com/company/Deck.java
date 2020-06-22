package src.com.company;

import java.util.Arrays;

public class Deck {
    private Card[] deck = new Card[52];

    private void initDeck(){
        CardColor[] cardColors = CardColor.values();
        CardNumber[] cardNumbers = CardNumber.values();
        int k=0;
        for(int i=0;i<cardColors.length;i++){
            for(int j=0;j<cardNumbers.length;j++){
                Card card = new Card(cardColors[i], cardNumbers[j]);
                deck[k++] = card;
                if(k>=52)
                    break;
            }
        }
    }

    public Deck(){
        initDeck();
    }

    public Card[] getDeck() {
        return deck;
    }

    public void setDeck(Card[] deck) {
        this.deck = deck;
    }
}
