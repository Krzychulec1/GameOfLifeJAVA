package pl.edu.pg.eti.project2.plants;

import pl.edu.pg.eti.project2.*;

import java.awt.*;
import java.util.Random;

public class SosnowskyHogweed extends Plant {
    public SosnowskyHogweed(int strength, int initiative, int age, String name, int posY, int posX) {
        super(strength, initiative, age, name, posY, posX);
    }

    @Override
    public void newOrganism(Organism[][] map, int posY, int posX) {
        map[posY][posX] = new SosnowskyHogweed(10,0,0,"SosnowskyHogweed",posY,posX);

    }

    public void specialAction(Organism[][] map){
        int posY = getPosY();
        int posX = getPosX();
        if(Constants.hexagonal==0) {
            if (posY + 1 < Constants.SIZE_Y) {
                if (!(map[posY + 1][posX] instanceof EmptyField) && map[posY + 1][posX].getInitiative() != 0) {
                    Comment.addComment("Sosnowsky Hogweed kills " + map[posY+1][posX].getName());
                    map[posY + 1][posX] = new EmptyField(-1, -1, 0, "Empty", getPosY() + 1, getPosX());
                }
            }
            if (posY - 1 >= 0) {
                if (!(map[posY - 1][posX] instanceof EmptyField) && map[posY - 1][posX].getInitiative() != 0) {
                    Comment.addComment("Sosnowsky Hogweed kills " + map[posY-1][posX].getName());
                    map[posY - 1][posX] = new EmptyField(-1, -1, 0, "Empty", getPosY() - 1, getPosX());
                }
            }
            if (posX + 1 < Constants.SIZE_X) {
                if (!(map[posY][posX + 1] instanceof EmptyField) && map[posY][posX + 1].getInitiative() != 0) {
                    Comment.addComment("Sosnowsky Hogweed kills " + map[posY][posX+1].getName());
                    map[posY][posX + 1] = new EmptyField(-1, -1, 0, "Empty", getPosY(), getPosX() + 1);
                }
            }
            if (posX - 1 >= 0) {
                if (!(map[posY][posX - 1] instanceof EmptyField) && map[posY][posX - 1].getInitiative() != 0) {
                    Comment.addComment("Sosnowsky Hogweed kills " + map[posY][posX-1].getName());
                    map[posY][posX - 1] = new EmptyField(-1, -1, 0, "Empty", getPosY(), getPosX() - 1);
                }
            }
        }
        else{
            if(getPosX()%2==1) {
                if (getPosX() - 1 >= 0) {
                    if (!(map[posY][posX-1] instanceof EmptyField) && map[posY][posX-1].getInitiative() != 0) {
                        Comment.addComment("Sosnowsky Hogweed kills " + map[posY][posX-1].getName());
                        map[posY][posX-1] = new EmptyField(-1, -1, 0, "Empty", getPosY(), getPosX()-1);
                    }
                } else if ( getPosX() + 1 < Constants.SIZE_X) {
                    if (!(map[posY][posX+1] instanceof EmptyField) && map[posY][posX+1].getInitiative() != 0) {
                        Comment.addComment("Sosnowsky Hogweed kills " + map[posY][posX+1].getName());
                        map[posY][posX+1] = new EmptyField(-1, -1, 0, "Empty", getPosY(), getPosX()+1);
                    }
                } else if (getPosY() - 1 >= 0) {
                    if (!(map[posY - 1][posX] instanceof EmptyField) && map[posY -1][posX].getInitiative() != 0) {
                        Comment.addComment("Sosnowsky Hogweed kills " + map[posY-1][posX].getName());
                        map[posY - 1][posX] = new EmptyField(-1, -1, 0, "Empty", getPosY() - 1, getPosX());
                    }
                } else if (getPosY() + 1 < Constants.SIZE_Y) {
                    if (!(map[posY + 1][posX] instanceof EmptyField) && map[posY + 1][posX].getInitiative() != 0) {
                        Comment.addComment("Sosnowsky Hogweed kills " + map[posY+1][posX].getName());
                        map[posY + 1][posX] = new EmptyField(-1, -1, 0, "Empty", getPosY() + 1, getPosX());
                    }
                }
                if (getPosX() - 1 >= 0 && getPosY()+1 < Constants.SIZE_Y) {
                    if (!(map[posY + 1][posX-1] instanceof EmptyField) && map[posY + 1][posX-1].getInitiative() != 0) {
                        Comment.addComment("Sosnowsky Hogweed kills " + map[posY+1][posX-1].getName());
                        map[posY + 1][posX-1] = new EmptyField(-1, -1, 0, "Empty", getPosY() + 1, getPosX()-1);
                    }
                }
                if (getPosX() + 1 < Constants.SIZE_X && getPosY() + 1 < Constants.SIZE_Y) {
                    if (!(map[posY + 1][posX+1] instanceof EmptyField) && map[posY + 1][posX+1].getInitiative() != 0) {
                        Comment.addComment("Sosnowsky Hogweed kills " + map[posY+1][posX+1].getName());
                        map[posY + 1][posX+1] = new EmptyField(-1, -1, 0, "Empty", getPosY() + 1, getPosX()+1);
                    }
                }
            }
            else{
                if (getPosX() - 1 >= 0 && getPosY() -1>=0) {
                    if (!(map[posY - 1][posX-1] instanceof EmptyField) && map[posY - 1][posX-1].getInitiative() != 0) {
                        Comment.addComment("Sosnowsky Hogweed kills " + map[posY-1][posX-1].getName());
                        map[posY - 1][posX-1] = new EmptyField(-1, -1, 0, "Empty", getPosY() - 1, getPosX()-1);
                    }
                } else if (getPosX() + 1 < Constants.SIZE_X && getPosY()-1>=0) {
                    if (!(map[posY - 1][posX+1] instanceof EmptyField) && map[posY - 1][posX+1].getInitiative() != 0) {
                        Comment.addComment("Sosnowsky Hogweed kills " + map[posY-1][posX+1].getName());
                        map[posY - 1][posX+1] = new EmptyField(-1, -1, 0, "Empty", getPosY() - 1, getPosX()+1);
                    }
                } else if (getPosY() - 1 >= 0) {
                    if (!(map[posY - 1][posX] instanceof EmptyField) && map[posY -1][posX].getInitiative() != 0) {
                        Comment.addComment("Sosnowsky Hogweed kills " + map[posY-1][posX].getName());
                        map[posY - 1][posX] = new EmptyField(-1, -1, 0, "Empty", getPosY() - 1, getPosX());
                    }
                } else if (getPosY() + 1 < Constants.SIZE_Y) {
                    if (!(map[posY + 1][posX] instanceof EmptyField) && map[posY + 1][posX].getInitiative() != 0) {
                        Comment.addComment("Sosnowsky Hogweed kills " + map[posY+1][posX].getName());
                        map[posY + 1][posX] = new EmptyField(-1, -1, 0, "Empty", getPosY() + 1, getPosX());
                    }
                }
                if (getPosX() - 1 >= 0) {
                    if (!(map[posY][posX-1] instanceof EmptyField) && map[posY][posX-1].getInitiative() != 0) {
                        Comment.addComment("Sosnowsky Hogweed kills " + map[posY][posX-1].getName());
                        map[posY][posX-1] = new EmptyField(-1, -1, 0, "Empty", getPosY(), getPosX()-1);
                    }
                }
                if (getPosX() + 1 < Constants.SIZE_X) {
                    if (!(map[posY][posX+1] instanceof EmptyField) && map[posY][posX+1].getInitiative() != 0) {
                        Comment.addComment("Sosnowsky Hogweed kills " + map[posY][posX+1].getName());
                        map[posY][posX+1] = new EmptyField(-1, -1, 0, "Empty", getPosY(), getPosX()+1);
                    }
                }
            }
        }
    }

    @Override
    public Color color() {
        return Constants.sosnowskyhogweed;
    }

    @Override
    public void action(Organism[][] map) {
        specialAction(map);
        Random rand = new Random();
        int chance = rand.nextInt(24);
        if(chance==1){
            multiplication(map,getPosY(),getPosX());
        }
    }

    @Override
    public void drawing() {
        System.out.print("!");
    }
}
