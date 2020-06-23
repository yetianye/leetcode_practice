package Array.medium;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

//        int maxArea = maxArea(height);
        int maxArea = maxArea2(height);
        System.out.println(maxArea);
    }

    /**
     * 暴力法
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for(int i = 0 ; i<height.length ; i++){
            for(int j = 0 ; j<height.length ; j++){
                //遍历出所有可能的面积，
                int tempArea =  Math.min(height[i],height[j]) * Math.abs((j - i ));
                //然后取一个最大的面积
                maxArea = Math.max(maxArea,tempArea);
            }
        }
        return maxArea;
    }

    /**
     * 双指针法
     */
    public static int maxArea2(int[] height) {
        int l = 0 ; int r = height.length -1 ;
        int maxArea = 0;
        while(l < r){
           int tempArea = Math.min(height[l],height[r]) * (r - l);
            maxArea = Math.max(maxArea,tempArea);
           //舍弃短的高度
           if(height[l] < height[r] ){
                l++;
           }else{
               r--;
           }
        }
        return maxArea;
    }
}
