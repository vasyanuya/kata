import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                System.out.println("введите выражение");
                String str = input.nextLine();
                String[] arr = str.split(" ");
                if (arr.length != 3) {
                    System.out.println("введите два числа и один оператор");
                } else {

                    Scanner in1 = new Scanner(arr[0]);
                    boolean t1 = in1.hasNextInt();
                    in1 = new Scanner(arr[1]);
                    char op = in1.next().charAt(0);
                    in1 = new Scanner(arr[2]);
                    boolean t2 = in1.hasNextInt();
                    if (t1 && t2) {
                        int num1 = Integer.parseInt(arr[0]);
                        int num2 = Integer.parseInt(arr[2]);
                        if ((num1 <= 10) && (num2 <= 10)) {
                            switch (op) {
                                case '+':
                                    System.out.println(num1 + num2);
                                    break;
                                case '-':
                                    System.out.println(num1 - num2);
                                    break;
                                case '*':
                                    System.out.println(num1 * num2);
                                    break;
                                case '/':
                                    System.out.println(num1 / num2);
                                    break;
                                default:
                                    System.out.println("введена неподдерживаемая операция, я знаю только +, -, *, /");
                            }
                        } else System.out.println("вводимые числа не должны быть больше 10");


                    } else if (!t1 && !t2) {
                        try {
                            Scanner in3 = new Scanner(arr[0]);
                            String rome1 = in3.next();
                            in3 = new Scanner(arr[2]);
                            String rome2 = in3.next();
                            Converting conv1 = Converting.valueOf(rome1);
                            Converting conv2 = Converting.valueOf(rome2);
                            if ((conv1 instanceof Converting) && (conv2 instanceof Converting)) {
                                int arab1 = conv1.getArabic();
                                int arab2 = conv2.getArabic();
                                if ((arab1 <= 10) && (arab2 <= 10)) {
                                    try {
                                        switch (op) {
                                            case '+':
                                                int result = arab1 + arab2;
                                                Converting resultRoman = Converting.values()[result - 1];
                                                System.out.println(resultRoman);
                                                break;
                                            case '-':
                                                result = arab1 - arab2;
                                                resultRoman = Converting.values()[result - 1];
                                                System.out.println(resultRoman);
                                                break;
                                            case '*':
                                                result = arab1 * arab2;
                                                resultRoman = Converting.values()[result - 1];
                                                System.out.println(resultRoman);
                                                break;
                                            case '/':
                                                result = arab1 / arab2;
                                                resultRoman = Converting.values()[result - 1];
                                                System.out.println(resultRoman);
                                                break;
                                            default:
                                                System.out.println("введена неподдерживаемая операция, я знаю только +, -, *, /");
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        System.out.println("в римском формате нет 0 и отрицательных чисел");
                                    }
                                } else System.out.println("оба числа должны быть не больше Х");
                            } else System.out.println("оба числа должны быть римского или арабского формата и не больше Х");
                        } catch (IllegalArgumentException e) {
                            System.out.println("введите выражение с двумя римскими или арабскими числами в одном формате");
                        }
                    } else System.out.println("оба числа должны быть одного формата");
                }
            }
        }
