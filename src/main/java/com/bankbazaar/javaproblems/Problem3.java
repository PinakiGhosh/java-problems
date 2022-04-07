package com.bankbazaar.javaproblems;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) throws InvalidEntryException
    {
        List<Card> card = new ArrayList<>();

        card.add(new Card("diamonds","ace"));
        card.add(new Card("diamonds","ten"));
        card.add(new Card("diamonds","king"));

        Collections.sort(card);

        for(Card value : card)
        {
            System.out.println(value);
        }

    }
}
