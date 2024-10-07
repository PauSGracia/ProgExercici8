import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Declare scanner
        Scanner input = new Scanner(System.in);

        //Declare variables
        final int costPerDay = 20;
        final int costPerPension = 20;
        final int costLaterCheckout = 15;
        int numPeople = 0;
        int numDays = 0;
        int pensionPeople = 0;
        int pensionDays = 0;
        int laterCheckout = 0;
        int halfPension = 0;
        int finalPrice = 0;
        boolean goodLaterCheckout = false;
        boolean goodHalfPension = false;

        System.out.println("Welcome to the hotel.");
        System.out.println("How many people are going to stay?");

        do {
            //Check if the input is a number or not
            if (input.hasNextInt())
            {
                numPeople= input.nextInt();
                //If it's a number, check if it's positive
                if (numPeople <= 0) {
                    //If it's not, ask again
                    System.out.println("That's not a valid number");
                }
            } else{
                //If it's not a number, ask again
                System.out.println("That's not a number");
            }
            //Clear input
            input.nextLine();
        } while(numPeople <= 0);

        System.out.println("How many days?");

        do {
            //Check if the input is a number or not
            if (input.hasNextInt())
            {
                numDays = input.nextInt();
                //If it's a number, check if it's positive
                if (numDays <= 0) {
                    //If it's not, ask again
                    System.out.println("That's not a valid number");
                }
            } else{
                //If it's not a number, ask again
                System.out.println("That's not a number");
            }
            //Clear input
            input.nextLine();
        } while(numDays <= 0);

        //Ask for later checkout
        System.out.println("Do you want to check out later than 12:00h?");
        System.out.println("If you do, it will cost an additional 15 euros");
        System.out.println("1. Yes");
        System.out.println("2. No");

        do {
            //Check if the input is a number or not
            if (input.hasNextInt())
            {
                laterCheckout = input.nextInt();
                //If it's a number, check if it's between 1 and 2
                if (laterCheckout != 1 && laterCheckout != 2) {
                    //If it's not, ask again
                    System.out.println("That's not a valid number");
                } else {
                    if (laterCheckout == 1)
                    {
                        //Add cost of checkout to finalPrice
                        finalPrice = costLaterCheckout;
                    }
                    goodLaterCheckout = true;
                }
            } else{
                //If it's not a number, ask again
                System.out.println("That's not a number");
            }
            //Clear input
            input.nextLine();
        } while(!goodLaterCheckout);

        //Ask if they want breakfast and lunch included
        System.out.println("Do you want breakfast and lunch included?");
        System.out.println("If you do, it will cost an additional 15 euros");
        System.out.println("1. Yes");
        System.out.println("2. No");

        do {
            //Check if the input is a number or not
            if (input.hasNextInt())
            {
                halfPension = input.nextInt();
                //If it's a number, check if it's between 1 and 2
                if (halfPension != 1 && halfPension != 2) {
                    //If it's not, ask again
                    System.out.println("That's not a valid number");
                } else {
                    goodHalfPension = true;
                }
            } else{
                //If it's not a number, ask again
                System.out.println("That's not a number");
            }
            //Clear input
            input.nextLine();
        } while(!goodHalfPension);

        if (halfPension == 1)
        {
            System.out.println("How many people?");
            do {
                //Check if the input is a number or not
                if (input.hasNextInt())
                {
                    pensionPeople = input.nextInt();
                    //If it's a number, check if it's between 1 and 2
                    if (pensionPeople < 1 || pensionPeople > numPeople) {
                        //If it's not, ask again
                        System.out.println("That's not a valid number");
                    }
                } else{
                    //If it's not a number, ask again
                    System.out.println("That's not a number");
                }
                //Clear input
                input.nextLine();
            } while(pensionPeople < 1 || pensionPeople > numPeople);
        }

        if (halfPension == 1)
        {
            System.out.println("How many days?");
            do {
                //Check if the input is a number or not
                if (input.hasNextInt())
                {
                    pensionDays = input.nextInt();
                    //If it's a number, check if it's between 1 and 2
                    if (pensionDays < 1 || pensionDays > numDays) {
                        //If it's not, ask again
                        System.out.println("That's not a valid number");
                    }
                } else{
                    //If it's not a number, ask again
                    System.out.println("That's not a number");
                }
                //Clear input
                input.nextLine();
            } while(pensionDays < 1 || pensionDays > numDays);
        }

        //calculate the final price
        finalPrice = finalPrice + costPerDay * numDays * numPeople + pensionPeople * pensionDays * costPerPension;
        System.out.println("Your final price is " + finalPrice);

    }
}