package com.Andre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



//TODO have paddle speed affect ball's direction
//TODO known issue - sometimes ball gets stuck behind human paddle

public class Main {
    static int gameSpeed = 75;  //How many milliseconds between clock ticks? Reduce this to speed up game

    static Timer timer;    //Ticks every *gameSpeed* milliseconds. Every time it ticks, the ball and computer paddle move

    static GameDisplay gamePanel;   //draw the game components here


    public static void main(String[] args) {
        runGame();
        /*
            gamePanel = new GameDisplay();


            JPanel content = new JPanel();
            content.setLayout(new BorderLayout());
            content.add(gamePanel, BorderLayout.CENTER);

            JFrame window = new JFrame();
            window.setUndecorated(true);   //Hides the title bar.

            window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   //Quit the program when we close this window
            window.setContentPane(content);
            window.setSize(gamePanel.screenSize, gamePanel.screenSize);
            window.setLocation(100, 100);    //Where on the screen will this window appear?
            window.setVisible(true);

            Controls listener = new Controls();
            window.addKeyListener(listener);

            //Below, we'll create and start a timer that notifies an ActionListener every time it ticks
            //First, need to create the listener:
            ActionListener gameUpdater = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //gameUpdater is an inner class
                    //It's containing class is Main
                    //moveBall() and moveComputerPaddle belong to the outer class - Main
                    //So we have to say Main.moveBall() to refer to these methods
                    Controls.moveBall();
                    Controls.moveComputerPaddle();

                    if (gamePanel.gameOver) {
                        timer.stop();
                        //timer.restart();
                    }
                    gamePanel.repaint();
                }
            };

            timer = new Timer(gameSpeed, gameUpdater);
            timer.start();    //Every time the timer ticks, the actionPerformed method of the ActionListener is called*/
    }

    public static void runGame() {
        gamePanel = new GameDisplay();


        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(gamePanel, BorderLayout.CENTER);

        JFrame window = new JFrame();
        window.setUndecorated(true);   //Hides the title bar.

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   //Quit the program when we close this window
        window.setContentPane(content);
        window.setSize(gamePanel.screenSize, gamePanel.screenSize);
        window.setLocation(100, 100);    //Where on the screen will this window appear?
        window.setVisible(true);

        Controls listener = new Controls();
        window.addKeyListener(listener);

        //Below, we'll create and start a timer that notifies an ActionListener every time it ticks
        //First, need to create the listener:
        ActionListener gameUpdater = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //gameUpdater is an inner class
                //It's containing class is Main
                //moveBall() and moveComputerPaddle belong to the outer class - Main
                //So we have to say Main.moveBall() to refer to these methods
                Controls.moveBall();
                Controls.moveComputerPaddle();

                if (gamePanel.gameOver) {
                    timer.stop();
                    //timer.restart();
                }
                gamePanel.repaint();
            }
        };

        timer = new Timer(gameSpeed, gameUpdater);
        timer.start();    //Every time the timer ticks, the actionPerformed method of the ActionListener is called
    }
}


