package pl.edu.pg.eti.project2.animals;

import pl.edu.pg.eti.project2.Animal;
import pl.edu.pg.eti.project2.Constants;
import pl.edu.pg.eti.project2.Organism;

import java.awt.*;

public class Wolf extends Animal {
    public Wolf(int strength, int initiative,int age, String name, int posY, int posX) {
        super(strength, initiative, age, name, posY, posX);
    }

    @Override
    public void newOrganism(Organism[][] map, int posY, int posX) {
        map[posY][posX]=new Wolf(9,5,0,"Wolf",posY,posX);
    }

    @Override
    public void drawing() {
        System.out.print("W");
    }

    @Override
    public Color color() {
        return Constants.wolf;
    }
}
