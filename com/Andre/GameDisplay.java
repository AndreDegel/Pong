package com.Andre;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Andre on 3/18/2015.
 */
class GameDisplay extends JPanel {

    static int screenSize = 300;    //and width - screen is square
    static int paddleSize = 25;     //Actually half the paddle size - how much to draw on each side of center
    static int paddleDistanceFromSide = 10;  //How much space between each paddle and side of screen

    static int computerPaddleY = screenSize / 2 ;    //location of the center of the paddles on the Y-axis of the screen
    static int humanPaddleY = screenSize / 2 ;

    static double  ballX = screenSize / 2;   //Imagine the ball is in a square box. These are the coordinates of the top of that box.
    static double  ballY = screenSize / 2;   //So this starts the ball in (roughly) the center of the screen
    static int ballSize = 10;                //Diameter of ball


    static boolean gameOver;      //Used to work out what message, if any, to display on the screen
    static boolean removeInstructions = false;  // Same as above
    static boolean restart = false; //Used to work out the restart of the game.
    static boolean removeGameOver = false;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //System.out.println("* Repaint *");

        if (gameOver == true && !removeGameOver) {
            //see the color for the Game over text
            g.setColor(Color.red);
            g.drawString( "Game over!", 20, 30 );
            g.drawString("Press r to restart the game", 20, 60);
            //restart = true;
            //return;
        }

        if (removeInstructions == false ) {
            //set the color for the beginning text
            g.setColor(Color.black);
            g.drawString("Pong! Press up or down to move", 20, 30);
            g.drawString("Press q to quit", 20, 60);
        }

        g.setColor(Color.blue);


        //While game is playing, these methods draw the ball, paddles, using the global variables
        //Other parts of the code will modify these variables

        //set the color for the ball to red
        g.setColor(Color.green);
        //Ball - a circle is just an oval with the height equal to the width, and filled
        g.fillOval((int) ballX, (int) ballY, ballSize, ballSize);
        //set the color back to blue for the paddles
        g.setColor(Color.blue);
        //Computer paddle
        g.drawLine(paddleDistanceFromSide, computerPaddleY - paddleSize, paddleDistanceFromSide, computerPaddleY + paddleSize);
        //Human paddle
        g.drawLine(screenSize - paddleDistanceFromSide, humanPaddleY - paddleSize, screenSize - paddleDistanceFromSide, humanPaddleY + paddleSize);

    }
}
