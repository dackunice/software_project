/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;

import java.util.ArrayList;

/**
 *
 * @author conqu
 */
public class Game {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter the name of Player1: ");
        String pName1 = in.next();
        Player player1 = new Player(pName1);
        System.out.print("Enter the name of Player2: ");
        String pName2 = in.next();
        Player player2 = new Player(pName2);  
        System.out.println("");
        
        GroupOfCards cardsDummy = new GroupOfCards(52);
      
        cardsDummy = makeDummy();
  
        cardsDummy.shuffle();
         
        ArrayList<Card> tempList = cardsDummy.getCardList();

        for(int i = 0; i <= 51; i++) {
            if(i % 2 == 0) {
                player1.addCard(tempList.get(i));  
            } else {
                player2.addCard(tempList.get(i));           
            }
        }
        
        do{
            
           int input = 0;
           
            do {          
                System.out.print(player1.getPlayerName() + " : Enter key 1 to continue game: ");
                input = in.nextInt();
            } while(input != 1);
            
            Card card1 =  player1.play(); 
            System.out.println("The card of " + player1.getPlayerName() + " is " + card1.toString());            
            System.out.println("");
            input = 0;
            
            do {
                 System.out.print(player2.getPlayerName() + " : Enter key 1 to continue game: ");
                 input = in.nextInt();
            } while(input != 1);
            
            Card card2 =  player2.play();
            
            System.out.println("The card of " + player2.getPlayerName() + " is " + card2.toString());
            
            System.out.println("");
            
            if(card1.getCardNumber() > card2.getCardNumber()) {
                
                player1.addCard(card1);
                player1.addCard(card2);
                
                System.out.println(player1.getPlayerName() + " win!");
                System.out.println(player1.getPlayerName() + " has " + player1.getCardLeft() + " cards");
                System.out.println(player2.getPlayerName() + " has " + player2.getCardLeft() + " cards");
                System.out.println("");
    
            } else if(card1.getCardNumber() < card2.getCardNumber()) {
                
                player2.addCard(card1);
                player2.addCard(card2);
                
                System.out.println(player2.getPlayerName() + " win!");
                System.out.println(player1.getPlayerName() + " has " + player1.getCardLeft() + " cards");
                System.out.println(player2.getPlayerName() + " has " + player2.getCardLeft() + " cards");
                System.out.println("");

            } else {
                
                Card card3;
                Card card4;
                
                GroupOfCards warDummy = new GroupOfCards(52);
                
                warDummy.addCard(card1);
                warDummy.addCard(card2);
                  
                System.out.println("This is War!!!");
                
                int input2 = 0;
                
                do {
                    
                    
                    do {

                     System.out.print(player1.getPlayerName() + " : Enter key 1 to continue game: ");
                     input2 = in.nextInt();

                     } while(input2 != 1);
             
                    card3 =  player1.play(); 
            
                    System.out.println("The card of " + player1.getPlayerName() + " is " + card3.toString());
            
                    System.out.println("");
            
                    input2 = 0;
            
                    do {

                        System.out.print(player2.getPlayerName() + " : Enter key 1 to continue game: ");
                        input2 = in.nextInt();

                    } while(input2 != 1);
                        

                    card4 =  player2.play();
            
                    System.out.println("The card of " + player2.getPlayerName() + " is " + card4.toString());

                    System.out.println("");

                    warDummy.addCard(card3);
                    warDummy.addCard(card4);
                    
                } while(card3.getCardNumber() == card4.getCardNumber());
                
                if(card3.getCardNumber() > card4.getCardNumber()) {

                    for(int i = 0; i < warDummy.getCardList().size(); i++) {
                        player1.addCard(warDummy.getCardList().get(i));
                    }

                    System.out.println(player1.getPlayerName() + " win!");
                       System.out.println(player1.getPlayerName() + " has " + player1.getCardLeft() + " cards");
                       System.out.println(player2.getPlayerName() + " has " + player2.getCardLeft() + " cards");
                       System.out.println("");

                } else if(card3.getCardNumber() < card4.getCardNumber()) {

                    for(int i = 0; i < warDummy.getCardList().size(); i++) {
                        player2.addCard(warDummy.getCardList().get(i));
                    }
                    System.out.println(player2.getPlayerName() + " win!");
                       System.out.println(player1.getPlayerName() + " has " + player1.getCardLeft() + " cards");
                       System.out.println(player2.getPlayerName() + " has " + player2.getCardLeft() + " cards");
                       System.out.println("");

                }
   
            }
               
        } while(result(player1, player2));
        
        
        declareWinner(player1, player1);
        
        
       
    }
    
    public static void declareWinner(Player p1, Player p2) {
        if(p1.getCardLeft() == 0) {
            System.out.println(p2.getPlayerName() + " is winner!!!");
            
        } else if(p2.getCardLeft() == 0) {        
            System.out.println(p1.getPlayerName() + " is winner!!!");
        }

    }

    public static boolean result(Player p1, Player p2) {
        
        boolean result = false;

        if(p1.getCardLeft() == 0) {
            result = false;
        } else if(p2.getCardLeft() == 0) {        
            result = false;
        } else {
            result = true;
        }
        return result;
    }
    
    public static GroupOfCards makeDummy() {
        
        GroupOfCards temp = new GroupOfCards(52);
        
        for(int i = 2; i <= 14; i++) {
            temp.addCard(new Card("spade", i));
            temp.addCard(new Card("heart", i));
            temp.addCard(new Card("diamond", i));
            temp.addCard(new Card("club", i));
        }
        
        return temp;
    }
   
    
    
}
