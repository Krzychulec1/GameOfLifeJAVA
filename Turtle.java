package pl.edu.pg.eti.project2.animals;

import pl.edu.pg.eti.project2.*;

import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class Turtle extends Animal {

    public Turtle(int strength, int initiative, int age, String name, int posY, int posX) {
        super(strength, initiative, age, name, posY, posX);
    }

    @Override
    public void newOrganism(Organism[][] map, int posY, int posX) {
        map[posY][posX]=new Turtle(2,1,0,"Turtle",posY,posX);
    }

    @Override
    public void moving(Organism[][] map, int distance) {
        int newPosY = getPosY();
        int newPosX = getPosX();
        int move=0;
        if(Constants.hexagonal==0) {
            Random rand = new Random();
            int direction = rand.nextInt(16);
            if (direction == Constants.LEFT && getPosX() - distance >= 0) {
                newPosX -= distance;
                move = 1;
            } else if (direction == Constants.RIGHT && getPosX() + distance < Constants.SIZE_X) {
                newPosX += distance;
                move = 1;
            } else if (direction == Constants.UP && getPosY() - distance >= 0) {
                newPosY -= distance;
                move = 1;
            } else if (direction == Constants.DOWN && getPosY() + distance < Constants.SIZE_Y) {
                newPosY += distance;
                move = 1;
            }
        }
        else{
            Random rand = new Random();
            int direction = rand.nextInt(24);
            if(getPosX()%2==1) {
                if (direction == Constants.LEFT && getPosX() - distance >= 0) {
                    newPosX -= distance;
                    move = 1;
                } else if (direction == Constants.RIGHT && getPosX() + distance < Constants.SIZE_X) {
                    newPosX += distance;
                    move = 1;
                } else if (direction == Constants.UP && getPosY() - distance >= 0) {
                    newPosY -= distance;
                    move = 1;
                } else if (direction == Constants.DOWN && getPosY() + distance < Constants.SIZE_Y) {
                    newPosY += distance;
                    move = 1;
                }
                if (direction == Constants.DOWN_LEFT && getPosX() - distance >= 0 && getPosY()+distance < Constants.SIZE_Y) {
                    newPosX -= distance;
                    newPosY += distance;
                    move = 1;
                }
                if (direction == Constants.DOWN_RIGHT && getPosX() + distance < Constants.SIZE_X && getPosY() + distance < Constants.SIZE_Y) {
                    newPosX += distance;
                    newPosY += distance;
                    move = 1;
                }
            }
            else{
                if (direction == Constants.LEFT && getPosX() - distance >= 0 && getPosY() -distance>=0) {
                    newPosX -= distance;
                    newPosY -=distance;
                    move = 1;
                } else if (direction == Constants.RIGHT && getPosX() + distance < Constants.SIZE_X && getPosY()-distance>=0) {
                    newPosX += distance;
                    newPosY -=distance;
                    move = 1;
                } else if (direction == Constants.UP && getPosY() - distance >= 0) {
                    newPosY -= distance;
                    move = 1;
                } else if (direction == Constants.DOWN && getPosY() + distance < Constants.SIZE_Y) {
                    newPosY += distance;
                    move = 1;
                }
                if (direction == Constants.DOWN_LEFT && getPosX() - distance >= 0) {
                    newPosX -= distance;
                    move = 1;
                }
                if (direction == Constants.DOWN_RIGHT && getPosX() + distance < Constants.SIZE_X) {
                    newPosX += distance;
                    move = 1;
                }
            }
        }
        if(move==1) {
            if (!(map[newPosY][newPosX] instanceof EmptyField)) {
                if (Objects.equals(map[newPosY][newPosX].getName(), this.getName())) {
                    map[newPosY][newPosX].multiplication(map, getPosY(), getPosX());
                } else {
                    map[newPosY][newPosX].collision(map, getPosY(), getPosX(), newPosY, newPosX);
                }
            } else {
                map[newPosY][newPosX] = map[getPosY()][getPosX()];
                map[getPosY()][getPosX()] = new EmptyField(-1, -1, 0, "Empty", getPosY(), getPosX());
                changePosY(newPosY);
                changePosX(newPosX);
            }
        }
        this.setMoved(1);
    }

    @Override
    public void collision(Organism[][] map, int attackerPosY, int attackerPosX, int posY, int posX) {
        if(map[attackerPosY][attackerPosX].getStrength()>=5){
            if(map[attackerPosY][attackerPosX].getStrength()>=getStrength()){
                Comment.addComment(map[attackerPosY][attackerPosX].getName() + " kills Turtle");
                map[posY][posX]=map[attackerPosY][attackerPosX];
                map[attackerPosY][attackerPosX]=new EmptyField(-1,-1,0,"Empty",attackerPosY,attackerPosX);
                map[posY][posX].changePosX(posX);
                map[posY][posX].changePosY(posY);
            }
        }
    }

    @Override
    public Color color() {
        return Constants.turtle;
    }

    @Override
    public void drawing() {
        System.out.print("T");
    }
}
