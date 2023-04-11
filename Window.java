package pl.edu.pg.eti.project2;

import pl.edu.pg.eti.project2.animals.*;
import pl.edu.pg.eti.project2.plants.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JPanel implements ActionListener,KeyListener, MouseListener {
    protected Organism[][] map;
    protected int height,width;
    protected World world;
    protected JFrame frame;
    private ButtonGroup radio;
    private JRadioButton Wolf,Sheep,Antelope,SosnowskyHogweed,Guarana,Fox,SowThistle,Grass,Belladonna,Turtle;
    private JFrame tmp;
    private int x,y;
    private int CD=0;
    Commentator commentator = new Commentator();

    public Window(JFrame f,Organism[][] map,int h,int w,World world){
        this.frame=f;
        this.map=map;
        this.width=w;
        this.height=h;
        this.world=world;
        repaint();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        addMouseListener(this);

    }
    public void paint(Graphics g) {
        super.paint(g);
        for(int k=0;k<height;k++){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(Constants.hexagonal==0){
                    g.setColor(map[i][j].color());
                    g.fillRect(j * 40 + 150, i * 40 + 150, 35, 35);
                }
                else {
                    g.setColor(map[i][j].color());
                    if (j % 2 == 0) {
                        int[] xPoints = {135 + 40 * j, 155 + 40 * j, 165 + 40 * j, 155 + 40 * j, 135 + 40 * j, 125 + 40 * j};
                        int[] yPoints = {175 + 40 * i, 175 + 40 * i, 155 + 40 * i, 135 + 40 * i, 135 + 40 * i, 155 + 40 * i};
                        g.fillPolygon(xPoints, yPoints, xPoints.length);
                    } else {
                        int[] xPoints = {135 + 40 * j, 155 + 40 * j, 165 + 40 * j, 155 + 40 * j, 135 + 40 * j, 125 + 40 * j};
                        int[] yPoints = {195 + 40 * i, 195 + 40 * i, 175 + 40 * i, 155 + 40 * i, 155 + 40 * i, 175 + 40 * i};
                        g.fillPolygon(xPoints, yPoints, xPoints.length);
                    }
                }
                }
            }
        }
        commentator.setPreferredSize(new Dimension(350, 100));
        commentator.setBounds(300,5, 900,200);
        commentator.setBackground(Color.GRAY);
        commentator.setVisible(true);
        add(commentator);
        commentator.refreshComments();
    }
    public void keyPressed(KeyEvent e){
        int ok=0;
        if(Constants.hexagonal==0) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    CD--;
                    ok = world.setHumanDirection(2);
                    if (ok == 1)
                        world.makeTurn();
                    break;
                case KeyEvent.VK_DOWN:
                    CD--;
                    ok = world.setHumanDirection(3);
                    if (ok == 1)
                        world.makeTurn();
                    break;
                case KeyEvent.VK_LEFT:
                    CD--;
                    ok = world.setHumanDirection(0);
                    if (ok == 1)
                        world.makeTurn();
                    break;
                case KeyEvent.VK_RIGHT:
                    CD--;
                    ok = world.setHumanDirection(1);
                    if (ok == 1)
                        world.makeTurn();
                    break;
                case KeyEvent.VK_R:
                    if (CD <= 0) {
                        CD = 10;
                        Comment.addComment("Super Ability activated");
                        world.ult();
                    }
                    else if (CD >= 5) {
                        Comment.addComment("Super Ability already activated");
                    }
                    else if(CD<5 && CD>0){
                        Comment.addComment("Super Ability is on cooldown");
                    }
                    break;
            }
        }
        else{
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    CD--;
                    ok = world.setHumanDirection(2);
                    if (ok == 1)
                        world.makeTurn();
                    break;
                case KeyEvent.VK_S:
                    CD--;
                    ok = world.setHumanDirection(3);
                    if (ok == 1)
                        world.makeTurn();
                    break;
                case KeyEvent.VK_Q:
                    CD--;
                    ok = world.setHumanDirection(0);
                    if (ok == 1)
                        world.makeTurn();
                    break;
                case KeyEvent.VK_E:
                    CD--;
                    ok = world.setHumanDirection(1);
                    if (ok == 1)
                        world.makeTurn();
                    break;
                case KeyEvent.VK_A:
                    CD--;
                    ok = world.setHumanDirection(5);
                    if (ok == 1)
                        world.makeTurn();
                    break;
                case KeyEvent.VK_D:
                    CD--;
                    ok = world.setHumanDirection(4);
                    if (ok == 1)
                        world.makeTurn();
                    break;
                case KeyEvent.VK_R:
                    if (CD <= 0) {
                        CD = 10;
                        Comment.addComment("Super Ability activated");
                        world.ult();
                    }
                    else if (CD >= 5) {
                        Comment.addComment("Super Ability already activated");

                    }
                    else if(CD<5 && CD>0){
                        Comment.addComment("Super Ability is on cooldown");
                    }
                    break;
            }
        }
    }

    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();
        if(source==Wolf){
            map[y][x]=new Wolf(9,5,0,"Wolf",y,x);
            tmp.setVisible(false);
        }
        else if(source==Sheep){
            map[y][x]=new Sheep(4,4,0,"Sheep",y,x);
            tmp.setVisible(false);
        }
        else if(source==Antelope){
            map[y][x]=new Antelope(4,4,0,"Antelope",y,x);
            tmp.setVisible(false);
        }
        else if(source==Fox){
            map[y][x]=new Fox(3,7,0,"Fox",y,x);
            tmp.setVisible(false);
        }
        else if(source==Turtle){
            map[y][x]=new Turtle(2,1,0,"Turtle",y,x);
            tmp.setVisible(false);
        }
        else if(source==Grass){
            map[y][x]=new Grass(0,0,0,"Grass",y,x);;
            tmp.setVisible(false);
        }
        else if(source==SowThistle){
            map[y][x]=new SowThistle(0,0,0,"SowThistle",y,x);
            tmp.setVisible(false);
        }
        else if(source==Guarana){
            map[y][x]=new Guarana(0,0,0,"Guarana",y,x);
            tmp.setVisible(false);
        }
        else if(source==Belladonna){
            map[y][x]=new Belladonna(99,0,0,"Belladonna",y,x);
            tmp.setVisible(false);
        }
        else if(source==SosnowskyHogweed){
            map[y][x]=new SosnowskyHogweed(10,0,0,"SosnowskyHogweed",y,x);
            tmp.setVisible(false);
        }
        repaint();
    }
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
    public void mousePressed(MouseEvent e){
        return;
    }
    public void mouseExited(MouseEvent e){
        return;
    }
    public void mouseReleased(MouseEvent e){
        return;
    }
    public void mouseEntered(MouseEvent e){ return;}
    public void mouseClicked(MouseEvent e) {
        if(world.getHexagonal()==0) {
            x = e.getX() / 40 - 4;
            y = e.getY() / 40 - 4;
        }
        else{
            x = e.getX() / 40 - 3;
            y = e.getY() / 40 - 4;
        }
        if (x >= 0 && x < width && y >= 0 && y < height) {
            if (map[y][x] instanceof EmptyField) {
                tmp = new JFrame();
                tmp.setSize(450, 450);
                tmp.setTitle("Spawning menu");
                tmp.setLayout(new GridLayout(10, 2));
                radio = new ButtonGroup();
                Wolf = new JRadioButton("Wolf", true);
                Sheep = new JRadioButton("Sheep", false);
                Antelope = new JRadioButton("Antelope", false);
                SosnowskyHogweed = new JRadioButton("SosnowskyHogweed", false);
                Guarana = new JRadioButton("Guarana", false);
                Fox = new JRadioButton("Fox", false);
                SowThistle = new JRadioButton("SowThistle", false);
                Grass = new JRadioButton("Grass", false);
                Belladonna= new JRadioButton("Belladonna", false);
                Turtle = new JRadioButton("Turtle", false);
                Wolf.setFont(new Font("TimesRoman", Font.BOLD,35));
                Sheep.setFont(new Font("TimesRoman", Font.BOLD,35));
                Antelope.setFont(new Font("TimesRoman", Font.BOLD,35));
                SosnowskyHogweed.setFont(new Font("TimesRoman", Font.BOLD,35));
                Guarana.setFont(new Font("TimesRoman", Font.BOLD,35));
                Fox.setFont(new Font("TimesRoman", Font.BOLD,35));
                SowThistle.setFont(new Font("TimesRoman", Font.BOLD,35));
                Grass.setFont(new Font("TimesRoman", Font.BOLD,35));
                Belladonna.setFont(new Font("TimesRoman", Font.BOLD,35));
                Turtle.setFont(new Font("TimesRoman", Font.BOLD,35));
                radio.add(Wolf);
                radio.add(Sheep);
                radio.add(Antelope);
                radio.add(SosnowskyHogweed);
                radio.add(Guarana);
                radio.add(Fox);
                radio.add(SowThistle);
                radio.add(Grass);
                radio.add(Belladonna);
                radio.add(Turtle);
                Wolf.addActionListener(this);
                Sheep.addActionListener(this);
                Antelope.addActionListener(this);
                SosnowskyHogweed.addActionListener(this);
                Guarana.addActionListener(this);
                Fox.addActionListener(this);
                SowThistle.addActionListener(this);
                Grass.addActionListener(this);
                Belladonna.addActionListener(this);
                Turtle.addActionListener(this);
                tmp.add(Wolf);
                tmp.add(Sheep);
                tmp.add(Antelope);
                tmp.add(SosnowskyHogweed);
                tmp.add(Guarana);
                tmp.add(Fox);
                tmp.add(SowThistle);
                tmp.add(Grass);
                tmp.add(Belladonna);
                tmp.add(Turtle);
                tmp.setVisible(true);
            }
        }
    }
}
