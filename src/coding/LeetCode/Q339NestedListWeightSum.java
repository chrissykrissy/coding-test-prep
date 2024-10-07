package coding.LeetCode;

public class Q339NestedListWeightSum {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     public NestedInteger();
     *
     *     // Constructor initializes a single integer.
     *     public NestedInteger(int value);
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // Set this NestedInteger to hold a single integer.
     *     public void setInteger(int value);
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     public void add(NestedInteger ni);
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return empty list if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
//    public int depthSum(List<NestedInteger> nestedList) {
//        return depthSumHelper(nestedList, 1);
//    }
//
//    public int depthSumHelper(List<NestedInteger> nestedList, int depth) {
//        int sum = 0;  // sum을 지역 변수로 선언하여 재귀 호출마다 새로운 값을 가짐
//        for (int i = 0; i < nestedList.size(); i++) {
//            System.out.println("depth is : " + depth);
//            if (nestedList.get(i).isInteger()) {
//                sum += nestedList.get(i).getInteger() * depth;
//            } else {
//                sum += depthSumHelper(nestedList.get(i).getList(), depth + 1);  // 재귀적으로 합산
//            }
//            System.out.println("sum is :" + sum);
//        }
//        return sum;
//    }
}
