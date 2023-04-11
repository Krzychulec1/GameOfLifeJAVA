package pl.edu.pg.eti.project2.animals;

import pl.edu.pg.eti.project2.*;

import java.awt.*;
import java.util.Objects;

public class Human extends Animal {
    public Human(int strength, int initiative, int age, String name, int posY, int posX) {
        super(strength, initiative, age, name, posY, posX);
    }

    @Override
    public void newOrganism(Organism[][] map, int posY, int posX) {
    }

    @Override
    public void moving(Organism[][] map, int distance) {
        int newPosY = getPosY();
        int newPosX = getPosX();
        int direction = getDirection();
        if (Constants.hexagonal == 0) {
            if (direction == Constants.LEFT && getPosX() - distance >= 0) {
                newPosX -= distance;
            } else if (direction == Constants.RIGHT && getPosX() + distance < Constants.SIZE_X) {
                newPosX += distance;
            } else if (direction == Constants.UP && getPosY() - distance >= 0) {
                newPosY -= distance;
            } else if (direction == Constants.DOWN && getPosY() + distance < Constants.SIZE_Y) {
                newPosY += distance;
            }
        } else {
            if (getPosX() % 2 == 1) {
                if (direction == Constants.LEFT && getPosX() - distance >= 0) {
                    newPosX -= distance;
                } else if (direction == Constants.RIGHT && getPosX() + distance < Constants.SIZE_X) {
                    newPosX += distance;
                } else if (direction == Constants.UP && getPosY() - distance >= 0) {
                    newPosY -= distance;
                } else if (direction == Constants.DOWN && getPosY() + distance < Constants.SIZE_Y) {
                    newPosY += distance;
                }
                if (direction == Constants.DOWN_LEFT && getPosX() - distance >= 0 && getPosY()+distance < Constants.SIZE_Y) {
                    newPosX -= distance;
                    newPosY += distance;
                }
                if (direction == Constants.DOWN_RIGHT && getPosX() + distance < Constants.SIZE_X && getPosY() + distance < Constants.SIZE_Y) {
                    newPosX += distance;
                    newPosY += distance;
                }
            } else {
                if (direction == Constants.LEFT && getPosX() - distance >= 0 && getPosY() - distance >= 0) {
                    newPosX -= distance;
                    newPosY -= distance;
                } else if (direction == Constants.RIGHT && getPosX() + distance < Constants.SIZE_X && getPosY() - distance >= 0) {
                    newPosX += distance;
                    newPosY -= distance;
                } else if (direction == Constants.UP && getPosY() - distance >= 0) {
                    newPosY -= distance;
                } else if (direction == Constants.DOWN && getPosY() + distance < Constants.SIZE_Y) {
                    newPosY += distance;
                }
                if (direction == Constants.DOWN_LEFT && getPosX() - distance >= 0) {
                    newPosX -= distance;
                }
                if (direction == Constants.DOWN_RIGHT && getPosX() + distance < Constants.SIZE_X) {
                    newPosX += distance;
                }
            }
        }
        if (!(map[newPosY][newPosX] instanceof EmptyField)) {
            if (Objects.equals(map[newPosY][newPosX].getName(), this.getName())) {
                //map[newPosY][newPosX].multiplication(map, getPosY(), getPosX());
            } else {
                map[newPosY][newPosX].collision(map, getPosY(), getPosX(), newPosY, newPosX);
            }
        } else {
            map[newPosY][newPosX] = map[getPosY()][getPosX()];
            map[getPosY()][getPosX()] = new EmptyField(-1, -1, 0, "Empty", getPosY(), getPosX());
            changePosY(newPosY);
            changePosX(newPosX);
        }
        if (getCoolDown() > 5) {
            purification(map);
            setCoolDown(getCoolDown() - 1);
        }
        if (getCoolDown() >= 0 && getCoolDown() <= 5) {
            setCoolDown(getCoolDown() - 1);
        }
        this.setMoved(1);
    }

    @Override
    public Color color() {
        return Constants.human;
    }

    @Override
    public void drawing() {
        System.out.print("X");
    }
}
