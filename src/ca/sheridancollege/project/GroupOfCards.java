/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;


import java.util.ArrayList;

import java.lang.Math;

/**
 *
 * @author conqu
 */
public class GroupOfCards {
    
    int cardSize;
    ArrayList<Card> cardList;
    
    public GroupOfCards(int size) {
        this.cardSize = size;
        this.cardList = new ArrayList<Card>(size); 
    }
    
    public ArrayList<Card> getCardList() {
        return this.cardList;
    }
    
    public void addCard(Card card) {
        this.cardList.add(card);       
    } 
    
    public void shuffle() {
        
        ArrayList<Card> tempList = new ArrayList<Card>(this.cardSize);
        
        for(int i = 0; i < 52; i++) {   
            int rand = (int)(Math.random() * ((51 - i) + 1 - 0)) + 0;

            tempList.add(this.cardList.get(rand));

            this.cardList.remove(rand);
       
        }
        this.cardList = tempList;   
        
        
        
    }
    
}
