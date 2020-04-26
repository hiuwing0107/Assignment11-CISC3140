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

public class Ball {

	private int x = PongMain.ScreenWidth/2;
	private int y = PongMain.ScreenHeight/2;
	private int size = 15;
	private int xVelocity = -2;
	private int yVelocity = 2;
	private int playerScore = 0;
	private int computerScore = 0;
	
	public void update() {
		
        x = x + xVelocity;
        y = y + yVelocity;

        if (x < 0) {
        	
            xVelocity = 2;
            computerScore = computerScore + 1;
            
        } else if (x + size > PongMain.ScreenWidth - 6) {
        	
            xVelocity = -2;
            playerScore = playerScore + 1; 
        }

        if (y < 0) {
        	
            yVelocity = 2; 
            
        } else if (y + size > PongMain.ScreenHeight - 55) {
        	
            yVelocity = -2;
        }
    }

    public void paint(Graphics graph) {
    	graph.setColor(Color.green);
    	graph.fillOval(x, y, size, size);
    	graph.drawString(ScorePlayer(), 5, 15);
    	graph.drawString(ScoreComputer(), 385, 15);
    }

    private void reverseDirection() {
        xVelocity = -xVelocity;
    }

    private void reverseDirectionY() {
        yVelocity = -yVelocity;
    }

    public void checkCollisionWith(Player player) {
        if (this.x > player.getX() && this.x < player.getX() + player.getWidth()) {
           if (this.y > player.getY() && this.y < player.getY() + player.getHeight()) {
              
        	   reverseDirection();
            }
        }
    }

    public void checkCollisionWith(Computer computer) {
        if (this.x > computer.getX() && this.x < computer.getX() + computer.getWidth()) {
           if (this.y > computer.getY() && this.y < computer.getY() + computer.getHeight()) {
              
        	   reverseDirection();
            }
        }
    }

    public int getX() {
    	
        return x;
    }

    public int getY() {
    	
        return y;
    }

    public int getPlayerScore() {
    	
        return playerScore;
    }

    public int getComputerScore() {
    	
        return computerScore;
    }

    public String ScorePlayer() {
    	
        String info = "";
        info = "Player Score: " + playerScore;
        return info;
    }

    public String ScoreComputer() {
        String info = "";
        info = "Computer Score: " + computerScore;
        return info;
    }
    
    public void hitWall() {
        if (this.y < 30) {
        	
            reverseDirectionY();
        }
    }
	
}
