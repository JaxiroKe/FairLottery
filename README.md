Lottery Prize Distribution Program
==================================

This program takes in a comma-separated list of prize values and a comma-separated list of winner names as input, and distributes the prizes as fairly as possible among the winners.

How to Use
----------

1.  Run the program in the command line or your preferred Java IDE.
2.  When prompted, enter the prize values as a comma-separated list of integers.
3.  When prompted, enter the winner names as a comma-separated list of strings.
4.  The program will output the fairest possible distribution of prizes, with one line for each winner and the values of the prizes allocated to them.

Program Structure
-----------------

The program is structured into four functions:

*   `getPrizes`: Prompts the user to enter the prizes and returns them as an array of strings.
*   `getWinners`: Prompts the user to enter the winners and returns them as an array of strings.
*   `convertToIntegerList`: Converts an array of prize values in string format to a list of integers.
*   `distributePrizes`: Distributes the prizes among the winners as fairly as possible and returns a map of winner names to list of prize amounts.
*   `printPrizeDistribution`: Prints the fairest possible distribution of prizes.

The main function executes these functions in order and handles user input and output.