/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 */
public class Card 
{
    String cardShape;
    int cardNumber;

    public Card(String shape, int number) {
        this.cardShape = shape;
        this.cardNumber = number;
    }
    
    public int getCardNumber() {
        return this.cardNumber;
    }
    public String getCardShape() {
        return this.cardShape;
    }
    
    public String toString() {
        return this.cardShape + " " + this.cardNumber;
    }
    
}
