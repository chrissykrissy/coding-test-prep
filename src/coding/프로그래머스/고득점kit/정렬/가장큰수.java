package coding.프로그래머스.고득점kit.정렬;

import java.util.*;

public class 가장큰수 {

    public static String correct(int[] numbers) {
        String[] str = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }

        // 두 수를 합친 값이 큰 순서대로 (내림차순)
        // o1 : 10, o2 : 2 이면 102과 210 중 뭐가 더 큰지 비교
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 첫 번째 수가 0이면 0으로만 이뤄진 배열이므로 0을 리턴.
        if (str[0].equals("0")) {
            return "0";
        }

        return String.join("", str);
    }

        public static String solution(int[] numbers) {
        List<String> allComb = new ArrayList<>();
        List<String> num = new ArrayList<>();
        for(int n : numbers){
            num.add(String.valueOf(n));
        }
        permute(allComb, new ArrayList<>(), num);
        String s = String.valueOf(allComb.stream().mapToInt(Integer::parseInt).max().getAsInt());
        return s;
    }

    private static void permute(List<String> allComb, List<String> curr, List<String> num) {
        if(curr.size() == num.size()){
            allComb.add(String.join("", curr));
        }else{
            for (int j = 0; j < num.size(); j++) {
                if(curr.contains(num.get(j))) continue;
                curr.add(num.get(j));
                permute(allComb, curr, num);
                curr.remove(curr.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] n1 = {6, 10, 2};
        int[] n2 = {3, 30, 34, 5, 9};
        System.out.println(solution(n1));
        System.out.println(solution(n2));
    }
}
