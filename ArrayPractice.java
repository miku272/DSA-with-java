import java.util.Scanner;

public class ArrayPractice {
    public static int getLargest(int[] numbers) {
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (largest < numbers[i]) {
                largest = numbers[i];
            }
        }

        return largest;
    }

    public static int linearArraySearch(int[] numbers, int elementToSearch) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == elementToSearch) {
                return i;
            }
        }

        return -1;
    }

    public static int binaryArraySearch(int[] numbers, int elementToSearch) {

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = { 1, 2, 5, 3 };
        int searchElement = 0, searchResult = 0;

        // System.out.println("The largest number is: " + getLargest(numbers));

        System.out.print("Enter the element you want to search: ");
        searchElement = sc.nextInt();

        searchResult = linearArraySearch(numbers, searchElement);

        if (searchResult == -1) {
            System.out.println("The desired element was not found in the array");
        } else {
            System.out.println("The desired element was found at no. " + (searchResult + 1));
        }

        sc.close();
    }
}
