package hash;

import java.util.HashSet;

public class _18 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 8}, 6));
        System.out.println(solution(new int[]{2, 3, 5, 9}, 10));
    }

    private static boolean solution(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            // target에서 현재 원소를 뺀 값이 set에 있는지 확인
            if (set.contains(target - num)) {
                return true;
            }

            // 없다면 현재 원소를 set에 저장
            set.add(num);
        }

        return false;
    }

}
