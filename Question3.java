import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Exception Classes
 */
class InvalidEntryException  extends Exception
{
    public InvalidEntryException(String message) {super(message);}
}
class CardSuiteException  extends Exception
{
    public CardSuiteException(String message) {super(message);}
}

enum CardRank
{
    ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING,ACE;
}

enum CardSuite
{
    DIAMONDS, HEARTS, SPADES, CLUBS;
}

/**
 * Card Class
 */
class Card implements Comparable<Card>
{
    public String suite;
    public String number;
    /**
     * Card constructore
     * @param suite
     * @param number
     */
    public Card(String suite, String number) throws InvalidEntryException
    {
        /**
         * Validate entry
         */
        if (inEnum(suite, number)==false)
        {
            throw new InvalidEntryException("Invalid Input");
        }
        /**
         * Assign value
         */
        this.suite = suite;
        this.number = number;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Card{" +
                "suite='" + suite + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    /**
     * Checks if value in enum
     */
    boolean inEnum(String suite, String number) {
        int validate = 0;

        for (CardSuite card : CardSuite.values()) {
            if (card.name().equals(suite.toUpperCase())) {
                validate++;
            }
        }
        for (CardRank card : CardRank.values()) {
            if (card.name().equals(number.toUpperCase())) {
                validate++;
            }
        }

        if(validate==2)
        {
            return true;
        }
        else
        {
            return false;
        }


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
            if(!suite.equals(card.suite.toLowerCase()))
            {
                throw new CardSuiteException("Card Suite are not of same type");
            }
            return getIndex(number) < getIndex(card.number) ? 1 : -1;
        }
        catch(CardSuiteException e) {System.out.println(e.getMessage());System.exit(0);}
        return 0;
    }



}

public class Question3 {
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
