/* *****************************************************************************
 * My solution to leetCode 2295 with a HashMap
 * See problem description here: https://leetcode.com/contest/weekly-contest-296/problems/replace-elements-in-an-array/
 * See my repository ReplaceElementsInArray for my solution using an array
 * Below I solve with a HashMap, which cuts the runtime by 2/3 and the memory usage by 2/5
 * A HashMap is the right solution, since get and containsKey runs at O(1) in average time
 * and the order of keys does not matter.
 **************************************************************************** */

import java.util.HashMap;
import java.util.Map;

public class ReplaceElementsInArrayHashMap {
    public static int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = operations.length - 1; i >= 0; i--) {
            if (map.containsKey(operations[i][1])) {
                map.put(operations[i][0], map.get(operations[i][1]));
            }
            else {
                map.put(operations[i][0], operations[i][1]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                nums[i] = map.get(nums[i]);
            }
        }
        return nums;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 6 };
        int[][] operations = { { 1, 3 }, { 4, 7 }, { 6, 1 } };
        int[] solution = arrayChange(nums, operations);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
