package pl.edu.pg.eti.project2;

import java.awt.*;

public class EmptyField extends Animal {
    public EmptyField(int strength, int initiative, int age, String name, int posY, int posX) {
        super(strength, initiative, age, name, posY, posX);
    }

    @Override
    public Color color(){
        return Color.BLACK;
    }

    @Override
    public void newOrganism(Organism[][] map, int posY, int posX) {
        map[posY][posX] = new EmptyField(-1,-1,0,"Empty",posY,posX);
    }

    @Override
    public void drawing() {

    }
}
