package pl.edu.pg.eti.project2;

import java.util.Random;

public abstract class Plant extends Organism{
    public Plant(int strength, int initiative, int age, String name, int posY, int posX) {
        super(strength, initiative, age, name, posY, posX);
    }

    @Override
    public void collision(Organism[][] map, int attackerPosY, int attackerPosX, int posY, int posX) {
        Comment.addComment(map[attackerPosY][attackerPosX].getName() + "eats "+ map[posY][posX].getName());
        if(map[attackerPosY][attackerPosX].getStrength()>=this.getStrength()){
            map[posY][posX] = map[attackerPosY][attackerPosX];
            map[attackerPosY][attackerPosX] = new EmptyField(-1,-1,0,"Empty",attackerPosY,attackerPosX);
            map[posY][posX].changePosX(posX);
            map[posY][posX].changePosY(posY);
        }
        else{
            map[attackerPosY][attackerPosX]=new EmptyField(-1,-1,0,"Empty",attackerPosY,attackerPosX);
        }
    }

    @Override
    public void action(Organism[][] map) {
        Random rand = new Random();
        int chance = rand.nextInt(24);
        if(chance==1){
           multiplication(map,getPosY(),getPosX());
        }
    }

    @Override
    public void moving(Organism[][] map, int distance) {}

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
                } else if (direction == Constants.RIGHT && getPosX() + 1 < Constants.SIZE_X && getPosY()>=0) {
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
        }
        if(map[newPosY][newPosX] instanceof EmptyField){
            Comment.addComment(map[attackerPosY][attackerPosX].getName() + " multiplies");
            newOrganism(map,newPosY,newPosX);
            map[newPosY][newPosX].setMoved(1);
        }
    }
}
