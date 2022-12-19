package ArraysAndHash.GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> returnArray= new ArrayList<>();
            Map<String, ArrayList<String>> res= new HashMap<>();
            if(strs.length==0)return returnArray;
            for(String word:strs){
                char[] hash=new char[26];
                for(Character character:word.toCharArray()){
                    hash[character-'a']++;
                }
                String str=new String(hash);
                res.computeIfAbsent(str,k->new ArrayList<>());
                res.get(str).add(word);

            }

        returnArray.addAll(res.values());





            return returnArray;
    }

}
