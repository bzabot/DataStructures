/*
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
*/
import java.util.HashMap;
class EX1 {

    public static void main(String[] args){
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] ans = twoSum(nums, target);
        for(int a: ans){
            System.out.println(a);
        }
    }


    public static int[] twoSum(int[] nums, int target) {
        /*
        int[] nums = {3, 2, 4};
        int target = 6;



        */


        HashMap<Integer, Integer> helper = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i<nums.length; i++){
            int difference = target - nums[i];
            if(helper.get(difference) != null){
                ans[0] = helper.get(difference);
                ans[1] = i;
                return ans;
            }
            helper.put(nums[i], i);

        }
        return ans;

    }
}