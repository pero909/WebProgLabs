package ArraysAndHash.TopKFrequentElements;

import java.util.*;

public class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> integerToFreq =  new HashMap<>();
        Map<Integer,Integer> freqToInteger= new TreeMap<>(Collections.reverseOrder());

        if(k== nums.length) return nums;

        for(int num:nums){

            if(!integerToFreq.containsKey(num)){
                integerToFreq.put(num,1);
            }else integerToFreq.put(num,integerToFreq.get(num)+1);
        }

        List<Map.Entry<Integer,Integer>> list= new ArrayList<>(integerToFreq.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);


        return list.stream().limit(k).mapToInt(i->i.getKey()).toArray();
    }

    public static void main(String[] args) {
        int[] tmp={4,1,-1,2,-1,2,3};
        //new Solution().topKFrequent(tmp,2);
        topKFrequent(tmp,2);
    }
}
