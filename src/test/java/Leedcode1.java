import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leedcode1 {
    public static void main(String[] args) {
       int[] arr = new int[]{3,2,4};
        Leedcode1 leedcode1 = new Leedcode1();
        int[] ints = leedcode1.twoSum2(arr, 6);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] tar = new int[2];
        for (int i = 0; i < length; i++) {
            int i1 = target - nums[i];
            for (int j = i+1; j < length; j++) {
                if (i1 == nums[j]) {
                    tar[0] = i;
                    tar[1] = j;
                    return tar;
                }
            }

        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i <nums.length ; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)&&map.get(complement)!=i){
               return new int[]{map.get(complement),i};
            }
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)&&map.get(complement)!=i){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
