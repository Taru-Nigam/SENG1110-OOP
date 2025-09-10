
import java.util.*;
public class ArrayExample
{
    static Scanner console = new Scanner(System.in);
//    static int ARRAY_SIZE=0;
    static int list;
    public static void main(String[] args)
    {
        ArrayExample example = new ArrayExample();
        example.run();
    }
    public void run ()
    {
//        System.out.println("Enter size of array: ");
//        ARRAY_SIZE = console.nextInt();
//        int[] listA = new int[ARRAY_SIZE];
//        int[] listB = new int[ARRAY_SIZE];
        System.out.println("Enter size of List A: ");
        list = console.nextInt();
        int[] listA = new int[list];
        System.out.print("listA elements: ");
        printArray(listA, listA.length);
        System.out.println();
        System.out.print("Enter " + listA.length + " integers: ");
        fillArray(listA, listA.length);
        System.out.println();
        System.out.println("After filling listA, the elements are:" + "\n");
        printArray(listA, listA.length);
        System.out.println("\n");
        System.out.println("Sum of the elements of listA is: "+ sumArray(listA, listA.length)+"\n");
        System.out.println("Location of the largest element in listA is: "+ (indexLargestElement(listA,listA.length)+1)+"\n");
        System.out.println("Location of the smallest element in listA is: " + (indexSmallestElement(listA, listA.length)+1)+ "\n");
        System.out.println("Enter size of List B: ");
        list = console.nextInt();
        int[] listB = new int[list];
        System.out.println("Largest element in listA is: "+listA[indexLargestElement(listA, listA.length)]+ "\n");
        copyArray(listA, listB, listA.length);
        System.out.println("Smallest element in listA is: "+listA[indexSmallestElement(listA, listA.length)]+ "\n");
        copyArray(listA, listB, listA.length);
        System.out.print("After copying the elements of listA into listB\nlistB elements are: ");
        printArray(arrayInverter(listB), listB.length);
        System.out.println("\nTotal Number of Elements Between A And B is: " + countArray(listA, listA));
        int commonCount = countCommonElements(listA, listB);
        System.out.println("The number of common elements between A and B is: " + commonCount);

        try{
            double distance = distanceCalc(listA, listB);
            System.out.println("The Euclidean distanc between list A and B is: " + distance);
        } catch (IllegalArgumentException e){
            System.out.println("Error" + e.getMessage());
        }

        System.out.println();
    }
    //Method to input data and store in an array
    public void fillArray(int[] list, int noOfElements)
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

    public int countCommonElements(int[] listA, int[] listB){
        if (listA == null || listB == null){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : listA){
            set.add(num);
        }
        int commonCount = 0;
        for (int num : listB){
            if (set.contains(num)){
                commonCount++;
                set.remove(num);
            }
        }
        return commonCount;
    }

    public double distanceCalc(int[] listA, int[] listB){
        if (listA == null || listB == null){
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (listA.length != listB.length){
            throw new IllegalArgumentException(" Array are not the same length");
        }
        double sum = 0.0;
        for (int n = 0; n<listA.length; n++){
            sum += Math.pow(listA[n]-listB[n], 2);
        }
        return Math.sqrt(sum);
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
}
