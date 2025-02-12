import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board() {
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
    }

    public void addSnake(int head, int tail) {
        snakes.add(new Snake(head, tail));
    }

    public void addLadder(int start, int end) {
        ladders.add(new Ladder(start, end));
    }

    public int checkPosition(int position) {
        for (Snake snake : snakes) {
            if (snake.getHead() == position) {
                return snake.getTail();
            }
        }
        for (Ladder ladder : ladders) {
            if (ladder.getStart() == position) {
                return ladder.getEnd();
            }
        }
        return position; // Jika tidak ada ular atau tangga
    }
}
