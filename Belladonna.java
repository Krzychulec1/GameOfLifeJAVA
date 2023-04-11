package pl.edu.pg.eti.project2.plants;

import pl.edu.pg.eti.project2.*;

import java.awt.*;

public class Belladonna extends Plant {
    public Belladonna(int strength, int initiative, int age, String name, int posY, int posX) {
        super(strength, initiative, age, name, posY, posX);
    }

    @Override
    public void newOrganism(Organism[][] map, int posY, int posX) {
        map[posY][posX] = new Belladonna(99,0,0,"Belladonna",posY,posX);
    }

    @Override
    public void collision(Organism[][] map, int attackerPosY, int attackerPosX, int posY, int posX) {
        if(map[attackerPosY][attackerPosX].getInitiative()!=0){
            Comment.addComment(map[attackerPosY][attackerPosX].getName() + " eats Belladonna");
            Comment.addComment("Belladonna kills "+ map[attackerPosY][attackerPosX].getName());
            map[posY][posX]=new EmptyField(-1,-1,0,"Empty",getPosY(),getPosX());
            map[attackerPosY][attackerPosX]=new EmptyField(-1,-1,0,"Empty",attackerPosY,attackerPosX);
        }
    }

    @Override
    public Color color() {
        return Constants.belladonna;
    }

    @Override
    public void drawing() {
        System.out.print("\\");
    }
}
