import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());

        int cnt = 1;
        int num = 1; //시작
        int addNum = 0;
        while(n > num){
            addNum += 6; //모든 시작점은 6씩 증가
            num += addNum; //현재 depth의 시작점
            cnt++; //depth 증가
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}