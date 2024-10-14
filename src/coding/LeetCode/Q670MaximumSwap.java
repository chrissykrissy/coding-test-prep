package coding.LeetCode;

public class Q670MaximumSwap {
    public static int maximumSwap(int num) {
        //the idea is to swap the left most smallest with the right most biggest

        if(num < 10) return num;
        char[] arr = String.valueOf(num).toCharArray();

        //last index of each digit
        int[] lastI = new int[10];
        for (int i = 0; i < arr.length; i++) {
            lastI[arr[i]-'0'] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            //go from the rightmost value;
            for (int j = 9; j > arr[i]-'0'; j--) {
                int lastIndexOfCandidate = lastI[j];
                //swap the first one that we encounter that's greater
                if(lastIndexOfCandidate > i){
                    //swap and return
                    char temp = arr[i];
                    arr[i] = arr[lastIndexOfCandidate];
                    arr[lastIndexOfCandidate] = temp;
                    return Integer.valueOf(new String(arr));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
    }
}
