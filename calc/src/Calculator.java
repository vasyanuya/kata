import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Main result = new Main();
        System.out.println("Введите выражение:");
        String str = input.nextLine();
        String answer = result.calc(str);
        System.out.println(answer);

    }
}
class Main{
    public static String calc(String input){
        String exception = "Exception";
        String[] arr = input.split(" ");
        if (arr.length != 3) {
            return exception;
        }

        int num1;
        int num2;
        boolean isRoman = false;
        try {
            num1 = Integer.parseInt(arr[0]);
            num2 = Integer.parseInt(arr[2]);
        } catch (NumberFormatException e1) {
            try {
            Converting conv1 = Converting.valueOf(arr[0]);
            Converting conv2 = Converting.valueOf(arr[2]);
            num1 = conv1.getArabic();
            num2 = conv2.getArabic();
            isRoman = true;
            } catch (IllegalArgumentException e2) {
                return exception;
            }
        }


        if ((num1 < 1) || (num1 > 10) || (num2 < 1) || (num2 > 10)) {
            return exception;
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
                return exception;
            }
        }

        String output;

        if (isRoman){
            if (result < 1){
                return exception;
            } else {
                output = String.valueOf(Converting.values()[result - 1]);
            }
        } else {
            output = Integer.toString(result);
        }

        return output;

    }
}