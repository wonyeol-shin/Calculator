package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Calculator<T extends  Number > {
    private final List<T> results = new ArrayList<>();

    public void findGreatThan(T threshold) {
        Double thresholdValue = threshold.doubleValue();
        results.stream().
                filter(e -> e.doubleValue() > thresholdValue)
                .forEach(System.out::println);
    }

    // 계산 결과 저장
    public void addResult(T result) {
        System.out.println("결과 : " + result);
        results.add(result);
    }

    // 계산 결과  조회
    public void getter() {
        System.out.println("현재 값 :" + results);
    }

    // 계산 결과 수정
    public void setter(T choice, T changeNum) {
        // 수정할 값 없으면 종료
        if (checkEmpty()) {
            System.out.println("수정 할 값이 없습니다.");
            return;
        }

        // 변경 할 값이 있는지 체크
        if (findIndex(choice)) {
            results.set(results.indexOf(choice), changeNum);
            System.out.println("값 수정 완료");
        }
    }

    // 계산 결과 삭제(0번 인덱스)
    public void deleteFirstResult() {
        if (checkEmpty()) {
            System.out.println("삭제 할 값이 없습니다.");
            return;
        }
        System.out.println(results.getFirst() + " 삭제 완료");
        results.remove(results.getFirst());
    }

    // 수정하려는 값이 리스트에 있는지 확인
    private boolean findIndex(T choice ) {
        // 결과가 없다면
        if (!results.contains(choice)) {
            return false;
        }
        return true;
    }

    // 삭제 수정 시 리스트가 비어있는지 확인
    private boolean checkEmpty() {
        if (results.isEmpty()) {
            return true;
        }
        return false;
    }



}
