package hash;

import java.util.*;

public class PonkemonSelector {
    public static int solution(int[] nums) {
        // HashSet 초기화 및 배열의 고유 요소 추가
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // 선택할 수 있는 최대 폰켓몬 수
        int pickCount = nums.length / 2;
        // 고유한 폰켓몬 수
        int setCount = set.size();

        // 선택할 수 있는 최대 폰켓몬 수와 고유한 폰켓몬 수 중 작은 값을 반환
        // return (pickCount <= setCount) ? pickCount : setCount;
        return Math.min(pickCount, setCount);
    }

    public static void main(String[] args) {
        int[] test1 = {3, 1, 2, 3};
        int[] test2 = {3, 3, 3, 2, 2, 4};
        int[] test3 = {3, 3, 3, 2, 2, 2};

        System.out.println("result: " + solution(test1));
        System.out.println("result: " + solution(test2));
        System.out.println("result: " + solution(test3));
    }
}
