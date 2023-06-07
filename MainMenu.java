package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {
    public MainMenu() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JButton new_game = new JButton("New Game");
        new_game.addActionListener(this);
        JButton load_game = new JButton("Load Game");
        load_game.addActionListener(this);
        JButton customize = new JButton("Customize");

        JLabel title = new JLabel("JUANESTEIN");

        panel.setBorder(BorderFactory.createEmptyBorder(90, 100, 90, 100));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(title);
        panel.add(new_game);
        panel.add(load_game);
        panel.add(customize);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Juanestein!!");
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        new MainMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}