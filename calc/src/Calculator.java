import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws IOException, IllegalArgumentException, ArrayIndexOutOfBoundsException {
        Scanner input = new Scanner(System.in);
        Main result = new Main();
        System.out.println("Введите выражение:");
        String str = input.nextLine();
        String answer = result.calc(str);
        System.out.println(answer);

    }
}
class Main{
    public static String calc(String input) throws IOException, IllegalArgumentException, ArrayIndexOutOfBoundsException {

        String[] arr = input.split(" ");
        if (arr.length != 3) {
            throw new IOException();
        }
        int num1;
        int num2;
        boolean isRoman = false;
        Scanner in1 = new Scanner(arr[0]);
        boolean t1 = in1.hasNextInt();
        Scanner in2 = new Scanner(arr[2]);
        boolean t2 = in2.hasNextInt();
        in1.close();
        in2.close();
        if (t1 && t2) {
            num1 = Integer.parseInt(arr[0]);
            num2 = Integer.parseInt(arr[2]);
        } else if (!t1 && !t2)
        {
            Converting conv1 = Converting.valueOf(arr[0]);
            Converting conv2 = Converting.valueOf(arr[2]);
            if ((conv1 instanceof Converting) && (conv2 instanceof Converting)) {
                num1 = conv1.getArabic();
                num2 = conv2.getArabic();
                isRoman = true;
            } else throw new ArrayIndexOutOfBoundsException();
        } else throw new IllegalArgumentException();

        if ((num1 < 1) || (num1 > 10) || (num2 < 1) || (num2 > 10)) {
            throw new IOException();
        }
        String op = arr[1];

        int result;
        switch (op) {
            case "+" ->
                    result = num1 + num2;

            case "-" ->
                    result = num1 - num2;

            case "*" ->
                    result = num1 * num2;

            case "/" ->
                    result = num1 / num2;

            default -> {
                throw new IOException();
            }
        }

        String output;

        if (isRoman){
            if (result < 1){
                throw new IOException();
            } else {
                output = String.valueOf(Converting.values()[result - 1]);
            }
        } else {
            output = Integer.toString(result);
        }

        return output;

    }
}
