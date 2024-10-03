package coding.프로그래머스.고득점kit.깊이너비우선탐색;

public class 게임맵최단거리 {

    static int[][] dir = {{0, 1}, {0,-1}, {1, 0}, {-1, 0}};
    static int answer = Integer.MAX_VALUE;
    public static int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        dfs(maps, 0, 0, 0, visited);
        return answer == Integer.MAX_VALUE ? -1 : answer+1;
    }
    private static void dfs(int[][] maps, int i, int j, int count, boolean[][] visited){
        if(i < 0 || i >= maps.length || j < 0 || j >= maps[0].length || maps[i][j] == 0 || visited[i][j]){
            return;
        }
        if(i == maps.length-1 && j == maps[0].length-1){
            answer = Math.min(count, answer);
            return;
        }
        visited[i][j] = true;
        for(int[] d : dir){
            dfs(maps, i+d[0], j+d[1], count+1, visited);
        }
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        int[][] map1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(map1));
    }


}
