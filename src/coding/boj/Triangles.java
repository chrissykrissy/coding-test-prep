package coding.boj;

import java.io.*;
import java.util.StringTokenizer;

public class Triangles {
    public static String TriangleType(int i, int j, int k){
        int max = Math.max(Math.max(i, j), k);
        int total = i + j + k;
        if(i == j && j == k){
            return "Equilateral";
        } else if (total - max <= max) {
            return "Invalid";
        }
        else if (i == j || i == k || j == k){
            return "Isosceles";
        }else{
            return "Scalene";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while((line = String.valueOf(br.readLine()))!=null){
            StringTokenizer st = new StringTokenizer(line);
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(i == 0 && j == 0 && k == 0) break;
            bw.write(TriangleType(i, j, k));
            bw.newLine();
        }
        bw.flush();
    }
}
