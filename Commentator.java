package pl.edu.pg.eti.project2;

import javax.swing.*;
import java.awt.*;

public class Commentator extends JPanel {
    private String text;
    private JTextArea textArea;

    public Commentator() {
        super();
        setPreferredSize(new Dimension(350, 100));
        setBounds(400,10, 900,200);
        text = Comment.getText();
        textArea = new JTextArea(text);
        textArea.setEditable(false);
        setLayout(new CardLayout());

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(5, 5, 5, 5));
        JScrollPane sp = new JScrollPane(textArea);
        add(sp);
    }

    public void refreshComments() {

        textArea.setText("");
        text =  Comment.getText();
        textArea.setText(text);
    }
}