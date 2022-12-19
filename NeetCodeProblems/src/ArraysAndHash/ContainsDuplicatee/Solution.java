package ArraysAndHash.ContainsDuplicatee;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean returnValue=false;
        Set<Integer> integerSet= new HashSet<>();
        for(int num:nums){
            if(!integerSet.add(num)){
                returnValue=true;
            }
        }

        return returnValue;
    }
}
