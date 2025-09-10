import java.util.Scanner;

public class ArrayInterface {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Array array = new Array();

        System.out.println("Enter size of List A: ");
        int sizeA = console.nextInt();
        int[] listA = new int[sizeA];
        System.out.print("Enter " + sizeA + " integers for listA: ");
        array.fillArray(listA, sizeA, console);
        array.setListA(listA);

        System.out.println("After filling listA, the elements are:");
        array.printArray(array.getListA(), sizeA);
        System.out.println();

        System.out.println("Sum of the elements of listA is: " + array.sumArray(array.getListA(), sizeA));
        System.out.println("Location of the largest element in listA is: " + (array.indexLargestElement(array.getListA(), sizeA) + 1));
        System.out.println("Location of the smallest element in listA is: " + (array.indexSmallestElement(array.getListA(), sizeA) + 1));

        int sizeB;
        do {
            System.out.println("Enter size of List B (must be at least " + sizeA + "): ");
            sizeB = console.nextInt();
            if (sizeB < sizeA) {
                System.out.println("Error: Size of List B must be at least " + sizeA + ".");
            }
        } while (sizeB < sizeA);
        int[] listB = new int[sizeB];

        System.out.println("After copying the elements of listA into listB:");
        array.copyArray(array.getListA(), listB, sizeA);
        int[] invertedListB = array.arrayInverter(array.getListA());
        array.printArray(invertedListB, invertedListB.length);
        System.out.println();

        System.out.println("Total Number of Elements Between A And B is: " + array.countArray(array.getListA(), array.getListB()));
    }
}