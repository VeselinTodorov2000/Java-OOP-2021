package sample;

import java.util.Random;

public class Coin {
    private Random rand;
    private Face face;

    public Coin(Face face) {
        setFace(face);
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public void flip() {
        rand = new Random();
        switch (rand.nextInt(2)) {
            case 0: face = Face.TAIL; break;
            case 1: face = Face.HEADS; break;
        }
    }

    public boolean isHeads() {
        return (face == Face.HEADS);
    }

    @Override
    public String toString() {
        return new String("Coin face is " + ((face == Face.HEADS) ? "HEADS" : "TAIL"));
    }
}
