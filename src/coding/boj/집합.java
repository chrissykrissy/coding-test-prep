package coding.boj;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 집합 {
    static class MySet{
        Set<Integer> set = new HashSet<>();
        public void add(int x){
            set.add(x);
        }
        public void remove(int x){
            if(set.contains(x)){
                set.remove(x);
            }
        }

        public int check(int x){
            return set.contains(x) ? 1 : 0;
        }

        public void toggle(int x){
            if(set.contains(x)){
                set.remove(x);
            }else{
                set.add(x);
            }
        }

        public void all(){
            set = new HashSet<>();
            for (int i = 1; i <= 20; i++) {
                set.add(i);
            }
        }

        public void empty(){
            set = new HashSet<>();
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        MySet s = new MySet();
        for (int i = 0; i < n; i++) {
            String[] inst = br.readLine().split(" ");
            if(inst[0].equals("add")){
                s.add(Integer.parseInt(inst[1]));
            }else if(inst[0].equals("check")){
                bw.write(String.valueOf(s.check(Integer.parseInt(inst[1]))));
                bw.write("\n");
            }else if(inst[0].equals("remove")){
                s.remove(Integer.parseInt(inst[1]));
            }else if(inst[0].equals("toggle")){
                s.toggle(Integer.parseInt(inst[1]));
            }else if(inst[0].equals("empty")){
                s.empty();
            }else{
                s.all();
            }
        }
        bw.flush();
    }
}
