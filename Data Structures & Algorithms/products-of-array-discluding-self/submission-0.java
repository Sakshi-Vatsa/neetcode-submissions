class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int prod_till_now = 1;
        int[] right_prod = new int[n];
        right_prod[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--) {
            right_prod[i]=nums[i]*right_prod[i+1];
        }
        int[] result = new int[n];
        for(int i=0;i<n-1;i++) {
            result[i] = prod_till_now * right_prod[i+1];
            prod_till_now*=nums[i];
        }
        result[n-1] = prod_till_now;
        return result;
    }
}  
