package src.com.company;

import java.util.Objects;

public class Card {
    private CardColor cardColor;
    private CardNumber cardNumber;

    public Card() {
    }

    public Card(CardColor cardColor, CardNumber cardNumber) {
        this.cardColor = cardColor;
        this.cardNumber = cardNumber;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    public void setCardColor(CardColor cardColor) {
        this.cardColor = cardColor;
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(CardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getCardColor() == card.getCardColor() &&
                getCardNumber() == card.getCardNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardColor(), getCardNumber());
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardColor=" + cardColor +
                ", cardNumber=" + cardNumber +
                '}';
    }
}
