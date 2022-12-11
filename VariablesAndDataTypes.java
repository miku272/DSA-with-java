import java.util.Scanner;

public class VariablesAndDataTypes {

    // Question 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a, b, c, avg;

        System.out.print("Enter 1st number: ");
        a = sc.nextFloat();

        System.out.print("Enter 2nd number: ");
        b = sc.nextFloat();

        System.out.print("Enter 3rd number: ");
        c = sc.nextFloat();

        avg = (a + b + c) / 2;

        System.out.println(avg);

        sc.close();
    }

    // Question 2
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     float side, area;

    //     System.out.print("Enter the side of square: ");
    //     side = sc.nextFloat();

    //     area = side * side;

    //     System.out.println(area);

    //     sc.close();
    // }

    // Question 3
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     float pencil, pen, eraser, total, gst, bill;

    //     System.out.print("Enter the price of pencil: ");
    //     pencil = sc.nextFloat();

    //     System.out.print("Enter the price of pen: ");
    //     pen = sc.nextFloat();

    //     System.out.print("Enter the price of eraser: ");
    //     eraser = sc.nextFloat();

    //     total = pencil + pen + eraser;

    //     gst = (total * 18) / 100;

    //     bill = total + gst;

    //     System.out.println("\nTotal purchase price: " + total);
    //     System.out.println("GST applicable(18%): " + gst);
    //     System.out.println("Purchase bill: " + bill);

    //     sc.close();
    // }
}
