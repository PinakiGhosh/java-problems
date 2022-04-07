package com.bankbazaar.javaproblems.problem3.problem;
import com.bankbazaar.javaproblems.problem3.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem3 {
    public static void main(String[] args)
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
