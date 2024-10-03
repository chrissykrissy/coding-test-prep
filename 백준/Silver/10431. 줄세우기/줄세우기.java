import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            bw.write(line[0]+" ");
            int count = 0;
            for (int j = 1; j <= 19; j++) {
                for (int k = j+1; k <= 20; k++) {
                    if(Integer.parseInt(line[j]) > Integer.parseInt(line[k])){
                        String temp = line[k];
                        line[k] = line[j];
                        line[j] = temp;
                        count++;
                    }
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
    }
}