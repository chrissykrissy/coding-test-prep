package coding.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1762BuildingsWithanOceanView {
    public static int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int prevMax = heights[heights.length-1];
        for(int i = heights.length-1; i >= 0; i--){

            if(heights[i] >= prevMax){
                list.add(i);
                prevMax = heights[i];
            }
        }
//        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
//        Arrays.sort(res);

        int len = list.size()-1;
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[len-i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findBuildings(new int[]{4, 2, 3, 1})));
        System.out.println(Arrays.toString(findBuildings(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(findBuildings(new int[]{1, 3, 2, 4})));
    }
}
