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

public class Computer {
	
	private int y = PongMain.ScreenHeight / 2;
    private int width = 10;
    private int height = 50;
    private Game field;
    private int yVelocity = 0;

    public Computer(Game game) {
    	
        this.field = game;
    }

    public void update() {
    	
        if (field.getBall().getY() < this.y) {
        	
            yVelocity = -3;
        } else if (field.getBall().getY() > this.y) {
        	
            yVelocity = 3;
        }
        
        y = y + yVelocity;
    }

    public void paint(Graphics g) {
    	
        g.setColor(Color.CYAN);
        g.fillRect(PongMain.ScreenWidth - (35 + width), y, width, height);
    }

    public int getX() {
    	
        return PongMain.ScreenWidth - 6 - (35 + width);
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
