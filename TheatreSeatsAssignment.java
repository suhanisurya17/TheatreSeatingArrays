/*
Name: Suhani Surya
Project Description: This program utilizes two-dimensional arrays to create an organizational seating planner. The user
                     is able to select seats by price or by seating position, and the program guides them to find the seat
                     they desire. In the option to select by seating position, they are able to select by which row and column
                     they would like. When selecting the option of selecting by price, the computer randomly generates a seat for
                     them to fit their budget. This program also incorporates input validation to ensure accurate results.
 */
import java.util.ArrayList; //importing the arrayList class that will store available seats
import java.util.Random; //importing the random class to choose available seats
import java.util.Scanner; //importing the scanner class to receive input from the user

public class TheatreSeatsAssignment //class header
{
    public static void main(String[] args)
    {
        int[][] seats = {   { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
                            { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
                            { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
                            { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
                            { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
                            { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
                            { 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 },
                            { 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
                            { 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };

        //this array stores the seating arrangement for the theatre

        final int ROWS = seats.length; //this final integer variable assigns ROWS to the number of rows in the array
        final int COLS = seats[0].length; //this final integer variable assigns COLS to the number of columns in the array

        displaySeatingArrangement(seats, ROWS, COLS);//this method prints out the seating arrangement, so I call it and send it the array, the number of rows, and the number of columns

        System.out.print("""

                The above is a bird's eye view of all the seating available
                at Corpus Christi Theatre for the Arts. Row 1 is closest to
                the stage while row 9 represents the back of the theatre.
                You can either choose a seat by entering the row and seat
                letter, or you can choose a seat by entering a price.
                """);

        //prints the instructions for the user to help understand how to use the program

        Scanner input = new Scanner(System.in); //creating a new scanner object called input and detecting input from the console
        Random rand = new Random(); //creating a new random object called rand to generate random numbers for the indexes of available seats

        int seatOrPrice; //this variable collects and stores whether the user wants to choose their seat by the seat location or by price.

        ArrayList<Integer> seatsToChooseRows = new ArrayList<>(); //this is the arrayList to store the indexes of available rows
        ArrayList<Integer> seatsToChooseCols = new ArrayList<>(); //this is the arrayList to store the indexes of available columns
        while(true)//basically a continuous/infinite loop
        {
            System.out.print("\nEnter 1 to choose by seat or 2 to choose by price: "); //this statement prints in the console to collect the method of how the users will be selecting their seat
            seatOrPrice = input.nextInt(); //assigns the scanner input to the seatOrPrice variable

            while (seatOrPrice < 1 || seatOrPrice > 2) //this is the while loop for input validation to make sure that the user enters either 1 or 2
            {
                System.out.print("That is not a valid number, please enter either 1 or 2: "); //prints that the input is invalid and reminds them to input the correct values
                seatOrPrice = input.nextInt(); //reassigns their new input to the variable seatOrPrice
            }

            int row; //this variable stores the row that the user would like their seat at
            int rowIndex;//this variable stores the index of the row that the user would like their seat at
            int seatNumberIndex;//integer data type variable storing the seat number index
            if (seatOrPrice == 1) //if the seatOrPrice variable is equal to 1
            {

                System.out.print("Enter row: "); //prompts the user to enter the row number
                row = input.nextInt(); //assigns the input to the variable called "row"

                while (row < 1 || row > 9)  //INPUT VALIDATION - this condition tests if the row number is between 1 - 9. If not, the while loop will continue running
                {
                    System.out.print("That is not a valid row, please choose a number from 1 to 9: "); //lets the user know that the row they have chosen is invalid and prompts them to choose the correct row
                    row = input.nextInt(); //reassigns the value to the variable row
                }

                rowIndex = fixedIndexRow(row);//calling the fixed row method to reverse the index and make it so it properly displays the user's row

                input.nextLine();//this line clears the keyboard to eliminate the keyboard buffer and potential exceptions in the program

                char seat; //creating a new character data type variable called char
                String seatSelection;//creating a new String data type variable called seatSelection
                System.out.print("Enter seat: "); //prompting the user to enter their seat
                seatSelection = input.nextLine().toUpperCase(); //assigning their input to the string variable
                seat = seatSelection.charAt(0); //assigning the first character in the string to the variable char

                while (seat < 'A' || seat > 'J')//comparing the unicode values of the character entered to make sure its within 0 - 9
                {
                    System.out.print("That is not a valid seat, please choose a seat from A to J: ");
                    seat = input.next().toUpperCase().charAt(0);//I made all this toUpperCase instead of lowercase to accurately compare the unicode values of the characters
                }

                seatNumberIndex = fixedIndexSeat(seat); //calling the method to fix the index and turn it into a number

                boolean isSame = false;//creating a boolean variable to track if the seat is available or not
                while (seats[rowIndex][seatNumberIndex] == -1 )
                {
                    System.out.print("That seat is taken, please try again. ");
                    isSame = true;
                    break;//break out of the while loop so that the displaySeatingArrangement method is not called
                }

                //spacing

                if(isSame) //if the boolean variable is true, just reiterate the loop. I did this so that it would not print out the seating arrangement right then because that was not shows in the example
                {
                    continue;//this stops the current iteration of the loop and restarts a new one.
                             //I did this so that when the seat is taken, it doesn't reprint the seating arrangement, as that was how it was shown in the example
                }

                seats[rowIndex][seatNumberIndex] = -1; // Assigns the user's selected seat to 0, like the actual element inside
                System.out.println();//for formatting purposes
                displaySeatingArrangement(seats, ROWS, COLS); //calling the displaySeatingArrangement method to print the seats
            }
            else
            {
                int price; //integer to get the desired price
                int randomRowIndex; //the random index variable for the seatsToChooseRows array list
                int selectedRow; //what the actual row the computer chooses
                int randomColIndex;//the random index variable for the seatsToChooseCols array list
                int selectedCol; //what the actual column the computer chooses
                System.out.print("Enter a price(10, 20, 30, 40 or 50): ");//asks the user to enter a price
                price = input.nextInt();//assigning that value entered in the console to price

                while (price != 10 && price != 20 && price != 30 && price != 40 && price != 50)//if the price is not equal to 10, 20, 30, 40 or 50
                {
                    System.out.print("That is not a valid price, please enter (10, 20, 30, 40 or 50): "); //lets them know that the price they entered is invalid and prompts them to try again
                    price = input.nextInt(); //reassigns their input to the price variable and tests the condition until the while loop condition is no longer satisfied
                }

                boolean seatAvailable = false; //this is a boolean variable that stores whether a seat is a variable or not
                for (int i = 0; i < ROWS; i++) //for loop that iterates through the whole array, as many times as the number of rows
                {
                    for (int j = 0; j < COLS; j++) //for loop iterates through the columns
                    {
                        if (seats[i][j] == price && seats[i][j] != -1) //if the element is equal to the price that the user inputted,
                        {
                            seatsToChooseRows.add(i); //add the index of that row to the arrayList called seatsToChooseRows
                            seatsToChooseCols.add(j); //add the index of that column to the arrayList called seatsToChooseCols
                            seatAvailable = true; //sets the boolean variable to true, indicating that this seat is available
                        }
                    }
                }

                if (!seatAvailable) //at the end of the loop when no more seats are available in this price range, it lets the user know that
                {
                    System.out.println("There are no tickets in that price range. Please try again."); //lets the user know that there are no more tickets available in that price range
                    continue;//restart the loop iteration by asking how the user wants to choose the price
                }
                else//if the above condition is not met
                {
                    randomRowIndex = rand.nextInt(seatsToChooseRows.size()); //choosing a random index from the array list
                    selectedRow = seatsToChooseRows.get(randomRowIndex); //getting the index corresponding to the row of the seat from seats array from that array list
                    randomColIndex = randomRowIndex;//this should be the same a randomRowIndex because the two parallel arrayLists store the row and column at the same respective indexes t ensure a unique seat is generated each time
                    selectedCol = seatsToChooseCols.get(randomColIndex); //getting the index corresponding to the column of the seat from seats array from that array list

                    int correctedSelectedRow = fixedIndexRow(selectedRow); //calling the fixedIndexRow to invert the row index to correspond with the array (because the rows are displayed from 9 and the top and 1 at the bottom)

                    char seatChar = (char) ('A' + selectedCol); //getting the proper character to display EX: "Your seat is in row 9 seat A"
                    System.out.println("Your seat is in row " + (correctedSelectedRow) + " seat " + seatChar + ".\n"); //displays the users seat

                    seats[selectedRow][selectedCol] = -1; // Mark seat as taken so another one of that kind will not be generated
                }

                displaySeatingArrangement(seats, ROWS, COLS);//calls the displaySeatingArrangement method to print the array

                seatsToChooseRows.clear();//this statement clears the arrayList
                seatsToChooseCols.clear();
            }
        }
    }

    public static void displaySeatingArrangement(int[][] seats, int rows, int columns)//this method prints out the seating arrangement
    {
        System.out.println("                        SEATS                        "); //prints the "seats" title
        System.out.println("        A   B   C   D   E   F   G   H   I   J\n"); //prints the letter representing each column


        for (int i = 0, k = rows; i < rows && k > 0; i++, k--) //for loop to iterate backwards to mirror the example; i is taking care of the number of iterations and k takes care of the actual value that is being printed

            /*
            row 9
            row 8
            row 7
            ...

            as opposed to
            row 1
            row 2
            row 3
            ...
             */
        {
            System.out.print("Row " + k); //prints the row number
            for (int j = 0; j < columns; j++) //the inner loop iterates as many times as the number of columns
            {
                if (seats[i][j] == -1) //if the value of the element is equal to 0, the program will print a red x
                {
                    System.out.print("\u001B[31m");//Changing the color before printing "XX"
                    System.out.print("  XX");//print xx
                    System.out.print("\u001B[0m"); // Reset color after printing "XX"
                }
                else//if the above condition is not met, this will execute
                {
                    System.out.printf("%4d", seats[i][j]);//this else statement regularly prints the elements in the array
                }
            }
            System.out.println();//moves the cursor to the next line
        }
    }
    public static int fixedIndexSeat(char seat) //this method turns the character into an integer to use for the index number
    //it accepts a char data type and uses switch statements to assign seatNumberIndex accordingly
    {
        if (seat >= 'A' && seat <= 'J')//comparing the unicode values to see if they are valid
        {
            return seat - 'A'; // Calculate the index based on the ASCII values of the characters
                               //For example, having 'B' has a unicode value of 1 and the return statement would be 1 - 0, which is 1. This would be the index of the column where the seat is
        }
        else //if the above statement is false
        {
            return -1; // Return -1 for invalid seat characters
        }
    }

    public static int fixedIndexRow(int selectedRow)  //this method basically reverses the indexes of the rows because in the example code, the rows are printed like so:
     /*
            row 9
            row 8
            row 7
            ...

            as opposed to
            row 1
            row 2
            row 3
            ...
             */
    {
        int rowNumberIndex; //this stores the corrected row index

        rowNumberIndex = 9 - selectedRow; //basically turns 1 into 8, 2 into 7 and so on
        return rowNumberIndex; //returns the corrected index to the main method
    }
}
