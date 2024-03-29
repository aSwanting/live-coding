package org.learning;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class VictimSelector extends JComponent implements ActionListener {
    static List<Integer> numbers = new ArrayList<>();
    static String[] names = {
            "Giuseppe Mongelli", "Giulio D'Angelo", "Roberto Benfini",
            "Salvatore Bono", "Umberto Maria Faenza", "Massimo Azzini", "Alessandro Cingolani",
            "Giuseppe Gerace", "Alessandro Matricardi", "Alessandro Pirisinu",
            "Salvatore Dario Torrisi", "Valerio Carbone", "Edoardo Cicognani", "Gabriel D'Amico",
            "Francesco Carrara", "Vinicius De Miranda", "Davide Gila", "Luca Masera",
            "Mekki Ouertani", "Matteo Pupino", "Alberto Stizzoli", "Cristian Ursino",
            "Luca Mincuzzi", "Serena Peschiaroli"
    };
    static int delay = 10;
    static int victim = 0;
    static int count = 0;
    static JFrame f;
    static JPanel gridPanel;
    static JPanel toolBar;
    static JLabel[] labels;
    static JButton shuffleButton;
    static Color borderColor;
    static Color labelBackground;
    static Color labelForeground;
    static Color shufflingBackground;
    static Color victimBackground;
    static Color buttonBackground;
    static Color buttonHover;

    public static void initGUI() {
        f = new JFrame("Victim Selector");
        gridPanel = new JPanel(new GridLayout(0, 4));
        toolBar = new JPanel();
        labels = new JLabel[names.length];
        shuffleButton = new JButton("SHUFFLE");

        borderColor = new Color(239, 239, 248, 255);
        labelBackground = new Color(229, 233, 239, 255);
        labelForeground = new Color(52, 52, 61, 255);
        shufflingBackground = new Color(255, 255, 255, 255);
        victimBackground = new Color(135, 253, 161, 255);
        buttonBackground = new Color(224, 224, 224, 255);
        buttonHover = new Color(85, 238, 171, 255);

        for (int i = 0; i < names.length; i++) {
            numbers.add(i);
            labels[i] = new JLabel(names[i]);
            labels[i].setFont(new Font("Poppins", Font.PLAIN, 13));
            labels[i].setOpaque(true);
            labels[i].setForeground(labelForeground);
            labels[i].setBackground(labelBackground);
            labels[i].setHorizontalAlignment(JLabel.CENTER);
            labels[i].setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(borderColor, 1),
                    new EmptyBorder(40, 30, 40, 30)
            ));
            gridPanel.add(labels[i]);
        }

//        shuffleButton.setContentAreaFilled(false);
//        shuffleButton.setBorderPainted(false);
        shuffleButton.setFocusPainted(false);

        shuffleButton.setBackground(buttonBackground);
        shuffleButton.setBorder(new EmptyBorder(15, 60, 15, 60));
        shuffleButton.setFont(new Font("Poppins", Font.PLAIN, 16));

        shuffleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                shuffleButton.setBackground(victimBackground);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                shuffleButton.setBackground(buttonBackground);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                shuffle();
            }
        });

        toolBar.add(shuffleButton);
//        toolBar.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        f.add(gridPanel, BorderLayout.CENTER);
        f.add(toolBar, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);
    }

    public static void shuffle() {
        delay = 10;
        victim = 0;
        count = 0;
        System.out.println("SHUFFLE");

        Collections.shuffle(numbers);

        new Thread(() -> {

            while (delay < 1000) {

                victim = numbers.get(count);
                System.out.println(delay + "ms - " + names[victim] + " (" + victim + ")");

                labels[victim].setBackground(shufflingBackground);

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                labels[victim].setBackground(labelBackground);

                delay *= 1.12;

                if (count < names.length - 1) {
                    count++;
                } else {
                    count = 0;
                    Collections.shuffle(numbers);
                }

                f.repaint();
            }

            System.out.println("victim is: " + names[victim]);
            labels[victim].setBackground(victimBackground);

        }).start();


    }


    public static void main(String[] args) throws InterruptedException {

        initGUI();

    }
}