package coding.프로그래머스.고득점kit.그리디;

public class 큰수만들기 {
    public static String mySolution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int count = k;
        while(count != 0) {
            for (int i = 0; i < sb.length() - 1; i++) {
                if(sb.charAt(i) == ' ') continue;
                int nextN = i+1;
                if(sb.charAt(i+1) == ' '){
                    while(sb.charAt(nextN+1) != ' '){
                        nextN++;
                    }
                }
                if (sb.charAt(i) < sb.charAt(nextN)) {
                    sb.setCharAt(i, ' ');
                    count--;
                    if(count == 0) break;
                }
            }
        }
        return sb.toString().replaceAll(" ","");
    }

    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for(int i=0; i<number.length() - k; i++) {
            max = 0;
            for(int j = index; j<= k+i; j++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }
}
