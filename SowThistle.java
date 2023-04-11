package pl.edu.pg.eti.project2.plants;

import pl.edu.pg.eti.project2.Constants;
import pl.edu.pg.eti.project2.Organism;
import pl.edu.pg.eti.project2.Plant;

import java.awt.*;
import java.util.Random;

public class SowThistle extends Plant {
    public SowThistle(int strength, int initiative, int age, String name, int posY, int posX) {
        super(strength, initiative, age, name, posY, posX);
    }

    @Override
    public void newOrganism(Organism[][] map, int posY, int posX) {
        map[posY][posX] = new SowThistle(0,0,0,"SowThistle",posY,posX);
    }

    @Override
    public void action(Organism[][] map) {
        Random rand = new Random();
        int chance = rand.nextInt(8);
        if(chance==1){
            multiplication(map,getPosY(),getPosX());
        }
    }

    @Override
    public Color color() {
        return Constants.sowthistle;
    }

    @Override
    public void drawing() {
        System.out.print("/");
    }
}
