package pl.edu.pg.eti.project2.plants;

import pl.edu.pg.eti.project2.Constants;
import pl.edu.pg.eti.project2.Organism;
import pl.edu.pg.eti.project2.Plant;

import java.awt.*;

public class Grass extends Plant {
    public Grass(int strength, int initiative, int age, String name, int posY, int posX) {
        super(strength, initiative, age, name, posY, posX);
    }

    @Override
    public void drawing() {
        System.out.print("#");
    }

    @Override
    public void newOrganism(Organism[][] map, int posY, int posX) {
        map[posY][posX] = new Grass(0,0,0,"Grass",posY,posX);
    }
    @Override
    public Color color() {
        return Constants.grass;
    }
}
