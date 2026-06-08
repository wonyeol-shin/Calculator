package homework;

abstract public class Calculator {

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
