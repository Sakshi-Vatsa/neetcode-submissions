class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length(), start=0, max=0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            while(start<=i && set.contains(s.charAt(i))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(i));
            max=Math.max(max, i-start+1);
        } 
        return max;
    }
}
