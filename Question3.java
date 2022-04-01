import java.util.Scanner;

//Exception Classes
class InvalidEntryException  extends Exception
{
    public InvalidEntryException(String message) {super(message);}
}
class CardSuiteException  extends Exception
{
    public CardSuiteException(String message) {super(message);}
}

//CardSelect class
class CardSelect
{
    public String[] cardRankList = new String[] {"ace", "king", "queen", "jack", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
    public String[] cardSuiteList = new String[] {"Diamonds", "Hearts", "Spades", "Clubs"};
    public int cardRank;
    public String cardRankName;
    public String cardSuite;

    public void getData() //Get card data
    {
        System.out.println("Chose Card Suite");
        System.out.println("----------------------------------------");
        for(int i=0;i<4;i++)
        {
            System.out.println((i+1)+". "+cardSuiteList[i]);
        }
        Scanner cardData1 = new Scanner(System.in);
        System.out.println("Enter option:");

        int option1 = cardData1.nextInt();
        if (option1 > 4 || option1 < 1)
        {
            try
            {
                throw new InvalidEntryException("Invalid Input"); //Invalid cardSuite exception
            }
            catch (InvalidEntryException e) {System.out.println(e.getMessage());System.exit(0);}
        }

        cardSuite=cardSuiteList[option1-1];


        System.out.println("----------------------------------------");
        System.out.println("Select Card Rank(eg:Ace,King,Queen,Jack,10,9...1)");

        Scanner cardData2 = new Scanner(System.in);
        String option2 = cardData2.nextLine();
        if (inArray(option2)==false)
        {
            try
            {
                throw new InvalidEntryException("Invalid Input"); //Invalid cardRank exception
            }
            catch(InvalidEntryException e) {System.out.println(e.getMessage());System.exit(0);}
        }

        cardRank = getIndex(option2);
    }

    public static void validate(String card1, String card2) //Validate card suite
    {
        if (!card1.equals(card2))
        {
            try
            {
                throw new CardSuiteException("Incompatible Card Suite"); //Different cardSuite type exception
            }
            catch(CardSuiteException e) {System.out.println(e.getMessage());System.exit(0);}
        }
    }

    public int getIndex(String data) //Gets the the index of card in cardRankList
    {
        for(int i=0;i<14;i++)
        {
            if(cardRankList[i].equals(data.toLowerCase()))
            {
                return i;
            }
        }
        return 0;
    }

    boolean inArray(String data) //Checks if card is valid
    {
        for(int i=0;i<14;i++)
        {
            if(cardRankList[i].equals(data.toLowerCase()))
            {
                cardRankName=cardRankList[i];
                return true;
            }
        }
        return false;
    }



}

public class Question3 {
    public static void main(String[] args)
    {
        CardSelect card1 = new CardSelect();
        CardSelect card2 = new CardSelect();

        //Get card data for card1 and card 2
        card1.getData();
        card2.getData();

        //Validate cardSuite
        CardSelect.validate(card1.cardSuite, card2.cardSuite);

        //Check bigger card
        if (card1.cardRank < card2.cardRank) {
            System.out.println(card1.cardRankName + " of " + card1.cardSuite + " is bigger than " + card2.cardRankName + " of " + card2.cardSuite);
        }
        else if (card2.cardRank < card1.cardRank) {
            System.out.println(card2.cardRankName + " of " + card2.cardSuite + " is bigger than " + card1.cardRankName + " of " + card1.cardSuite);
        }
        else
        {
            System.out.println(card2.cardRankName + " of " + card2.cardSuite + " is equal to " + card1.cardRankName + " of " + card1.cardSuite);
        }



    }
}
