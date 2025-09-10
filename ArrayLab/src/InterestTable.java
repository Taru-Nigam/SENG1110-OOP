import javax.swing.*;

/**
 Displays a two-dimensional table showing how
 interest rates affect bank balances.
 */
public class InterestTable
{
    public static void main (String [] args)
    {
        int [][] table = new int [10] [6];
        for (int row = 0 ; row < 10 ; row++)
            for (int column = 0 ; column < 6 ; column++)
                table [row] [column] = getBalance (1000.00, row + 1, (5 + 0.5 *
                        column));
        System.out.println ("Balances for Various Interest Rates Compounded fm  Annually");
                System.out.println ("(Rounded to Whole Dollar Amounts)");
        System.out.println ();
        System.out.println ("Years 5.00% 5.50% 6.00% 6.50% 7.00% 7.50%");
        double average = example.rowAverage
        for (int row = 0 ; row < 10 ; row++)
        {
            System.out.print ((row + 1) + " ");
            for (int column = 0 ; column < 6 ; column++)
                System.out.print ("$" + table [row] [column] + " ");
            System.out.println ();
        }
        double rowAverage
    }
    /**
     Returns the balance in an account after a given number of years
     and interest rate with an initial balance of startBalance.
     Interest is compounded annually. The balance is rounded
     to a whole number.
     */
    public static int getBalance (double startBalance, int years, double rate)
    {
        double runningBalance = startBalance;
        for (int count = 1 ; count <= years ; count++)
            runningBalance = runningBalance * (1 + rate / 100);
        return (int) (Math.round (runningBalance));
    }

    public double rowAverage(int[][] table, int row){
        if (table == null || row < 0 || row >= table.length){
            throw new IllegalArgumentException("Invalid row index or null table");
        }
        double sum = 0.0;
        int columnCount = table[row].length;

        for (int i = 0; i<columnCount; i++){
            sum += table[row][i];
        }
        return sum/columnCount;
    }
}
