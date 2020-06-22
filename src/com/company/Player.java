package src.com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Player {
    private String name;
    private Card[] initialDeck = new Card[3];
    private List<Card> cards = new ArrayList<>();

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card[] getInitialDeck() {
        return initialDeck;
    }

    public void setInitialDeck(Card[] initialDeck) {
        this.initialDeck = initialDeck;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    boolean isInitialDeckFull(){
        return initialDeck[0] != null && initialDeck[1] != null && initialDeck[2] != null;
    }

    private void validateInitialDeck(){
        assert initialDeck[0] != null && initialDeck[1] != null && initialDeck[2] != null;
    }

    // 3 same cards
    private boolean winningCond1(){
        validateInitialDeck();
        return initialDeck[0] == initialDeck[1] && initialDeck[1] == initialDeck[2];
    }

    // consecutive cards
    private boolean winningCond2(){
        validateInitialDeck();
        Arrays.sort(initialDeck, Comparator.comparing(card -> card.getCardNumber().getValue()));
        return initialDeck[0].getCardNumber().getValue() + 1 == initialDeck[1].getCardNumber().getValue() &&
                initialDeck[1].getCardNumber().getValue() + 1 == initialDeck[2].getCardNumber().getValue();
    }

    // 2 same cards
    boolean winningCond3(){
        validateInitialDeck();
        return initialDeck[0] == initialDeck[1] || initialDeck[1] == initialDeck[2] || initialDeck[0] == initialDeck[2];
    }

    int initialDeckValue(){
        if(winningCond1())
            return 3;
        if(winningCond2())
            return 2;
        if(winningCond1())
            return 1;
        return 0;
    }

    int getHighestCardFaceOffValue(){
        return Math.max(initialDeck[0].getCardNumber().getFaceOffValue(), Math.max(initialDeck[1].getCardNumber().getFaceOffValue(), initialDeck[2].getCardNumber().getFaceOffValue()));
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", initialDeck=" + Arrays.toString(initialDeck) +
                ", cards=" + cards +
                '}';
    }
}
