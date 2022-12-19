package ArraysAndHash.ProductOfArray;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix= new int[nums.length];
        int[] postfix=new int[nums.length];
        int[] res= new int[nums.length];
        //prefix[0]=nums[0];
       // postfix[0]=nums[nums.length-1];
        for(int i=0,j=nums.length-1;i<nums.length;i++){
            if(i==0){
                postfix[nums.length-1]=nums[nums.length-1];
                prefix[0]=nums[0];
            }else{
                    postfix[j] = nums[j] * postfix[j+1];
                    prefix[i] = nums[i] * prefix[i - 1];

            }
            j--;
        }
        for(int i=0;i< nums.length;i++){
            if(i==0){
                res[i]=postfix[i+1];
            }else if(i== nums.length-1){
                res[i]= prefix[i-1];
            }else res[i]=prefix[i-1]*postfix[i+1];
        }
        return res;

    }
}
