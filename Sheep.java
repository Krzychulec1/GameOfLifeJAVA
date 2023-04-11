package pl.edu.pg.eti.project2.animals;

import pl.edu.pg.eti.project2.Animal;
import pl.edu.pg.eti.project2.Constants;
import pl.edu.pg.eti.project2.Organism;

import java.awt.*;

public class Sheep extends Animal {
    public Sheep(int strength, int initiative, int age, String name, int posY, int posX) {
        super(strength, initiative, age, name, posY, posX);
    }

    @Override
    public void newOrganism(Organism[][] map, int posY, int posX) {
        map[posY][posX]=new Sheep(4,4,0,"Sheep",posY,posX);
    }

    @Override
    public Color color() {
        return Constants.sheep;
    }

    @Override
    public void drawing() {
        System.out.print("S");
    }
}
