package hash;

import java.util.*;

public class UncompletedPlayer {
    public static String solution(String[] participant, String[] completion) {
        // 참가자 명단을 저장할 HashMap 생성
        Map<String, Integer> map = new HashMap<>();

        // 참가자 명단을 순회하며 HashMap에 저장
        for (String player : participant) {
            // 이미 존재하는 참가자라면 값 증가, 없으면 기본값 0에서 1로 설정
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        // 완주자 명단을 순회하며 HashMap에서 값 감소
        for (String player : completion) {
            // 해당 참가자가 한 명만 존재하면 HashMap에서 제거
            if (map.get(player) == 1) {
                map.remove(player);
            } else {
                // 두 명 이상 존재하면 값 감소
                map.put(player, map.get(player) - 1);
            }
        }

        // 완주하지 못한 참가자를 저장할 변수
        String answer = "";

        // HashMap에서 남아 있는 한 명의 참가자를 찾기
        for (String uncomplete : map.keySet()) {
            answer = uncomplete;
        }

        // 완주하지 못한 참가자의 이름 반환
        return answer;
    }

    public static void main(String[] args) {

        // 테스트 케이스 1
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        System.out.println(solution(participant1, completion1)); // 출력: "leo"

        // 테스트 케이스 2
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant2, completion2)); // 출력: "vinko"

        // 테스트 케이스 3
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant3, completion3)); // 출력: "mislav"
    }
}
