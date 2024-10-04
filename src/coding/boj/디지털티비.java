package coding.boj;

import java.io.*;

public class 디지털티비 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String[] arr = new String[num];

        for (int i = 0; i < num; i++) {
            arr[i] = br.readLine();
        }

        //KBS1 을 찾은후 0까지 올려줌
        for (int i = 0; i < num; i++) {
            if(arr[i].equals("KBS1")){
                String tmp = "";
                for (int j = i; j > 0; j--) {
                    bw.write("4");
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
                break;
            }else{
                bw.write("1");
            }
        }

        //KBS2를 찾은후 1까지 올려줌
        for (int i = 0; i < num; i++) {
            if(arr[i].equals("KBS2")){
                String tmp = "";
                for (int j = i; j > 1; j--) {
                    bw.write("4");
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
                break;
            }else{
                bw.write("1");
            }
        }

        bw.flush();
    }
}
