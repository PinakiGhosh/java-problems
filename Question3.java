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

/**
 * Card Class
 */
class Card implements Comparable<Card>
{
    public String suite;
    public String number;
    private String[] cardRankList = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
    private String[] cardSuiteList = new String[] {"diamonds", "hearts", "spades", "clubs"};

    /**
     * Card constructore
     * @param suite
     * @param number
     */
    public Card(String suite, String number)
    {
        /**
         * Validate entry
         */
        if (inArray(suite,cardSuiteList)==false)
        {
            try
            {
                throw new InvalidEntryException("Invalid Input");
            }
            catch(InvalidEntryException e) {System.out.println(e.getMessage());System.exit(0);}
        }
        if (inArray(number,cardRankList)==false)
        {
            try
            {
                throw new InvalidEntryException("Invalid Input"); //Invalid cardRank exception
            }
            catch(InvalidEntryException e) {System.out.println(e.getMessage());System.exit(0);}
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


    boolean inArray(String data, String[] array)
    {
        for(int i=0;i<array.length;i++)
        {
            if(array[i].equals(data.toLowerCase()))
            {
                return true;
            }
        }
        return false;
    }

    int getIndex(String suite)
    {
        for(int i=0;i<14;i++)
        {
            if(cardRankList[i].equals(suite.toLowerCase()))
            {
                return i+1;
            }
        }
        return 0;
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
    public static void main(String[] args)
    {
        List<Card> card = new ArrayList<>();

        card.add(new Card("diamonds","ace"));
        card.add(new Card("diamonds","10"));
        card.add(new Card("diamonds","king"));

        Collections.sort(card);

        for(Card value : card)
        {
            System.out.println(value);
        }

    }
}
