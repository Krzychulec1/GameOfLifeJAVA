package pl.edu.pg.eti.project2.animals;

import pl.edu.pg.eti.project2.Animal;
import pl.edu.pg.eti.project2.Constants;
import pl.edu.pg.eti.project2.EmptyField;
import pl.edu.pg.eti.project2.Organism;

import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class Fox extends Animal {
    public Fox(int strength, int initiative, int age, String name, int posY, int posX) {
        super(strength, initiative, age, name, posY, posX);
    }

    @Override
    public void newOrganism(Organism[][] map, int posY, int posX) {
        map[posY][posX]=new Fox(3,7,0,"Fox",posY,posX);
    }

    @Override
    public void moving(Organism[][] map,int distance) {
        int newPosY = getPosY();
        int newPosX = getPosX();
        int canMove = 0;
        int move = 0;
        if(Constants.hexagonal==0) {
            Random rand = new Random();
            int direction = rand.nextInt(4);
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
        else {
            Random rand = new Random();
            int direction = rand.nextInt(6);
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
                } else if (direction == Constants.RIGHT && getPosX() + distance < Constants.SIZE_X && getPosY() - distance>=0) {
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
        if (!(map[newPosY][newPosX] instanceof EmptyField)) {
            if (getStrength() > map[newPosY][newPosX].getStrength()) {
                canMove = 1;
            } else if (Objects.equals(map[newPosY][newPosX].getName(), this.getName())) {
                canMove = 1;
            }
        } else {
            canMove = 1;
        }
        if(canMove==1 && move==1){
            if(!(map[newPosY][newPosX] instanceof EmptyField)){
                if(Objects.equals(map[newPosY][newPosX].getName(), getName())){
                    map[newPosY][newPosX].multiplication(map,getPosY(),getPosX());
                }
                else{
                    map[newPosY][newPosX].collision(map,getPosY(),getPosX(),newPosY,newPosX);
                }
            }
            else {
                map[newPosY][newPosX]=map[getPosY()][getPosX()];
                map[getPosY()][getPosX()]=new EmptyField(-1,-1,0,"Empty",getPosY(),getPosX());
                changePosX(newPosX);
                changePosY(newPosY);
            }
            setMoved(1);
        }
        setMoved(1);
    }


    @Override
    public void drawing() {
        System.out.print("F");
    }

    @Override
    public Color color() {return Constants.fox;}
}
