package pl.edu.pg.eti.project2.plants;

import pl.edu.pg.eti.project2.*;

import java.awt.*;

public class Guarana extends Plant {
    public Guarana(int strength, int initiative, int age, String name, int posY, int posX) {
        super(strength, initiative, age, name, posY, posX);
    }

    @Override
    public void newOrganism(Organism[][] map, int posY, int posX) {
        map[posY][posX] = new Guarana(0,0,0,"Guarana",posY,posX);
    }

    @Override
    public void collision(Organism[][] map, int attackerPosY, int attackerPosX, int posY, int posX) {
        Comment.addComment("Guarana strengthens " + map[attackerPosY][attackerPosX].getName());
        map[attackerPosY][attackerPosX].changeStrength();
        map[posY][posX] = map[attackerPosY][attackerPosX];
        map[attackerPosY][attackerPosX] = new EmptyField(-1,-1,0,"Empty",attackerPosY,attackerPosX);
        map[posY][posX].changePosX(posX);
        map[posY][posX].changePosY(posY);
    }

    @Override
    public Color color() {
        return Constants.sosnowskyhogweed;
    }

    @Override
    public void drawing() {
        System.out.print("@");
    }
}
