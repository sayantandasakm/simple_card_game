package src.com.company;

import java.util.Arrays;

public class Driver {

    public static void main(String... args){
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Player p3 = new Player("p3");
        Player p4 = new Player("p4");

        Game g1 = new Game();
        g1.setPlayers(Arrays.asList(p1, p2, p3, p4));

        while(!g1.isOver()){
            g1.dealCards();
            g1.printGameStatus();
            g1.checkIfWin();
        }

        System.out.println("\n\n\nwinner = " + g1.getWinner());
    }
}
