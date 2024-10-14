package coding.boj;

import java.io.*;
import java.util.StringTokenizer;

public class TeamProject {
    static int[] students;
    static boolean[] done;
    static boolean[] visited;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            students = new int[n+1];
            done = new boolean[n+1];
            visited = new boolean[n+1];
            res = 0;
            for (int j = 1; j <= n; j++) {
                students[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j <= n; j++) {
                if(done[j]) continue;
                dfs(j);
            }
            bw.write(String.valueOf(n-res)+"\n");
        }
        bw.flush();
    }

    public static void dfs(int i){
        //팀이 맞는지 체크
        if(done[i]) return; //이전에 검사
        if(visited[i]){ //방문했었다 = 사이클 구성원
            done[i] = true; //이제 다시 볼 일 없으므로 done
            res++; //사이클 구성원이므로 + 1
        }
        visited[i] = true; //방문 체크
        dfs(students[i]);
        done[i] = true; //사이클이 아닌 애들도 검사 끝났으니까 done 체크
        visited[i] = false; //방문 체크한거 초기화
    }
}
