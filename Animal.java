package pl.edu.pg.eti.project2;

import java.util.Objects;
import java.util.Random;

public abstract class Animal extends Organism {
    public Animal(int strength, int initiative, int age, String name, int posY, int posX) {
        super(strength, initiative, age, name, posY, posX);
    }
    public void action(Organism[][] map){
        moving(map,1);
    }

    @Override
    public void multiplication(Organism[][] map, int attackerPosY, int attackerPosX) {
        int newPosY=attackerPosY;
        int newPosX=attackerPosX;
        if(Constants.hexagonal==0) {
            Random rand = new Random();
            int direction = rand.nextInt(4);
            if (direction == Constants.LEFT && newPosX - 1 >= 0) {
                newPosX -= 1;
            } else if (direction == Constants.RIGHT && newPosX + 1 < Constants.SIZE_X) {
                newPosX += 1;
            } else if (direction == Constants.UP && newPosY - 1 >= 0) {
                newPosY -= 1;
            } else if (direction == Constants.DOWN && newPosY + 1 < Constants.SIZE_Y) {
                newPosY += 1;
            }
        }
        else{
            Random rand = new Random();
            int direction = rand.nextInt(6);
            if(getPosX()%2==1) {
                if (direction == Constants.LEFT && getPosX() - 1 >= 0) {
                    newPosX -= 1;
                } else if (direction == Constants.RIGHT && getPosX() + 1 < Constants.SIZE_X) {
                    newPosX += 1;
                } else if (direction == Constants.UP && getPosY() - 1 >= 0) {
                    newPosY -= 1;
                } else if (direction == Constants.DOWN && getPosY() + 1 < Constants.SIZE_Y) {
                    newPosY += 1;
                }
                if (direction == Constants.DOWN_LEFT && getPosX() - 1 >= 0 && getPosY()+1 < Constants.SIZE_Y) {
                    newPosX -= 1;
                    newPosY += 1;
                }
                if (direction == Constants.DOWN_RIGHT && getPosX() + 1 < Constants.SIZE_X && getPosY() + 1 < Constants.SIZE_Y) {
                    newPosX += 1;
                    newPosY += 1;
                }
            }
            else{
                if (direction == Constants.LEFT && getPosX() - 1 >= 0 && getPosY() -1>=0) {
                    newPosX -= 1;
                    newPosY -=1;
                } else if (direction == Constants.RIGHT && getPosX() + 1 < Constants.SIZE_X && getPosY()-1>=0) {
                    newPosX += 1;
                    newPosY -=1;
                } else if (direction == Constants.UP && getPosY() - 1 >= 0) {
                    newPosY -= 1;
                } else if (direction == Constants.DOWN && getPosY() + 1 < Constants.SIZE_Y) {
                    newPosY += 1;
                }
                if (direction == Constants.DOWN_LEFT && getPosX() - 1 >= 0) {
                    newPosX -= 1;
                }
                if (direction == Constants.DOWN_RIGHT && getPosX() + 1 < Constants.SIZE_X) {
                    newPosX += 1;
                }
            }
            if (map[newPosY][newPosX] instanceof EmptyField) {
                Comment.addComment(map[attackerPosY][attackerPosX].getName() + " multiplies");
                newOrganism(map, newPosY, newPosX);
                map[newPosY][newPosX].setMoved(1);
            }
        }
    }

    @Override
    public void moving(Organism[][] map, int distance){
        int newPosY=getPosY();
        int newPosX=getPosX();
        int move=0;
        while(move==0) {
            if (Constants.hexagonal == 0) {
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
            else{
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
            else {
                if (direction == Constants.LEFT && getPosX() - distance >= 0 && getPosY() - distance >= 0) {
                    newPosX -= distance;
                    newPosY -= distance;
                    move = 1;
                } else if (direction == Constants.RIGHT && getPosX() + distance < Constants.SIZE_X && getPosY()-distance >= 0) {
                    newPosX += distance;
                    newPosY -= distance;
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
        }
        if(!(map[newPosY][newPosX] instanceof EmptyField)){
            if(Objects.equals(map[newPosY][newPosX].getName(), this.getName())){
                map[newPosY][newPosX].multiplication(map,getPosY(),getPosX());
            }
            else{
                map[newPosY][newPosX].collision(map,getPosY(),getPosX(),newPosY,newPosX);
            }
        }
        else{
            map[newPosY][newPosX]=map[getPosY()][getPosX()];
            map[getPosY()][getPosX()]= new EmptyField(-1,-1,0,"Empty",getPosY(),getPosX());
            changePosY(newPosY);
            changePosX(newPosX);
        }
        this.setMoved(1);
    }


    @Override
    public void collision(Organism[][] map, int attackerPosY, int attackerPosX, int posY, int posX){
        if(map[attackerPosY][attackerPosX].getStrength()>=this.getStrength()){
            Comment.addComment(map[attackerPosY][attackerPosX].getName() + " kills " + this.getName());
            map[posY][posX] = map[attackerPosY][attackerPosX];
            map[attackerPosY][attackerPosX] = new EmptyField(-1,-1,0,"Empty",attackerPosY,attackerPosX);
            map[posY][posX].changePosX(posX);
            map[posY][posX].changePosY(posY);
        }
        else{
            Comment.addComment(this.getName() + " kills " + map[attackerPosY][attackerPosX].getName());
            map[attackerPosY][attackerPosX]= new EmptyField(-1,-1,0,"Empty",attackerPosY,attackerPosX);
        }
    }
}
