/*
Title: Theatre Seats Assignment - ICS4U Coding Assignment #2 [Arrays Unit]
Name: Suhani Surya
Date: March 18th - March 21st, 2024
Project Description: This program utilizes two-dimensional arrays to create an organizational seating planner. The user
                     is able to select seats by price or by seating position, and the program guides them to find the seat
                     they desire. In the option to select by seating position, they are able to select by which row and column
                     they would like. When selecting the option of selecting by price, the computer randomly generates a seat for
                     them to fit their budget. This program also incorporates input validation to ensure accurate results.
 */
package activities; //package declaration

import java.util.ArrayList; //importing the arrayList class that will store available seats
import java.util.Random; //importing the random class to choose available seats
import java.util.Scanner; //importing the scanner class to receive input from the user

public class TheatreSeatsAssignment //class header with name
{
    public static void main(String[] args) //main method header/
    {
        // 2D seats array initialization of the array called seats
        int[][] seats = {   { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
                            { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
                            { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
                            { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
                            { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
                            { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
                            { 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 },
                            { 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
                            { 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };

        //this array has 9 rows and 10 columns

        final int ROWS = seats.length; //this final integer variable assigns ROWS to the number of rows in the array
        final int COLS = seats[0].length; //this final integer variable assigns COLS to the number of columns in the array

        ArrayList<Integer> seatsToChooseRows = new ArrayList<>(); //this is the arrayList to store the indexes of available rows
        ArrayList<Integer> seatsToChooseCols = new ArrayList<>(); //this is the arrayList to store the indexes of available columns

        Scanner input = new Scanner(System.in); //creating a new scanner object called input and detecting input from the console
        Random rand = new Random(); //creating a new random object called rand to generate random numbers for the indexes of available seats


        System.out.println("                         SEATS                        ");
        System.out.println("         A   B   C   D   E   F   G   H   I   J\n"); //these lines print out the listing of different columns and the title of the array

        for (int i = 0, k = ROWS; i < ROWS && k > 0; i++, k--) //for loop that prints out all the elements in the array. This loop should iterate as many times as the number of rows in the array
        {
            System.out.print("Row " + k + " "); //I use k here to print the rows in a descending fashion as the example looks like this
            for (int j = 0; j < COLS; j++) //this nested for loop should iterate as many times as the number of columns in the array. In this case, the program with print 9 x 10 = 90 times and with all the 90 seats available
            {
                System.out.printf("%4d", seats[i][j]); //this uses printf to properly print and space out the elements
            }
            System.out.println(); //this line moves the program to the next line after every 10 elements printed in each row
        }

        System.out.print("\nThe above is a birds eye view of all the seating available" +
                "\nat Corpus Christi Theatre for the Arts. Row 1 is closest to\n" +
                "the stage while row 9 represents the back of the theatre.\n" +
                "You can either choose a seat by entering the row and seat\n" +
                "letter, or you can choose a seat by entering a price.\n");

        //these statements print the instructions available to the user so they are able to understand how to use the program

        int seatOrPrice; //this variable collects and stores whether the user wants to choose their seat by the seat location or by price.

        do //I used a do while loop so that the loop continues after at least one iteration, but in reality, my code is structured so this is an infinite loop because of the input validation in the next few statements
        {
            System.out.print("\nEnter 1 to choose by seat or 2 to choose by price: "); //this statement prints in the console to collect the method of how the users will be selecting their seat
            seatOrPrice = input.nextInt(); //assigns the scanner input to the seatOrPrice variable

            while(seatOrPrice < 1 || seatOrPrice > 2) //this is the while loop for input validation to make sure that the user enters either 1 or 2
            {
                System.out.print("That is not a valid number, please enter either 1 or 2: "); //prints that the input is invalid and reminds them to input the correct values
                seatOrPrice = input.nextInt(); //reassigns their new input to the variable seatOrPrice
            }

            //THIS SECTION IS FOR IF THE USER WANTS TO CHANGE THEIR SEAT BY POSITION
            int rowIndex = 0;

            //this variable stores the index of the row that the user would like to choose

            int row; //this variable stores the row that the user would like their seat at

            if(seatOrPrice == 1) //if the seatOrPrice variable is equal to 1
            {
                System.out.print("Enter row: "); //prompts the user to enter the row number
                row = input.nextInt(); //assigns the input to the variable called "row"

                while(row < 1 || row > 9)  //INPUT VALIDATION - this condition tests if the row number is between 1 - 9. If not, the while loop will continue running
                {
                    System.out.print("That is not a valid row, please choose a number from 1 to 9: "); //lets the user know that the row they have chosen is invalid and prompts them to choose the correct row
                    row = input.nextInt(); //reassigns the value to the variable row
                }

                input.nextLine(); //this is for the keyboard buffer to clear the keyboard so it can accept characters and strings now

                switch (row) //this switch statement is to assign the proper index to the rowIndex so it can fetch and display the proper seat. I had to do this since the example shows from row 9 at the top and row 1 at the bottom
                {
                    case 9:
                        rowIndex = 0;
                        break;
                    case 8:
                        rowIndex = 1;
                        break;
                    case 7:
                        rowIndex = 2;
                        break;
                    case 6:
                        rowIndex = 3;
                        break;
                    case 5:
                        rowIndex = 4;
                        break;
                    case 4:
                        rowIndex = 5;
                        break;
                    case 3:
                        rowIndex = 6;
                        break;
                    case 2:
                        rowIndex = 7;
                        break;
                    case 1:
                        rowIndex = 8;
                        break;
                    default:
                }



                //should find a way to make these values reversed anyways
                //SPACING





                //initializing and setting a dummy value for the seat number index
                int seatNumberIndex = 0;

                char seat; //creating a new character data type variable called char
                String seatSelection;//creating a new String data type variable called seatSelection
                System.out.print("Enter seat: "); //prompting the user to enter their seat
                seatSelection = input.nextLine().toUpperCase(); //assigning their input to the string variable
                seat = seatSelection.charAt(0); //getting the first character of the string input and assigning that to the character variable

                //the reason you want to extract the first character is that so the input is still valid even though the user mistakenly types something like "as" meaning "a"
                //I also convert everything to uppercase to it is easy to compare characters when they are all in the same case as java is a case sensitive language

                boolean correctSeatSelection; //this is a boolean variable that will store if the user has entered one of the acceptable letters for the seating columns

                if(seat == 'A' || seat == 'B' || seat == 'C' ||seat == 'D' ||seat == 'E' ||seat == 'F' ||seat == 'G' ||seat == 'H' ||seat == 'I' ||seat == 'J') //this if statement evaluates if the user's input matches any of the eligible seat columns
                {
                    correctSeatSelection = true; //if yes, the correctSeatSelection variable is set to true
                }
                else
                {
                    correctSeatSelection = false; //if no, the correctSeatSelection variable is set to false
                }

                while(!correctSeatSelection) //this while loop tests the condition that the correctSeatSelection variable is false. If so, it will iterate the loop
                {
                    System.out.print("That is no a valid seat, please choose a seat from A to J: ");//informs the user that their selected seat is invalid and prompts them to enter a proper seat
                    seatSelection = input.nextLine().toUpperCase(); //redos the process of making everything uppercase and extracting the first character

                    seat = seatSelection.charAt(0);

                    if(seat == 'A' || seat == 'B' || seat == 'C' ||seat == 'D' ||seat == 'E' ||seat == 'F' ||seat == 'G' ||seat == 'H' ||seat == 'I' ||seat == 'J') //input validation to test if the user's new input is acceptable
                    {
                        correctSeatSelection = true;
                    }
                    else
                    {
                        correctSeatSelection = false;
                    }
                }

                switch (seat)//this switch statement is to assign the proper index to the seatNumberIndex so it can fetch and display the proper seat. Essentially, it is converting their letter input to a number output that will be used to display their seat
                {
                    case 'A':
                        seatNumberIndex = 0;
                        break;
                    case 'B':
                        seatNumberIndex = 1;
                        break;

                    case 'C':
                        seatNumberIndex = 2;
                        break;

                    case 'D':
                        seatNumberIndex = 3;
                        break;

                    case 'E':
                        seatNumberIndex = 4;
                        break;

                    case 'F':
                        seatNumberIndex = 5;
                        break;

                    case 'G':
                        seatNumberIndex = 6;
                        break;

                    case 'H':
                        seatNumberIndex = 7;
                        break;

                    case 'I':
                        seatNumberIndex = 8;
                        break;

                    case 'J':
                        seatNumberIndex = 9;
                        break;

                    default:
                }

                while(seats[rowIndex][seatNumberIndex] == 0) //this condition evaluates if the element at the selected index is taken, denoted by a 0
                {
                    System.out.println("That seat is taken, please try again.");//informs the user that the seat is taken
                    System.out.print("Enter 1 to choose by seat or 2 to choose by price: ");//prompts them to redo the process of choosing a seat
                    seatOrPrice = input.nextInt();

                    while(seatOrPrice < 1 || seatOrPrice > 2)
                    {
                        System.out.print("That is not a valid number, please enter either 1 or 2: ");
                        seatOrPrice = input.nextInt();
                    }

                    if(seatOrPrice == 1)
                    {
                        System.out.print("Enter row: ");
                        row = input.nextInt();
                    }

                    while(row < 1 || row > 9)
                    {
                        System.out.print("That is not a valid row, please choose a number from 1 to 9: ");
                        row = input.nextInt();
                    }

                    switch (row) {
                        case 9 -> rowIndex = 0;
                        case 8 -> rowIndex = 1;
                        case 7 -> rowIndex = 2;
                        case 6 -> rowIndex = 3;
                        case 5 -> rowIndex = 4;
                        case 4 -> rowIndex = 5;
                        case 3 -> rowIndex = 6;
                        case 2 -> rowIndex = 7;
                        case 1 -> rowIndex = 8;
                        default -> {
                        }
                    }

                    input.nextLine();

                    System.out.print("Enter seat: ");
                    seatSelection = input.nextLine().toUpperCase();
                    seat = seatSelection.charAt(0);
                    switch (seat) {
                        case 'A' -> seatNumberIndex = 0;
                        case 'B' -> seatNumberIndex = 1;
                        case 'C' -> seatNumberIndex = 2;
                        case 'D' -> seatNumberIndex = 3;
                        case 'E' -> seatNumberIndex = 4;
                        case 'F' -> seatNumberIndex = 5;
                        case 'G' -> seatNumberIndex = 6;
                        case 'H' -> seatNumberIndex = 7;
                        case 'I' -> seatNumberIndex = 8;
                        case 'J' -> seatNumberIndex = 9;
                        default -> {
                        }
                    }

                    // Update the rowIndex and seatNumberIndex based on the new user input
                }
                seats[rowIndex][seatNumberIndex] = 0; // Assigns the user's selected seat to 0, like the actual element inside

                System.out.println("                         SEATS                        ");
                System.out.println("         A   B   C   D   E   F   G   H   I   J\n");

                for (int i = 0, k = ROWS; i < ROWS && k > 0; i++, k--)
                {
                    System.out.print("Row " + k + " ");
                    for (int j = 0; j < COLS; j++)
                    {
                        if(seats[i][j] == 0)
                        {
                            System.out.print("\u001B[31m");
                            System.out.print("  XX  ");
                            System.out.print("\u001B[0m"); // Reset color after printing "XX"
                        }
                        else
                        {
                            System.out.printf("%4d", seats[i][j]);
                        }
                    }
                    System.out.println();
                }
            }
            //if the user enters 2 and wants to choose the seat by price
            else //if (seatOrPrice == 2)
            {
                int price;
                System.out.print("Enter a price(10, 20, 30, 40 or 50): ");
                price = input.nextInt();

                while (price != 10 && price != 20 && price != 30 && price != 40 && price != 50) {
                    System.out.print("That is not a valid price, please enter (10, 20, 30, 40 or 50): ");
                    price = input.nextInt();
                }

                boolean seatAvailable = false;
                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < COLS; j++) {
                        if (seats[i][j] == price) {
                            seatsToChooseRows.add(i);
                            seatsToChooseCols.add(j);
                            seatAvailable = true;
                        }
                    }
                }

                if (!seatAvailable) {
                    System.out.println("There are no tickets in that price range. Please try again.");
                } else {
                    int randomRowIndex = rand.nextInt(seatsToChooseRows.size());
                    int selectedRow = seatsToChooseRows.get(randomRowIndex);
                    int randomColIndex = rand.nextInt(seatsToChooseCols.size());
                    int selectedCol = seatsToChooseCols.get(randomColIndex);

                    int correctedSelectedRow = -1;

                    switch (selectedRow) {
                        case 0 -> correctedSelectedRow = 8;
                        case 1 -> correctedSelectedRow = 7;
                        case 2 -> correctedSelectedRow = 6;
                        case 3 -> correctedSelectedRow = 5;
                        case 4 -> correctedSelectedRow = 4;
                        case 5 -> correctedSelectedRow = 3;
                        case 6 -> correctedSelectedRow = 2;
                        case 7 -> correctedSelectedRow = 1;
                        case 8 -> correctedSelectedRow = 0;
                        default -> {
                        }
                    }

                    char seatChar = (char) ('A' + selectedCol);
                    System.out.println("Your seat is in row " + (correctedSelectedRow + 1) + " seat " + seatChar + ".");

                    seats[selectedRow][selectedCol] = 0; // Mark seat as taken

                    System.out.println("                         SEATS                        ");
                    System.out.println("         A   B   C   D   E   F   G   H   I   J\n");


                    for (int i = 0, k = ROWS; i < ROWS && k > 0; i++, k--)
                    {
                        System.out.print("Row " + k + " ");
                        for (int j = 0; j < COLS; j++)
                        {
                            if (seats[i][j] == 0) //if the value of the element is equal to 0, the program will print a red x
                            {
                                System.out.print("\u001B[31m");//Changing the color before printing "XX"
                                System.out.print("  XX  ");
                                System.out.print("\u001B[0m"); // Reset color after printing "XX"
                            }
                            else
                            {
                                System.out.printf("%4d", seats[i][j]);//this else statement regularly prints the elements in the array
                            }
                        }
                        System.out.println();
                    }
                }
            }
        }
        while(seatOrPrice != 0); //this statement will always be true because of the input validation in the beginning of the do while loop
    }
}
