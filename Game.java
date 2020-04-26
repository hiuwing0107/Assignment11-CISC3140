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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener, KeyListener {
    
   Player player = new Player();
   Computer computer = new Computer(this);
   Ball ball = new Ball();
    
   public Game() {
		
     Timer time = new Timer(20, this);
     time.start();
		
     this.addKeyListener(this);
     this.setFocusable(true);
   }
	
   public void update() {
		
      player.update();
      computer.update();
      ball.update();
		
      ball.checkCollisionWith(computer);
      ball.checkCollisionWith(player);
      ball.hitWall();
		
   }
	
   public void paint(Graphics graph) {
	  
      graph.setColor(Color.DARK_GRAY);
      graph.fillRect(0, 0, PongMain.ScreenWidth, PongMain.ScreenHeight);
		
      computer.paint(graph);
      player.paint(graph);
      ball.paint(graph);
		
      graph.setColor(Color.black);
      graph.drawLine(0, 30, PongMain.ScreenWidth, 30);
      graph.drawLine(PongMain.ScreenWidth/2, 30, PongMain.ScreenWidth/2, PongMain.ScreenHeight);
      graph.drawOval((PongMain.ScreenWidth/2)-30, (PongMain.ScreenHeight/2)-30, 60, 60);
      graph.setColor(Color.yellow);
        
   }
	
   public Ball getBall() {
		
      return ball;
   }
	
   //receive user's input
   public void keyPressed(KeyEvent e) {
		
       if(e.getKeyCode() == KeyEvent.VK_UP) {

	    player.setYVelocity(-5);
				
	    if (player.getY() < 40) {
			         
	       player.setYVelocity(1);
		    
	    }
             
	}
	else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					
             player.setYVelocity(5);
            
	     if (player.getY()  + 15 > PongMain.ScreenHeight - 68.5) {
	         
	        player.setYVelocity(-1);
	        	
	     }
			
	}
		
    }

	
    public void keyReleased(KeyEvent e) {
		
	if(e.getKeyCode() == KeyEvent.VK_UP) {
		   
	     player.setYVelocity(0);
	        
	}
	else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			
	     player.setYVelocity(0);
	        
	}
		
     }
	
    public void keyTyped(KeyEvent e) {
		
    }

    public void actionPerformed(ActionEvent e) {
		
         update();
	 repaint();
		
    }

}
