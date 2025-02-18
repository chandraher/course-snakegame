import java.io.*;
import java.util.*;

public class SnakeAndLadderGame {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            int snakeCount = Integer.parseInt(reader.readLine().trim());
            Board board = new Board();

            for (int i = 0; i < snakeCount; i++) {
                String[] snakeData = reader.readLine().split(" ");
                int head = Integer.parseInt(snakeData[0]);
                int tail = Integer.parseInt(snakeData[1]);
                board.addSnake(head, tail);
            }

            int ladderCount = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < ladderCount; i++) {
                String[] ladderData = reader.readLine().split(" ");
                int start = Integer.parseInt(ladderData[0]);
                int end = Integer.parseInt(ladderData[1]);
                board.addLadder(start, end);
            }

            int playerCount = Integer.parseInt(reader.readLine().trim());
            List<Player> players = new ArrayList<>();
            for (int i = 0; i < playerCount; i++) {
                String name = reader.readLine().trim();
                players.add(new Player(name));
            }

            Dice dice = new Dice();
            playGame(players, dice, board);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void playGame(List<Player> players, Dice dice, Board board) {
        boolean gameWon = false;

        while (!gameWon) {
            for (Player player : players) {
                int roll = dice.roll();
                System.out.print(player.getName() + " rolled a " + roll);
                int currentPos = player.getPosition();
                player.move(roll);

                if (player.getPosition() > 100) {
                    player.setPosition(currentPos);
                    System.out.println(" and moved from " + currentPos + " to " + player.getPosition());
                } else {
                    int newPos = board.checkPosition(player.getPosition());
                    System.out.println(" and moved from " + currentPos + " to " + newPos);
                    player.setPosition(newPos);
                }

                if (player.hasWon()) {
                    System.out.println(player.getName() + " wins!");
                    gameWon = true;
                    break;
                }
            }
        }
    }
}
