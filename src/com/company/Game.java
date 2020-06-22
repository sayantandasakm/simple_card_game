package src.com.company;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Game {
    private Deck deck = new Deck();
    private List<Player> players = new ArrayList<>();
    private boolean isOver = false;
    private Player winner;

    public Deck getDeck() {
        return deck;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public boolean isOver() {
        return isOver;
    }

    public Player getWinner() {
        return winner;
    }

    private void validatePlayers(){
        assert players.size() <= 4;
        for(int i=0;i<players.size();i++)
            assert players.get(i) != null;
    }

    public void dealCards(){
        validatePlayers();

        System.out.println("\n\ndealing cards");

        for(Player player: players){
            Card[] unusedCards = deck.getDeck();
            int randomNum = ThreadLocalRandom.current().nextInt(0, unusedCards.length);
            Card usedCard = unusedCards[randomNum];
            unusedCards = Arrays.stream(unusedCards).filter(card -> !usedCard.equals(card)).toArray(Card[]::new);
            if(unusedCards.length <= 0) {
                // empty deck
                // game over without winner
                isOver = true;
            }
            deck.setDeck(unusedCards);

            Card[] initialDeck = player.getInitialDeck();
            if(null == initialDeck[0])
                initialDeck[0] = usedCard;
            else if(null == initialDeck[1])
                initialDeck[1] = usedCard;
            else if(null == initialDeck[2])
                initialDeck[2] = usedCard;
            else
                player.getCards().add(usedCard);

        }
    }

    public void checkIfWin(){
        validatePlayers();

        List<PlayerWithScore> playerWithScores = new ArrayList<>();
        for(Player player: players){
            int score = 0;
            // no need to check winning condition
            if(!player.isInitialDeckFull())
                return;

            if(player.getCards().size() > 0) {
                List<Card> cards = player.getCards();
                Card lastCard = cards.get(cards.size() - 1);
                score = lastCard.getCardNumber().getFaceOffValue();
            }

            else{
                score = player.initialDeckValue();
                if(score == 0)
                    score = player.getHighestCardFaceOffValue();
            }

            PlayerWithScore playerWithScore = new PlayerWithScore(player, score);
            playerWithScores.add(playerWithScore);
        }
        playerWithScores.sort(Comparator.comparing(PlayerWithScore::getScore, Collections.reverseOrder()));


        // single winner
        int winningScore = playerWithScores.get(0).getScore();
        if(winningScore > playerWithScores.get(1).getScore()){
            winner = playerWithScores.get(0).getPlayer();
            isOver = true;
        }

        // keep tied winners only
        else {
            players = playerWithScores.stream().filter(playerWithScore -> winningScore == playerWithScore.getScore())
                    .map(PlayerWithScore::getPlayer).collect(Collectors.toList());
        }

    }

    public void printGameStatus(){
        validatePlayers();
        for(Player player: players){
            System.out.println("player = " + player);
        }
    }
}
