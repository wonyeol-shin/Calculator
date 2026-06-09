package homework;

import java.util.Scanner;

import static homework.Calculator.*;

public class CalculatorMain {
    public static void main(String[] args) {
        int num1 =0;
        int num2 =0;

        // 사칙연산 기호 저장
        String bao = "";
        String choice = "";
        Scanner scanner = new Scanner(System.in);

        // exit를 받을때까지 동작
        while ( true ) {
            System.out.println("1.계산하기 2.값 조회 3.값 수정 4.값 삭제 (exit 입력 시 종료)");

            System.out.print("입력 :");
            choice = scanner.nextLine();

            // 계산하기
            if (choice.equals("1")) {
                System.out.print("첫 번째 숫자를 입력하세요 : ");
                num1 = scanner.nextInt();
                System.out.print("두 번째 숫자를 입력하세요 : ");
                num2 = scanner.nextInt();
                scanner.nextLine();
                System.out.print("사칙연산 기호를 입력하세요 : ");
                bao = scanner.nextLine();

                switch (bao) {
                    case "+" -> {
                        plus(num1, num2);
                    }

                    case "-" -> {
                        minus(num1, num2);
                    }

                    case "*" -> {
                        multiple(num1, num2);
                    }

                    case "/" -> {
                        divide(num1, num2);
                    }

                    default -> {
                        System.out.println("사칙연산 기호는 (+, -, *, / )만 사용하세요 ");
                    }
                }
            }
            // 값 조회
            else if (choice.equals("2")) {
                getter();
            }
            // 값 수정
            else if (choice.equals("3")) {
                setter();
            }
            // 값 삭제
            else if (choice.equals("4")) {
                deleteFirstResult();
            }
            // 종료
            else if (choice.equals("exit")) {
                System.out.println("종료");
                break;
            }
            else {
                System.out.println("입력 오류");
            }

        }

    }

}
