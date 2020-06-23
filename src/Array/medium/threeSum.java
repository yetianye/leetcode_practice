package Array.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class threeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Vector<List<Integer>> result = threeSum(nums);

        for(List<Integer> list : result){
            for(Integer num : list){
                System.out.print(num + ",");
            }
            System.out.println("");
        }
    }

    /**
     * 暴力法
     * 有重复值
     */
    public static Vector<List<Integer>> threeSum(int[] nums) {
        Vector<List<Integer>> list = new Vector<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                for(int k=0;k<nums.length;k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        list.add(temp);
                    }
                }
            }
        }
        return list;
    }
}
