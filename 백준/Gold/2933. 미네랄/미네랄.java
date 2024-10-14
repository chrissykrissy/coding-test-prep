import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static String[][] grid;
    static int[] heights;
    static boolean[][] visited;
    static Queue<Node> q;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        /*
        1. 왼쪽 오른쪽 번갈아서 미네랄 파괴
        2. 미네랄 파괴 후 공중에 떠있는 클러스터 BFS 로 찾기
        3. 공중에 떠있는 클러스터들을 아래로 내리기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        grid = new String[R][C];
        for (int i = 0; i < R; i++) {
            grid[i] = br.readLine().split("");
        }
        st = new StringTokenizer(br.readLine());
        int numThrow = Integer.parseInt(st.nextToken());
        heights = new int[numThrow];
        st = new StringTokenizer(br.readLine());
        q = new LinkedList<>();
        for (int i = 0; i < numThrow; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
            throwing(i);
            afterThrow();
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.write(grid[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
    }

    private static void throwing(int turn){
        int loc = R-heights[turn];
        if((turn+1) % 2 == 1){ //왼쪽
            for (int i = 0; i < grid[loc].length; i++) {
                if(grid[loc][i].equals("x")){
                    grid[loc][i] = ".";
                    break;
                }
            }
        }else{
            for (int i = grid[loc].length-1; i >= 0; i--) {
                if(grid[loc][i].equals("x")){
                    grid[loc][i] = ".";
                    break;
                }
            }
        }
    }

    private static void afterThrow(){
        visited = new boolean[R][C];
        ArrayList<Node> cluster = new ArrayList<>();
        //땅에 붙어 있는 클러스터 방문 처리
        for (int i = 0; i < C; i++) {
            if(grid[R-1][i].equals(".") || visited[R-1][i]){
                continue;
            }
            visited[R-1][i] = true;
            q.add(new Node(R-1, i));
            while(!q.isEmpty()){
                Node curr = q.poll();
                for(int[] d : dir){
                    int nx = curr.x + d[0];
                    int ny = curr.y + d[1];
                    if(nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny] || grid[nx][ny].equals(".")){
                        continue;
                    }
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
        //공중에 떠 있는 클러스터 찾기 -> 방문 처리 안된것
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(!visited[i][j] && grid[i][j].equals("x")){
                    grid[i][j] = ".";
                    cluster.add(new Node(i, j));
                }
            }
        }

        if (cluster.isEmpty()) {
            return;
        }

        //클러스터 내리기
        boolean down = true;
        while(down){
            for(Node n : cluster){
                int nx = n.x + 1;
                int ny = n.y;
                if(nx < 0 || ny < 0 || nx >= R || ny >= C || grid[nx][ny].equals("x")){
                    down = false;
                    break;
                }
            }
            if(down){
                for(Node n : cluster){
                    n.x++;
                }
            }
        }

        //그리드 원소 변경
        for(Node n : cluster){
            grid[n.x][n.y] = "x";
        }
    }

}
