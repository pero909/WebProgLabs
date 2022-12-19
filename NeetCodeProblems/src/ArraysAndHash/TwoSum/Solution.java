package ArraysAndHash.TwoSum;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] returnArray= new int[2];
        Map<Integer,Integer> intToIndexMap= new HashMap<>();

        for(int i=0;i<nums.length;i++){


                int diff=target-nums[i];
             if(intToIndexMap.containsKey(diff)){
                 returnArray[0]=i;
                 returnArray[1]=intToIndexMap.get(diff);
             }else{
                 intToIndexMap.put(nums[i],i);
             }

        }
        return returnArray;
    }
}
