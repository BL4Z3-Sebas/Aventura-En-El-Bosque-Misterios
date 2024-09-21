package Pruebas;

import Vista.RecursiveTree;
import javax.swing.*;
import java.awt.*;

public class TestRecursiveTree {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        RecursiveTree panel = new RecursiveTree();

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);

        JButton hideButton = new JButton("Ocultar Árbol");
        hideButton.addActionListener(e -> {
            panel.setVisible(false);  // Aquí ocultamos el panel
        });

        frame.add(hideButton, BorderLayout.SOUTH);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
