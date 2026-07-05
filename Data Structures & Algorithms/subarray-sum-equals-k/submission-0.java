class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++) {
            prefixSum[i]=nums[i] + prefixSum[i-1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int totalCnt = 0;
        for(int i=0;i<n;i++) {
            if(prefixSum[i]==k) totalCnt++;
            if(map.containsKey(prefixSum[i]-k)) {
                totalCnt += map.get(prefixSum[i]-k);
            }
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0)+1);
        }
        return totalCnt;
    }
}