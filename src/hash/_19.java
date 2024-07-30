package hash;

/*
많은 선수 중 단 한 명의 선수를 제외하고 모든 선수가 마라톤을 완주하였습니다.
마라톤에 참여한 선수들의 이름이 담긴 배열 participant와
완주한 선수들의 이름이 담긴 배열 completion이 있을 때
완주하지 못한 선수의 이름을 반환하는 solution() 함수를 작성하세요.
 */

import java.util.HashMap;

public class _19 {
    public static void main(String[] args) {
        // 테스트 케이스
        String[][] participants = {
                {"leo", "kiki", "eden"},
                {"marina", "josipa", "nikola", "vinko", "filipa"},
                {"mislav", "stanko", "mislav", "ana"}
        };

        String[][] completions = {
                {"eden", "kiki"},
                {"josipa", "filipa", "marina", "nikola"},
                {"stanko", "ana", "mislav"}
        };

        for (int i = 0; i < participants.length; i++) {
            String result = findNonCompleter(participants[i], completions[i]);
            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }

    public static String findNonCompleter(String[] participants, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        // 참가자 명단을 해시맵에 넣기
        for (String participant : participants) {
            map.put(participant, map.getOrDefault(participant, 0) + 1);
        }

        // 완주자 명단을 해시맵에서 제거
        for (String finisher : completion) {
            map.put(finisher, map.get(finisher) - 1);
        }

        // 값이 0보다 큰 참가자를 찾기
        for (String participant : participants) {
            if (map.get(participant) > 0) {
                return participant;
            }
        }

        return null;
    }
}
