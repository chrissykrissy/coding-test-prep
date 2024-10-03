package coding.프로그래머스.고득점kit.깊이너비우선탐색;

public class 타겟넘버 {
    static int count = 0;
    public static int solution(int[] numbers, int target) {
        //각 숫자는 +/- 할 수 있음
        dfs(numbers, target, 0, 0);
        return count;
    }

    private static void dfs(int[] numbers, int target, int curr, int depth) {
        if(depth == numbers.length){
            if(curr == target){
                count++;
            }
            return;
        }
        dfs(numbers, target, curr - numbers[depth], depth + 1);
        dfs(numbers, target, curr + numbers[depth], depth + 1);
    }

    public static void main(String[] args) {
        //System.out.println(solution(new int[]{1,1,1,1,1}, 3));
        System.out.println(solution(new int[]{4,1,2,1}, 4));

    }

}
