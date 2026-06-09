package homework;

import java.util.ArrayList;
import java.util.Scanner;

abstract public class Calculator {

    private static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Integer> results = new ArrayList<>();

    // 더하기
    public static void plus(int num1, int num2) {
        addResult(num1 + num2);
    }

    // 빼기
    public static void minus(int num1, int num2) {
        addResult(num1 - num2);
    }

    // 곱하기
    public static void multiple(int num1, int num2) {
        addResult(num1 * num2);
    }

    // 나누기
    public static void divide(int num1, int num2) {
        if (num2 == 0) {
            System.out.println("연산 취소.");
            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
            return;
        }
        addResult(num1 / num2);
    }

    // 계산 결과 저장
    private static void addResult(int result) {
        System.out.println("결과 : " + result);
        results.add(result);
    }

    // 계산 결과  조회
    public static void getter() {
        System.out.println("현재 값 :" + results);
    }

    // 계산 결과 수정
    public static void setter() {
        // 수정할 값 없으면 종료
        if (checkEmpty()) {
            System.out.println("수정 할 값이 없습니다.");
            return;
        }

        int choice = 0;
        int changeNum = 0;
        getter();
        System.out.print("무슨 값을 변경허시겠습니까?(값 중복 시 왼쪽에 있는 값 우선적용) : ");
        choice = scanner.nextInt();
        // 변경 할 값이 있는지 체크
        if (findIndex(choice)) {
            System.out.print("변경 할 값 입력");
            changeNum = scanner.nextInt();
            results.set(results.indexOf(choice), changeNum);
            System.out.println("값 수정 완료");
        }
    }

    // 계산 결과 삭제(0번 인덱스)
    public static void deleteFirstResult() {
        if (checkEmpty()) {
            System.out.println("삭제 할 값이 없습니다.");
            return;
        }
        System.out.println(results.get(0) + " 삭제 완료");
        results.remove(results.get(0));
    }

    // 수정하려는 값이 리스트에 있는지 확인
    private static boolean findIndex(int choice ) {
        // 결과가 없다면
        if (!results.contains(choice)) {
            return false;
        }
        return true;
    }

    // 삭제 수정 시 리스트가 비어있는지 확인
    private static boolean checkEmpty() {
        if (results.isEmpty()) {
            return true;
        }
        return false;
    }



}
