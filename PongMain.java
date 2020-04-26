/*
CISC 3140 - Design and Implementation
Professor: Katherine Chuang
Student Name: Hiu Wing, Lam
Emplid: 23626630
Assignment 11 - Event Listener on the Web

11.1 Pong Game - Build a pong game clone, it have event listeners that react to real-time user input
*/

package PongGame;

import javax.swing.JFrame;

public class PongMain extends JFrame{

   // the size of the screen
   final static int ScreenWidth = 500;
   final static int ScreenHeight = 400;
	
   public static void main(String[] args) {
		
   new PongMain();
}
	
public PongMain() {
    //the constructor for window	
    setSize(ScreenWidth,ScreenHeight);
    setResizable(false);
    //the screen title
    setTitle("Welcome to Hiu Wing's Pong Game!");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
    add(new Game());
    setVisible(true);
  }
}
