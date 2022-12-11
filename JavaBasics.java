import java.util.Scanner;

public class JavaBasics {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.print("Enter any string: ");
        input = sc.nextLine();

        System.out.println("You entered: " + input);

        sc.close();

        // for(int i = 0; i <= 100; i++) {
        //     System.out.println((char)i);
        // }
    }
}