package coding.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZOAC4 {

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            double H = Double.parseDouble(input[0]);
            double W = Double.parseDouble(input[1]);
            double N = Double.parseDouble(input[2]);
            double M = Double.parseDouble(input[3]);

            int rowMax = (int) Math.ceil(H/(N+1));
            int colMax = (int) Math.ceil(W/(M+1));
            System.out.println(rowMax*colMax);
        }
}
