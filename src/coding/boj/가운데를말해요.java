package coding.boj;

import java.io.*;
import java.util.*;

public class 가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int[] list = new int[num];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> max = new PriorityQueue<>((a,b) -> b-a);
        Queue<Integer> min = new PriorityQueue<>();

        for (int i = 0; i < num; i++) {
             max.offer(list[i]);
             min.offer(max.poll());
            if (max.size() < min.size()) {
                max.offer(min.poll());
            }

            if(max.size() > min.size()) bw.write(String.valueOf(max.peek()));
            else{
                bw.write(String.valueOf(Math.min(max.peek(), min.peek())));
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
