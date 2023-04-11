package pl.edu.pg.eti.project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel implements ActionListener {
    private World world;
    private Window s;
    public Menu(World _world, Window _s) {

        world = _world;
        s= _s;
        repaint();
        Buttons();
    }
   public void paint(Graphics g){
        super.paint(g);
        g.setColor(Constants.human);
        g.fillRect(125,350,30,30);
        g.setFont(new Font("TimesRoman", Font.BOLD,25));
        g.drawString("Human", 165, 375);
        g.setColor(Constants.wolf);
        g.fillRect(125,400,30,30);
        g.drawString("Wolf", 165, 425);
        g.setColor(Constants.sheep);
        g.fillRect(125,450,30,30);
        g.drawString("Sheep", 165, 475);
        g.setColor(Constants.antelope);
        g.fillRect(125,500,30,30);
        g.drawString("Anelope", 165, 525);
        g.setColor(Constants.turtle);
        g.fillRect(125,550,30,30);
        g.drawString("Turtle", 165, 575);
        g.setColor(Constants.fox);
        g.fillRect(125,600,30,30);
        g.drawString("Fox", 165, 625);
        g.setColor(Constants.grass);
        g.fillRect(125,650,30,30);
        g.drawString("Grass", 165, 675);
        g.setColor(Constants.sowthistle);
        g.fillRect(125,700,30,30);
        g.drawString("Sow Thistle", 165, 725);
        g.setColor(Constants.guarana);
        g.fillRect(125,750,30,30);
        g.drawString("Guarana", 165, 775);
        g.setColor(Constants.belladonna);
        g.fillRect(125,800,30,30);
        g.drawString("Belladonna", 165, 825);
        g.setColor(Constants.sosnowskyhogweed);
        g.fillRect(125,850,30,30);
        g.drawString("Sosnowsky Hogweed", 165, 875);
    }

    private void Buttons() {
        JButton save = new JButton("SAVE GAME");
        JButton load = new JButton("LOAD GAME");
        JTextArea nameField = new JTextArea("\n         Virtual World Simulator");
       // JTextArea textArea;
        nameField.setEditable(false);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.save();
                s.requestFocus();
            }
        });
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.load();
                s.requestFocus();
            }
        });
        nameField.setFont(new Font("TimesRoman", Font.BOLD,45));
        save.setFont(new Font("TimesRoman", Font.BOLD,25));
        load.setFont(new Font("TimesRoman", Font.BOLD,25));
        nameField.setBackground(Color.WHITE);
        save.setBackground(Color.LIGHT_GRAY);
        load.setBackground(Color.LIGHT_GRAY);
        nameField.setPreferredSize(new Dimension(700,150));
        save.setPreferredSize(new Dimension(350, 100));
        load.setPreferredSize(new Dimension(350, 100));
        add(nameField);
        add(save);
        add(load);
    }
    public void actionPerformed(ActionEvent e){
        repaint();
    }
}