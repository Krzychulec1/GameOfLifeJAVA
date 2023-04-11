package pl.edu.pg.eti.project2;

import pl.edu.pg.eti.project2.animals.*;
import pl.edu.pg.eti.project2.plants.*;


import java.io.File;
import java.util.Objects;
import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class World {
    private int turn=0;
    private Organism[][] map;
    private int sizeY;
    private int sizeX;
    public JFrame frame;
    private int hexagonal=1;

    public World(int N,int M){
        this.sizeX=M;
        this.sizeY=N;
        map = new Organism[N][M];
        for(int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                this.map[i][j] = new EmptyField(-1,-1,0,"Empty",i,j);
            }
        }
        map[sizeY/2][sizeX/2]= new Human(5,4,0,"Human",sizeY/2,sizeX/2);
        for(int i=0;i<20;i++){
            Random rand = new Random();
            int species = rand.nextInt(10);
            addOrganism(species);
        }
    }

    public int getHexagonal(){
        return hexagonal;
    }
    public void setHexagonal(int k){
        hexagonal=k;
    }

    public void PrintWorld(){
            frame = new JFrame();
            frame.setTitle("Krzysztof Jeznach 188771");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(1, 1, 10, 0));
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            Window s = new Window(frame, map, sizeY, sizeX, this);
            s.setBackground(Color.GRAY);
            frame.add(s);
            s.setVisible(true);
            Menu m = new Menu(this, s);
            m.setBackground(Color.GRAY);
            m.setVisible(true);
            frame.add(m);
            frame.setVisible(true);
    }

    public int setHumanDirection(int k){
        int posY=0, posX=0;
        int flag=0;
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (!(map[i][j] instanceof EmptyField) && Objects.equals(map[i][j].getName(), "Human")) {
                    posY = i;
                    posX = j;
                    flag=1;
                    break;
                }
            }
        }
        if(flag==1) {
            if (k == 0) {
                if (posX - 1 >= 0) {
                    map[posY][posX].setDirection(0);
                    return 1;
                } else
                    return 0;
            } else if (k == 1) {
                if (posX + 1 < sizeX) {
                    map[posY][posX].setDirection(1);
                    return 1;
                } else
                    return 0;
            } else if (k == 2) {
                if (posY - 1 >= 0) {
                    map[posY][posX].setDirection(2);
                    return 1;
                } else
                    return 0;
            } else if (k == 3) {
                if (posY + 1 < sizeY) {
                    map[posY][posX].setDirection(3);
                    return 1;
                } else
                    return 0;
            }
            else if (k == 5) {
                    map[posY][posX].setDirection(5);
                    return 1;
            }
            else if (k == 4) {
                    map[posY][posX].setDirection(4);
                    return 1;
            }
        }
        return 1;
    }

    public void load(){
        frame.setVisible(false);
        try {
            File file = new File("save.txt");
            if (file.exists()) {
                map = null;
                BufferedReader reader = new BufferedReader(new FileReader("save.txt"));
                String line = reader.readLine();
                String[] elements = line.split(" ");
                sizeY = Integer.parseInt(elements[0]);
                sizeX = Integer.parseInt(elements[1]);
                turn = Integer.parseInt(elements[2]);
                map = new Organism[sizeY][sizeX];
                for (int y = 0; y < sizeY; y++) {
                    for (int x = 0; x < sizeX; x++) {
                        map[y][x] = new EmptyField(-1,-1,-1,"Empty",y,x);
                        line = reader.readLine();
                        elements = line.split(" ");
                        int age=Integer.parseInt(elements[1]);
                        int coolDown=Integer.parseInt(elements[2]);
                        int strength = Integer.parseInt(elements[3]);
                        switch (elements[0]) {
                            case "Antelope":
                                map[y][x] = new Antelope(strength, 4, age, "Antelope", y, x);
                                break;
                            case "Belladonna":
                                map[y][x] = new Belladonna(strength, 0, age, "Belladonna", y, x);
                                break;
                            case "Fox":
                                map[y][x] = new Fox(strength, 7, age, "Fox", y, x);
                                break;
                            case "Grass":
                                map[y][x] = new Grass(strength, 0, age, "Grass", y, x);
                                break;
                            case "Guarana":
                                map[y][x] = new Guarana(strength, 0, age, "Guarana", y, x);
                                break;
                            case "Sheep":
                                map[y][x] = new Sheep(strength, 4, age, "Sheep", y, x);
                                break;
                            case "SosnowskyHogweed":
                                map[y][x] = new SosnowskyHogweed(strength, 0, age, "SosnowskyHogweed", y, x);
                                break;
                            case "SowThistle":
                                map[y][x] = new SowThistle(strength, 0, age, "SowThistle", y, x);
                                break;
                            case "Turtle":
                                map[y][x] = new Turtle(strength, 1, age, "Turtle", y, x);
                                break;
                            case "Wolf":
                                map[y][x] = new Wolf(strength, 5, age, "Wolf", y, x);
                                break;
                            case "NULL":
                                map[y][x] =new EmptyField(-1,-1,0,"Empty",y,x);
                                break;
                            case "Human":
                                map[y][x] = new Human(strength,4,age,"Human",y,x);
                                map[y][x].setCoolDown(coolDown);
                        }
                    }
                }
            }
        }catch (
    IOException e) {
        System.out.println("Error: " + e);
    }
        PrintWorld();
    }


    public void addOrganism(int species){
        Random rand = new Random();
        int x = rand.nextInt(Constants.SIZE_X);
        int y = rand.nextInt(Constants.SIZE_Y);
        while(!(map[y][x] instanceof EmptyField)){
            x = rand.nextInt(Constants.SIZE_X);
            y = rand.nextInt(Constants.SIZE_Y);
        }
        if(species==Constants.ANTELOPE){
            map[y][x] = new Antelope(4,4,0,"Antelope",y,x);
        }
        else if(species==Constants.BELLADONNA){
           map[y][x] = new Belladonna(99,0,0,"Belladonna",y,x);
        }
        else if(species==Constants.FOX){
            map[y][x] = new Fox(3,7,0,"Fox",y,x);
        }
        else if(species==Constants.GRASS){
            map[y][x] = new Grass(0,0,0,"Grass",y,x);
        }
        else if(species==Constants.GUARANA){
            map[y][x] = new Guarana(0,0,0,"Guarana",y,x);
        }
        else if(species==Constants.SHEEP){
            map[y][x] = new Sheep(4,4,0,"Sheep",y,x);
        }
        else if(species==Constants.SOSNOWSKYHOGWEED){
            map[y][x] = new SosnowskyHogweed(10,0,0,"SosnowskyHogweed",y,x);
        }
        else if(species==Constants.SOWTHISTLE){
            map[y][x] = new SowThistle(0,0,0,"SowThistle",y,x);
        }
        else if(species==Constants.TURTLE){
            map[y][x] = new Turtle(2,1,0,"Turtle",y,x);
        }
        else if(species==Constants.WOLF){
            map[y][x] = new Wolf(9,5,0,"Wolf",y,x);
        }
    }

    public void makeTurn(){
        //comment=endl;
        int human=0;
        int animal=0;
        int[] initiatives = {7,5,4,1,0};
        for (int l=turn;l>=0;l--){
            for(int k=0;k<5;k++){
                for(int i=0;i<sizeY;i++){
                    for(int j=0;j<sizeX;j++){
                        if(!(map[i][j] instanceof  EmptyField)){
                            if(map[i][j].getAge()==l){
                                if(Objects.equals(map[i][j].getName(), "Human")){
                                    human=1;
                                }
                                if(!(map[i][j] instanceof EmptyField) && map[i][j].getName()!="Human"){
                                    animal=1;
                                }
                                if(map[i][j].getInitiative()==initiatives[k] && map[i][j].getMoved()!=1){
                                    map[i][j].action(map);
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
        drawWorld();
        resetMove();
        if(human==0){
            System.out.println("YOU LOST \n");
            System.exit(0);
        }
        if(animal==0){
            System.out.println("YOU WON \n");
            System.exit(0);
        }
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public void save(){
        try {
            File file = new File("save.txt");
            file.createNewFile();
            PrintWriter pw = new PrintWriter(file);
            pw.print(sizeY + " ");
            pw.print(sizeX + " ");
            pw.print(turn + " ");
            pw.println();
            for(int i=0;i<sizeY;i++){
                for(int j=0;j<sizeX;j++){
                    if(map[i][j] instanceof EmptyField) {
                        pw.print("NULL " + 0 + " " + 0 + " " + 0);
                        pw.println();
                    }
                    else if(Objects.equals(map[i][j].getName(), "Human")){
                        pw.print(map[i][j].getName() + " "+ map[i][j].getAge() + " " + map[i][j].getCoolDown() + " "+ map[i][j].getStrength());
                        pw.println();
                    }
                    else
                    {
                        pw.print(map[i][j].getName() + " "+ map[i][j].getAge() + " " + 0 + " "+ map[i][j].getStrength());
                        pw.println();
                    }
                }
            }
            pw.close();
        }catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void ult(){
        for(int i=0;i<sizeY;i++){
            for(int j=0;j<sizeX;j++){
                if(Objects.equals(map[i][j].getName(), "Human")) {
                    map[i][j].setCoolDown(10);
                }
            }
        }
    }

    public void drawWorld(){
        System.out.println("Krzysztof Jeznach 188771 \n");
        System.out.println("Turn number: "+ turn);
        for(int i=0;i<sizeY;i++){
            for(int j=0;j<sizeX;j++) {
                if (map[i][j] instanceof EmptyField)
                    System.out.print("_");
                else
                    map[i][j].drawing();
            }
            System.out.print(System.lineSeparator());
        }
    }

    public void resetMove(){
        for(int i=0;i<sizeY;i++){
            for(int j=0;j<sizeX;j++){
                if(!(map[i][j] instanceof  EmptyField)){
                    map[i][j].changeAge();
                    map[i][j].setMoved(0);
                }
            }
        }
        this.turn++;
    }
}
