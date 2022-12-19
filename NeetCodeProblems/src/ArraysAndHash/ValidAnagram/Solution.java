package ArraysAndHash.ValidAnagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        boolean returnValue=false;
        Map<Character,Integer> stringMap= new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(Character i: s.toCharArray()){
            if(!stringMap.containsKey(i)){
                stringMap.put(i,1);
            }else stringMap.put(i,stringMap.get(i)+1);
        }
        for(Character i:t.toCharArray()){
            if(!stringMap.containsKey(i)){
                return false;
            }else{
                stringMap.put(i,stringMap.get(i)-1);
                if(stringMap.get(i)==0){
                    stringMap.remove(i);
                }
                if(stringMap.size()==0){
                    return true;
                }
            }
        }

        return false;
    }
}
