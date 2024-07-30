package hash;

import java.util.*;

class _20 {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();

        int answer = 0;

        // 1. want와 number값 매핑하기
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        // 2. 순회하면서 다 빼기
        for(int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> tempMap = new HashMap<>(map);
            boolean isPossible = true;

            for(int j = i; j < i + 10; j++) {
                String discountedProduct = discount[j];

                if(tempMap.containsKey(discountedProduct)) {
                    tempMap.put(discountedProduct, tempMap.get(discountedProduct) - 1);
                }
            }

            for(String product : want) {
                if(tempMap.get(product) > 0) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) {
                answer++;
            }
        }

        return answer;
    }
}
