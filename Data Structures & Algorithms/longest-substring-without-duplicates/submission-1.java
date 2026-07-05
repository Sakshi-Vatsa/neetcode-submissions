class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int start=0, max=0;
        for(int i=0;i<n;i++) {
            while(start<i && set.contains(s.charAt(i))) {
                set.remove(s.charAt(start));
                start++;
            }
            max=Math.max(max, i-start+1);
            set.add(s.charAt(i));
        }
        return max;
    }
}
