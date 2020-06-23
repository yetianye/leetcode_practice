package Array.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 	两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 *  你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 *  示例:
 *
 *  给定 nums = [2, 7, 11, 15], target = 9
 *
 *  因为 nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回 [0, 1]
 */

public class twoSum001 {
    public static void main(String[] args) throws Exception {

        int[] nums = {3,2,4};
        int target = 6;
//        method1(target,nums);

         //int[] result = twoSum(target,nums);
         //int[] result = twoSum2(target,nums);
         int[] result = twoSum3(target,nums);

        System.out.println(result[0]+","+result[1]);
    }

    /**
     * 垃圾循环法
     * 需要注意两个数组不能用用一个值相加
     */
    public static int[] method1(int target ,int[] nums){

        int index1 = 0;
        int index2 = 0;
        int[] result = new int[2];
        int[] nums2 = nums.clone();
        boolean tag = false;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums2.length;j++){
                int sum = nums[i] + nums2[j];
                if(sum == target && i != j){
                    index1 = i;
                    index2 = j;
                    result[0] = i;
                    result[1] = j;
                    tag = true;
                    break;
                }
            }
            if(tag){
                break;
            }
        }
        System.out.print("第一个 " + index1);
        System.out.print("第二个 " + index2);
        return result;
    }

    //李敏法
    public static int[] method2(int target , int[] nums){
        int index1 = 0;
        int index2 = 0;
        int[] result = new int[2];
        boolean tag = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < target){
               int  another_num = target-nums[i];
               int j = i+1;
               //判断下一个数 是否 和 another_num 相等
               while(j<nums.length){
                   if (another_num == nums[j])
                        result[0] = i;
                        result[1] = j;
                        tag = true;
                   break;
               }
               if(tag){
                   break;
               }
            }
        }
        System.out.print(result[0] + " - " + result[1]);
        return result;
    }

    /**
     * 暴力法
     */
    public static int[]  twoSum(int target , int[] nums) throws Exception {
        for(int i=0;i<nums.length;i++){
            //第二次循环从 i 的下个数开始
            for(int j= i + 1 ;j<nums.length;j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    return new int[] {i,j};
                }
            }
        }
        throw new Exception();
    }
    /**
     * 两遍哈希表
     */
    public static int[]  twoSum2(int target , int[] nums) throws Exception {
        Map<Integer,Integer> temp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            temp.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
           int num =  target - nums[i];
           if(temp.containsKey(num)
                   // 第一个值
                   && temp.get(num) != i ){
                return new int[]{i,temp.get(num)};
           }
        }
        throw new Exception("!!!");
    }

    /**
     * 方法三：一遍哈希表
     */
    public static int[]  twoSum3(int target , int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num = target-nums[i];
            if(map.containsKey(num)
                && map.get(num) != i ){
                return new int[]{i,map.get(num)};
            }
            //map中如果没有这个值，那么再将当前值放入map里面
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("!!!");
    }

}
