package pl.edu.pg.eti.project2.animals;

import pl.edu.pg.eti.project2.*;

import java.awt.*;
import java.util.Random;

public class Antelope extends Animal {
    public Antelope(int strength, int initiative, int age, String name, int posY, int posX) {
        super(strength, initiative, age, name, posY, posX);
    }

    @Override
    public void newOrganism(Organism[][] map, int posY, int posX) {
        map[posY][posX]=new Fox(4,4,0,"Antelope",posY,posX);
    }

    @Override
    public void drawing() {
        System.out.print("A");
    }

    @Override
    public Color color() {
        return Constants.antelope;
    }

        @Override
    public void action(Organism[][] map) {
        moving(map,2);
    }

    @Override
    public void collision(Organism[][] map, int attackerPosY, int attackerPosX, int posY, int posX) {
        if(map[attackerPosY][attackerPosX].getStrength()>=getStrength()){
            Random rand = new Random();
            int escape = rand.nextInt(2);
            if(escape==0) {
                moving(map, 2);
                Comment.addComment("Antelope escapes \n");
            }
            Comment.addComment(map[attackerPosY][attackerPosX].getName() + " kills Antelope");
                map[posY][posX]=map[attackerPosY][attackerPosX];
                map[attackerPosY][attackerPosX]=new EmptyField(-1,-1,0,"Empty",attackerPosY,attackerPosX);
                map[posY][posX].changePosY(posY);
                map[posY][posX].changePosX(posX);
        }
        else{
            Comment.addComment("Antelope kills " + map[attackerPosY][attackerPosX].getName());
            map[attackerPosY][attackerPosX]=new EmptyField(-1,-1,0,"Empty",attackerPosY,attackerPosX);
        }
    }
}
