import java.util.Scanner;

public class Array {
    static Scanner console = new Scanner(System.in);
    private int[] listA;
    private int[] listB;
    public void fillArray(int[] list, int noOfElements, Scanner console)
    {
        int index;
        for(index = 0; index < noOfElements; index++)
        {
            list[index] = console.nextInt();
        }
    }
    //Method to print the array
    public void printArray(int[] list, int noOfElements)
    {
        int index;
        for(index = 0; index < noOfElements; index++)
            System.out.print(list[index] + " ");
    }
    //Method to find and return the sum of an array
    public int sumArray(int[] list, int noOfElements)
    {
        int index;
        int sum = 0;
        for(index = 0; index < noOfElements; index++)
            sum = sum + list[index];
        return sum;
    }
    //Method to find and return the index of the
//largest element of an array
    public int indexLargestElement(int[] list, int noOfElements)
    {
        int index;
        int maxIndex = 0; //Assume first element is the largest
        for(index = 1; index < noOfElements; index++)
            if(list[maxIndex] < list[index])
                maxIndex = index;
        return maxIndex;
    }

    public int indexSmallestElement(int[] list, int noOfElements){
        int index;
        int minIndex = 0;
        for (index = 1; index < noOfElements; index++){
            if (list[minIndex] > list[index]){
                minIndex = index;
            }
        }
        return minIndex;
    }

    public int[] arrayInverter(int[] inputArray){
        if (inputArray == null){
            return null;
        }
        int length = inputArray.length;
        int[] invertedArray = new int[length];

        for (int i = 0; i <length; i++){
            invertedArray[i] =inputArray[length - 1 - i];
        }
        return invertedArray;
    }

    public int countArray(int[] listA, int[] listB){
        return (listA != null ? listA.length : 0) + (listB != null ? listB.length : 0);
    }

    //Method to copy one array into another array
    public void copyArray(int[] list1, int[] list2,
                          int noOfElements)
    {
        int index;
        for(index = 0; index < noOfElements; index++)
            list2[index] = list1[index];
    }

    public void setListA(int[] listA){
        this.listA = listA;
    }
    public int[] getListA(){
        return listA;
    }

    public void setListB(int[] listB){
        this.listB = listB;
    }
    public int[] getListB(){
        return listB;
    }
}
