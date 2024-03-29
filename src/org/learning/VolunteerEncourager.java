package org.learning;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class VolunteerEncourager extends JComponent implements ActionListener {

    static String[] names = {
            "Giuseppe Mongelli", "Giulio D'Angelo", "Roberto Benfini",
            "Salvatore Bono", "Umberto Maria Faenza", "Massimo Azzini", "Alessandro Cingolani",
            "Giuseppe Gerace", "Alessandro Matricardi", "Alessandro Pirisinu",
            "Salvatore Dario Torrisi", "Valerio Carbone", "Edoardo Cicognani", "Gabriel D'Amico",
            "Francesco Carrara", "Vinicius De Miranda", "Davide Gila", "Luca Masera",
            "Mekki Ouertani", "Matteo Pupino", "Alberto Stizzoli", "Cristian Ursino",
            "Luca Mincuzzi", "Serena Peschiaroli"
    };

    static List<Integer> numbers = new ArrayList<>();
    static int delay;
    static int volunteer;
    static int count;
    static JFrame f;
    static JPanel gridPanel;
    static JPanel toolBar;
    static JLabel[] labels;
    static JButton shuffleButton;
    static Color borderColor;
    static Color labelBackground;
    static Color labelForeground;
    static Color shufflingBackground;
    static Color volunteerBackground;
    static Color buttonBackground;
    static Color buttonHover;

    public static void initGUI() {
        f = new JFrame("Volunteer Encourager");
        gridPanel = new JPanel(new GridLayout(0, 4));
        toolBar = new JPanel();
        labels = new JLabel[names.length];
        shuffleButton = new JButton("SHUFFLE");

        borderColor = new Color(239, 239, 248, 255);
        labelBackground = new Color(229, 233, 239, 255);
        labelForeground = new Color(52, 52, 61, 255);
        shufflingBackground = new Color(255, 255, 255, 255);
        volunteerBackground = new Color(135, 253, 161, 255);
        buttonBackground = new Color(190, 236, 212, 255);
        buttonHover = new Color(85, 238, 171, 255);

        LineBorder lineBorder = new LineBorder(borderColor, 1);
        EmptyBorder emptyBorder = new EmptyBorder(40, 30, 40, 30);
        CompoundBorder compoundBorder = (new CompoundBorder(lineBorder, emptyBorder));

        for (int i = 0; i < names.length; i++) {
            numbers.add(i);
            labels[i] = new JLabel(names[i]);
            labels[i].setFont(new Font("Poppins", Font.PLAIN, 13));
            labels[i].setOpaque(true);
            labels[i].setForeground(labelForeground);
            labels[i].setBackground(labelBackground);
            labels[i].setHorizontalAlignment(JLabel.CENTER);
            labels[i].setBorder(compoundBorder);
            gridPanel.add(labels[i]);
        }

        // shuffleButton.setContentAreaFilled(false);
        // shuffleButton.setBorderPainted(false);
        shuffleButton.setFocusPainted(false);

        shuffleButton.setBackground(buttonBackground);
        shuffleButton.setBorder(new EmptyBorder(15, 60, 15, 60));
        shuffleButton.setFont(new Font("Poppins", Font.PLAIN, 16));

        shuffleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                shuffleButton.setBackground(volunteerBackground);
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

        toolBar.setBorder(BorderFactory.createEmptyBorder(6, 0, 6, 0));
        toolBar.add(shuffleButton);

        f.add(gridPanel, BorderLayout.CENTER);
        f.add(toolBar, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);
    }

    public static void shuffle() {

        System.out.println("SHUFFLE");
        labels[volunteer].setBackground(labelBackground);
        Collections.shuffle(numbers);

        delay = 10;
        volunteer = 0;
        count = 0;

        new Thread(() -> {

            while (delay < 1000) {

                volunteer = numbers.get(count);
                System.out.println(delay + "ms - " + names[volunteer] + " (" + volunteer + ")");

                labels[volunteer].setBackground(shufflingBackground);

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                labels[volunteer].setBackground(labelBackground);

                delay *= 1.12;

                if (count < names.length - 1) {
                    count++;
                } else {
                    count = 0;
                    Collections.shuffle(numbers);
                }

                f.repaint();
            }

            System.out.println("volunteer is: " + names[volunteer]);
            labels[volunteer].setBackground(volunteerBackground);

        }).start();

    }

    public static void main(String[] args) {

        initGUI();

    }
}
