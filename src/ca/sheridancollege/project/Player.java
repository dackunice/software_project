/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;
import java.util.ArrayList;

/**
 *
 * @author conqu
 */
public class Player {
    
    String playerName;
    String curCard;
    ArrayList<Card> cardList;
    
    public Player(String name) {
        this.playerName = name;
        this.cardList = new ArrayList<Card>(26);
    }
    
    public String getPlayerName() {
        return this.playerName;
    }
    
    public void setPlayerName(String name) {
        this.playerName = name;
    }
    
    public void addCard(Card card) {
        this.cardList.add(card);       
    } 
    
    public Card play() {    
        Card temp = this.cardList.get(0);
        this.cardList.remove(0);
        this.curCard = temp.toString();
        
       
        return temp;
    }
    
    public int getCardLeft() {
        
        return this.cardList.size();
    }
}
