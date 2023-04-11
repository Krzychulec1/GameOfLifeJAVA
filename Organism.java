package pl.edu.pg.eti.project2;

import java.awt.*;

public abstract class Organism {
    private int strength;
    private int initiative;
    private int age;
    private String name;
    private int posY;
    private int posX;
    private int moved=0;
    private int direction;
    private int coolDown;


    public abstract void collision(Organism[][] map, int attackerPosY, int attackerPosX, int posY, int posX);
    public abstract void action(Organism[][] map);
    public abstract void moving(Organism[][] map,int distance);
    public abstract void newOrganism(Organism[][] map, int posY, int posX);
    public abstract void multiplication(Organism[][] map, int attackerPosY, int attackerPosX);
    public abstract void drawing();
    public abstract Color color();

    public Organism(int strength,int initiative,int age,String name,int posY,int posX) {
        this.strength=strength;
        this.initiative=initiative;
        this.age=age;
        this.name=name;
        this.posY=posY;
        this.posX=posX;
    }
    public void setMoved(int k){
        this.moved=k;
    }

    public void purification(Organism[][] map) {
        if(Constants.hexagonal==0) {
            if (getPosY() - 1 >= 0) {
                if (!(map[getPosY() - 1][getPosX()] instanceof EmptyField)) {
                    Comment.addComment("Human DESTROYS "+ map[getPosY()-1][getPosX()].getName());
                    map[getPosY() - 1][getPosX()] = new EmptyField(-1, -1, -1, "Empty", getPosY() - 1, getPosX());
                }
            }
            if (getPosY() + 1 < Constants.SIZE_Y) {
                if (!(map[getPosY() + 1][getPosX()] instanceof EmptyField)) {
                    Comment.addComment("Human DESTROYS "+ map[getPosY()+1][getPosX()].getName());
                    map[getPosY() + 1][getPosX()] = new EmptyField(-1, -1, -1, "Empty", getPosY() + 1, getPosX());
                }
            }
            if (getPosX() - 1 >= 0) {
                if (!(map[getPosY()][getPosX() - 1] instanceof EmptyField)) {
                    Comment.addComment("Human DESTROYS "+ map[getPosY()][getPosX()-1].getName());
                    map[getPosY()][getPosX() - 1] = new EmptyField(-1, -1, -1, "Empty", getPosY(), getPosX() - 1);
                }
            }
            if (getPosX() + 1 < Constants.SIZE_X) {
                if (!(map[getPosY()][getPosX() + 1] instanceof EmptyField)) {
                    Comment.addComment("Human DESTROYS "+ map[getPosY()][getPosX()+1].getName());
                    map[getPosY()][getPosX() + 1] = new EmptyField(-1, -1, -1, "Empty", getPosY(), getPosX() + 1);
                }
            }
        }
        else {
            if(getPosX()%2==1) {
                if (getPosX() - 1 >= 0) {
                    if (!(map[getPosY()][getPosX() - 1] instanceof EmptyField)) {
                        Comment.addComment("Human DESTROYS "+ map[getPosY()][getPosX()-1].getName());
                        map[getPosY()][getPosX() - 1] = new EmptyField(-1, -1, -1, "Empty", getPosY(), getPosX() - 1);
                    }
               }
                if (getPosX() + 1 < Constants.SIZE_X) {
                    if (!(map[getPosY()][getPosX() + 1] instanceof EmptyField)) {
                        Comment.addComment("Human DESTROYS "+ map[getPosY()][getPosX()+1].getName());
                        map[getPosY()][getPosX() + 1] = new EmptyField(-1, -1, -1, "Empty", getPosY(), getPosX() + 1);
                    }
               }
                if (getPosY() - 1 >= 0) {
                    if (!(map[getPosY() - 1][getPosX()] instanceof EmptyField)) {
                        Comment.addComment("Human DESTROYS "+ map[getPosY()-1][getPosX()].getName());
                        map[getPosY() - 1][getPosX()] = new EmptyField(-1, -1, -1, "Empty", getPosY() - 1, getPosX());
                    }
              }
                if (getPosY() + 1 < Constants.SIZE_Y) {
                    if (!(map[getPosY() + 1][getPosX()] instanceof EmptyField)) {
                        Comment.addComment("Human DESTROYS "+ map[getPosY()+1][getPosX()].getName());
                        map[getPosY() + 1][getPosX()] = new EmptyField(-1, -1, -1, "Empty", getPosY() + 1, getPosX());
                    }
               }
                if (getPosX() - 1 >= 0 && getPosY()+1 < Constants.SIZE_Y) {
                    if (!(map[getPosY() + 1][getPosX()-1] instanceof EmptyField)) {
                        Comment.addComment("Human DESTROYS "+ map[getPosY()+1][getPosX()-1].getName());
                        map[getPosY() + 1][getPosX()-1] = new EmptyField(-1, -1, -1, "Empty", getPosY() + 1, getPosX()-1);
                    }
                }
                if (getPosX() + 1 < Constants.SIZE_X && getPosY() + 1 < Constants.SIZE_Y) {
                    if (!(map[getPosY() + 1][getPosX()+1] instanceof EmptyField)) {
                        Comment.addComment("Human DESTROYS "+ map[getPosY()+1][getPosX()+1].getName());
                        map[getPosY() + 1][getPosX()+1] = new EmptyField(-1, -1, -1, "Empty", getPosY() + 1, getPosX()+1);
                    }
                }
            }
            else{
                if (getPosX() - 1 >= 0 && getPosY() -1>=0) {
                    if (!(map[getPosY() - 1][getPosX()-1] instanceof EmptyField)) {
                        Comment.addComment("Human DESTROYS "+ map[getPosY()-1][getPosX()-1].getName());
                        map[getPosY() - 1][getPosX()-1] = new EmptyField(-1, -1, -1, "Empty", getPosY()- 1, getPosX()-1);
                    }
                }
                if (getPosX() + 1 < Constants.SIZE_X && getPosY()-1>=0) {
                    if (!(map[getPosY() - 1][getPosX()+1] instanceof EmptyField)) {
                        Comment.addComment("Human DESTROYS "+ map[getPosY()-1][getPosX()+1].getName());
                        map[getPosY() - 1][getPosX()+1] = new EmptyField(-1, -1, -1, "Empty", getPosY() - 1, getPosX()+1);
                    }
                }
                if (getPosY() - 1 >= 0) {
                    if (!(map[getPosY() - 1][getPosX()] instanceof EmptyField)) {
                        Comment.addComment("Human DESTROYS "+ map[getPosY()-1][getPosX()].getName());
                        map[getPosY() - 1][getPosX()] = new EmptyField(-1, -1, -1, "Empty", getPosY() - 1, getPosX());
                    }
                }
                if (getPosY() + 1 < Constants.SIZE_Y) {
                    if (!(map[getPosY() + 1][getPosX()] instanceof EmptyField)) {
                        Comment.addComment("Human DESTROYS "+ map[getPosY()+1][getPosX()].getName());
                        map[getPosY() + 1][getPosX()] = new EmptyField(-1, -1, -1, "Empty", getPosY() + 1, getPosX());
                    }
                }
                if (getPosX() - 1 >= 0) {
                    if (!(map[getPosY()][getPosX() - 1] instanceof EmptyField)) {
                        Comment.addComment("Human DESTROYS "+ map[getPosY()][getPosX()-1].getName());
                        map[getPosY()][getPosX() - 1] = new EmptyField(-1, -1, -1, "Empty", getPosY(), getPosX() - 1);
                    }
                }
                if (getPosX() + 1 < Constants.SIZE_X) {
                    if (!(map[getPosY()][getPosX() + 1] instanceof EmptyField)) {
                        Comment.addComment("Human DESTROYS "+ map[getPosY()][getPosX()+1].getName());
                        map[getPosY()][getPosX() + 1] = new EmptyField(-1, -1, -1, "Empty", getPosY(), getPosX() + 1);
                    }
                }
            }
        }
    }

    public void changeAge(){this.age++;}
    public void changeStrength(){this.strength+=3;}
    public void changePosY(int posY){this.posY=posY;}
    public void changePosX(int posX){this.posX=posX;}
    public int getStrength(){return this.strength;}
    public int getAge(){return this.age;}
    public int getMoved(){return this.moved;}
    public int getInitiative(){return this.initiative;}
    public int getPosY(){return this.posY;}
    public int getPosX(){return this.posX;}
    public void setDirection(int direction){this.direction=direction;}
    public int getDirection(){return direction;}
    public int getCoolDown(){return coolDown;}
    public void setCoolDown(int c){this.coolDown=c;}
    public String getName(){return this.name;}
}
