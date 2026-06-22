package homework;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator<Double> calculator = new Calculator<>();
        startProgram(calculator);

        }

    public static  void startProgram(Calculator<Double> calculator) {
        boolean flag = true;

        while (flag) {

            // 사칙연산 기호 저장

            String choice = "";
            Scanner scanner = new Scanner(System.in);

            System.out.println("1.계산하기 2.값 조회 3.값 수정 4.값 삭제 5.값비교 (exit 입력 시 종료)");
            System.out.print("입력 :");
            choice = scanner.nextLine();


            switch (choice) {
                case "1" -> startCalculate(calculator);
                case "2" -> calculator.getter();
                case "3" -> {
                    calculator.getter();
                    System.out.print("무슨 값을 변경 하시겠습니까?(값 중복 시 왼쪽에 있는 값 우선적용) : ");
                    Double oldNum = scanner.nextDouble();
                    System.out.print("변경 할 값 입력");
                    Double changeNum = scanner.nextDouble();
                    calculator.setter(oldNum, changeNum);
                }
                case "4" -> calculator.deleteFirstResult();
                case "5" -> {
                    System.out.print("큰값 조회 : ");
                    Double bigNum = scanner.nextDouble();
                    calculator.findGreatThan(bigNum);
                }
                case "exit" -> flag = false;
                default -> {
                    System.out.println("입력 오류");
                }
            }



        }
    }


    public static void startCalculate(Calculator<Double> calculator ) {
        Double num1 =0.0;
        Double num2 =0.0;
        String bao = "";

        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요 : ");
        num1 = scanner.nextDouble();
        System.out.print("두 번째 숫자를 입력하세요 : ");
        num2 = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("사칙연산 기호를 입력하세요 : ");
        bao = scanner.nextLine();

        Operator operator = Operator.findSymbol(bao);

        if ( operator == null) {
            System.out.println("사칙연산 기호는 (+, -, *, / )만 사용하세요 ");
            return;
        }

        Double result =  operator.function.calcuate(num1, num2);
        if (result == null) {
            System.out.println("연산 취소.");
            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
            return;
        }
        calculator.addResult(result);
    }



}