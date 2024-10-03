package coding.프로그래머스.고득점kit.그래프;

import java.util.*;
public class 방의갯수 {
    public static int mySolution(int[] arrows) {
        int answer = 0;

        // 방향 좌표 설정
        Map<Integer, int[]> loc = new HashMap<>();
        loc.put(0, new int[]{-1, 0});
        loc.put(1, new int[]{-1, 1});
        loc.put(2, new int[]{0, 1});
        loc.put(3, new int[]{1, 1});
        loc.put(4, new int[]{1, 0});
        loc.put(5, new int[]{1, -1});
        loc.put(6, new int[]{0, -1});
        loc.put(7, new int[]{-1, -1});

        // 좌표를 저장할 Set (List<Integer>로 변경)
        Set<List<Integer>> coord = new HashSet<>();

        // 시작 좌표
        int[] start = new int[]{0, 0};
        coord.add(Arrays.asList(0, 0));

        // 화살의 방향에 따라 좌표 이동
        for (int arrow : arrows) {
            // 새로운 좌표 계산
            start = new int[]{start[0] + loc.get(arrow)[0], start[1] + loc.get(arrow)[1]};
            List<Integer> newPosition = Arrays.asList(start[0], start[1]);

            // 좌표가 이미 존재하는지 확인
            if (coord.contains(newPosition)) {
                answer++;  // 이미 방문한 좌표면 방이 생긴 것
            } else {
                coord.add(newPosition);  // 새로운 좌표면 추가
            }
        }

        return answer;
    }

    public static int solution(int[] arrows) {
        int answer = 0;

        int[] dx = { 0,  1, 1, 1, 0, -1, -1, -1};
        int[] dy = {-1, -1, 0, 1, 1,  1,  0, -1};
        Node curNode = new Node(0, 0);

        // 방문 여부 관련 선언
        // key = 시작 node의 hashcode, value = 연결된 node들의 hashcode
        Map<Node, List<Node>> visited = new HashMap<>();

        for (int arrow : arrows) {
            for (int i = 0; i <= 1; i++) { // 교차점 처리를 위한 스케일업
                Node nextNode = new Node(curNode.x + dx[arrow], curNode.y + dy[arrow]);

                // 처음 방문하는 경우 = map에 키값이 없는 경우
                if (!visited.containsKey(nextNode)) {
                    // 리스트에 연결점 추가
                    visited.put(nextNode, makeEdgeList(curNode));

                    if (visited.get(curNode) == null) {
                        visited.put(curNode, makeEdgeList(nextNode));
                    } else {
                        visited.get(curNode).add(nextNode);
                    }

                    // 해당 정점을 재방문했고, 간선을 처음 통과하는 경우
                } else if (!visited.get(nextNode).contains(curNode)) {
                    visited.get(nextNode).add(curNode);
                    visited.get(curNode).add(nextNode);
                    answer++;
                }

                // 이동 완료
                curNode = nextNode;
            }
        }

        return answer;
    }

    private static List<Node> makeEdgeList(Node node) {
        List<Node> edge = new ArrayList<>();
        edge.add(node);
        return edge;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0}));
    }
}
