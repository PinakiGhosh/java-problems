package com.bankbazaar.javaproblems.problem3.model;

import com.bankbazaar.javaproblems.problem3.exceptions.CardSuiteException;
import com.bankbazaar.javaproblems.problem3.enums.CardRank;
import com.bankbazaar.javaproblems.problem3.enums.CardSuite;


/**
 * Card Class
 */
public class Card implements Comparable<Card>
{
    private CardSuite suite;
    private CardRank number;
    /**
     * Card constructor
     * @param suite
     * @param number
     */
    public Card(String suite, String number)
    {
        /**
         * Validate entry
         */
        try
        {
            /**
             * Assign value
             */
            this.suite = CardSuite.valueOf(suite.toUpperCase());
            this.number = CardRank.valueOf(number.toUpperCase());
        }
        catch(IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Invalid Input");
        }
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Card{" +
                "suite='" + suite + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
    /**
     * GetsIndex
     */
    int getIndex(String suite)
    {

        return CardRank.valueOf(suite.toUpperCase()).ordinal();
    }

    /**
     * Sorting method
     */
    public int compareTo(Card card)
    {
        try {
            /**
             * Validate card suite
             */
            if(!suite.name().equals(card.suite.name().toUpperCase()))
            {
                throw new CardSuiteException("Card Suite are not of same type");
            }
            return getIndex(number.name()) < getIndex(card.number.name()) ? 1 : -1;
        }
        catch(CardSuiteException e) {System.out.println(e.getMessage());System.exit(0);}
        return 0;
    }



}
