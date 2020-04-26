/*
CISC 3140 - Design and Implementation
Professor: Katherine Chuang
Student Name: Hiu Wing, Lam
Emplid: 23626630
Assignment 11 - Event Listener on the Web

11.1 Pong Game - Build a pong game clone, it have event listeners that react to real-time user input
*/

package PongGame;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
    
    private int y = PongMain.ScreenHeight / 2;
    private int yVelocity = 0;
    private int width = 10;
    private int height = 50;
    

    public Player() {
    
    }

    public void update() {
        y = y + yVelocity;
    }
    
    //player's pladdle
    public void paint(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(35, y, width, height);
    }

    public void setYVelocity(int speed) {
        yVelocity = speed;
    }

    public int getX() {
        return 35;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
