package coins;

import java.util.Random;

public class Coin
{
    //data members
    private Random rand;
    private Face face;


    public Coin(Face face)
    {
        this.setFace(face);
        rand = new Random();
    }

    //getter and setter for face
    public Face getFace()
    {
        return face;
    }

    public void setFace(Face face) {
        this.face = face != null ? face : Face.HEAD;
    }

    //flip method
    public void flip()
    {
        boolean isHead = rand.nextBoolean();
        if(isHead)
        {
            setFace(Face.HEAD);
        }
        else
        {
            setFace(Face.TAIL);
        }
    }

    public boolean isHeads()
    {
        return face.equals(Face.HEAD);
    }

    @Override
    public String toString() {
        return String.format("Face: %s", face);
    }
}
