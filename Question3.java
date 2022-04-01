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

//card_select class
class card_select
{
    public String[] card_rank_list = new String[] {"ace", "king", "queen", "jack", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
    public String[] card_suite_list = new String[] {"Diamonds", "Hearts", "Spades", "Clubs"};
    public int card_rank;
    public String card_rank_name;
    public String card_suite;

    public void get_data() //Get card data
    {
        System.out.println("Chose Card Suite");
        System.out.println("----------------------------------------");
        for(int i=0;i<4;i++)
        {
            System.out.println((i+1)+". "+card_suite_list[i]);
        }
        Scanner card_data1 = new Scanner(System.in);
        System.out.println("Enter option:");

        int option1 = card_data1.nextInt();
        if (option1 > 4 || option1 < 1)
        {
            try
            {
                throw new InvalidEntryException("Invalid Input"); //Invalid card_suite exception
            }
            catch (InvalidEntryException e) {System.out.println(e.getMessage());System.exit(0);}
        }

        card_suite=card_suite_list[option1-1];


        System.out.println("----------------------------------------");
        System.out.println("Select Card Rank(eg:Ace,King,Queen,Jack,10,9...1)");

        Scanner card_data2 = new Scanner(System.in);
        String option2 = card_data2.nextLine();
        if (in_array(option2)==false)
        {
            try
            {
                throw new InvalidEntryException("Invalid Input"); //Invalid card_rank exception
            }
            catch(InvalidEntryException e) {System.out.println(e.getMessage());System.exit(0);}
        }

        card_rank = getIndex(option2);
    }

    public static void validate(String card1, String card2) //Validate card suite
    {
        if (!card1.equals(card2))
        {
            try
            {
                throw new CardSuiteException("Incompatible Card Suite"); //Different card_suite type exception
            }
            catch(CardSuiteException e) {System.out.println(e.getMessage());System.exit(0);}
        }
    }

    public int getIndex(String data) //Gets the the index of card in card_rank_list
    {
        for(int i=0;i<14;i++)
        {
            if(card_rank_list[i].equals(data.toLowerCase()))
            {
                return i;
            }
        }
        return 0;
    }

    boolean in_array(String data) //Checks if card is valid
    {
        for(int i=0;i<14;i++)
        {
            if(card_rank_list[i].equals(data.toLowerCase()))
            {
                card_rank_name=card_rank_list[i];
                return true;
            }
        }
        return false;
    }



}

public class Question3 {
    public static void main(String[] args)
    {
        card_select card1 = new card_select();
        card_select card2 = new card_select();

        //Get card data for card1 and card 2
        card1.get_data();
        card2.get_data();

        //Validate card_suite
        card_select.validate(card1.card_suite, card2.card_suite);

        //Check bigger card
        if (card1.card_rank < card2.card_rank)
            System.out.println(card1.card_rank_name+" of "+card1.card_suite+" is bigger than "+card2.card_rank_name+" of "+card2.card_suite);
        else
            System.out.println(card2.card_rank_name+" of "+card2.card_suite+" is bigger than "+card1.card_rank_name+" of "+card1.card_suite);


    }
}
