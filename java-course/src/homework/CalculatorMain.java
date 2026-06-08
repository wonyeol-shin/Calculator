package homework;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        int num1 =0;
        int num2 =0;
        double result = 0;
        // 사칙연산 기호 저장
        String bao = "";
        String choice = "";
        Scanner scanner = new Scanner(System.in);

        // exit를 받을때까지 동작
        while ( !choice.equals("exit")) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            num1 = scanner.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            num2 = scanner.nextInt();
            scanner.nextLine();
            System.out.print("사칙연산 기호를 입력하세요: ");
            bao = scanner.nextLine();


            switch (bao) {
                case "+" -> {
                    result = plus(num1, num2);
                }

                case "-" -> {
                    result = minus(num1, num2);
                }

                case "*" -> {
                    result = multiple(num1, num2);
                }

                case "/" -> {
                    result = divide(num1, num2);
                }

                default -> {
                    System.out.println("사칙연산 기호는 (+, -, *, / )만 사용하세요 ");
                    result = 0;
                }

            }

            System.out.println("연산결과 : " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
            choice = scanner.nextLine();
        }

    }

    static int plus(int num1, int num2) {
        return num1 + num2;
    }

    static int minus(int num1, int num2) {
        return num1 - num2;
    }

    static int multiple(int num1, int num2) {
        return num1 * num2;
    }

    static double divide(int num1, int num2) {
        if (num2 == 0) {
            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
            System.out.println("1로 수정하여 다시 계산합니다.");
            num2 = 1;
        }
        return (double) num1 / num2;
    }
}
