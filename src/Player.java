public class Player {
    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0; // Pemain mulai dari posisi 1
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move(int steps) {
        if(steps > 100){
            setPosition(100-(steps - 100));
        }else {
            setPosition(getPosition() + steps); // Pemain bergerak maju
        }
//        if (getPosition() + steps <= 100) {

    }
//    105 +-

    public boolean hasWon() {
        return position == 100; // Pemain menang jika mencapai posisi 100
    }
}
