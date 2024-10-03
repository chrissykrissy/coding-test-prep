package coding.프로그래머스.고득점kit.깊이너비우선탐색;

import java.util.*;

class 여행경로 {
    static List<String> bestPath; // 최종 경로
    static boolean[] used;

    public static String[] solution(String[][] tickets) {
        used = new boolean[tickets.length]; // 티켓 사용 여부
        bestPath = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add("ICN"); // 시작점은 무조건 "ICN"
        dfs(tickets, "ICN", path);
        return bestPath.toArray(new String[0]); // 결과를 배열로 변환
    }

    private static void dfs(String[][] tickets, String current, List<String> path) {
        if (path.size() == tickets.length + 1) { // 모든 티켓을 다 사용한 경우
            if (bestPath.isEmpty() || comparePaths(path, bestPath)) { // 사전순 경로 선택
                bestPath = new ArrayList<>(path); // 최적 경로 갱신
            }
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(current)) { // 사용하지 않은 티켓이고 출발지가 현재 위치와 일치할 때
                used[i] = true; // 티켓 사용
                path.add(tickets[i][1]); // 도착지로 이동
                dfs(tickets, tickets[i][1], path); // 다음 경로 탐색
                path.remove(path.size() - 1); // 경로에서 제거 (백트래킹)
                used[i] = false; // 티켓 사용 취소
            }
        }
    }

    // 경로를 비교하여 사전순으로 더 작은 경로를 선택
    private static boolean comparePaths(List<String> path1, List<String> path2) {
        for (int i = 0; i < path1.size(); i++) {
            int cmp = path1.get(i).compareTo(path2.get(i));
            if (cmp < 0) return true; // path1이 사전순으로 더 앞서면 true
            else if (cmp > 0) return false; // path1이 뒤에 있으면 false
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(Arrays.toString(solution(tickets)));
    }
}