class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> source = new HashMap<>();
        HashMap<Character,Integer> target = new HashMap<>();
        int start=0, n=s.length(), m=t.length(), count=0, min = n+1;
        int[] ans = new int[2]; 
        for(int i=0;i<m;i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0)+1);
        }
        for(int i=0;i<n;i++) {
            while(start<i && !target.containsKey(s.charAt(start))) start++;
            source.put(s.charAt(i), source.getOrDefault(s.charAt(i),0) + 1);
            if(target.containsKey(s.charAt(i)) && source.get(s.charAt(i)) <= target.get(s.charAt(i))) {
                count++;
            }
            while(start< i && (!target.containsKey(s.charAt(start)) || source.get(s.charAt(start)) > target.get(s.charAt(start)))) {  
                source.put(s.charAt(start), source.get(s.charAt(start)) - 1);
                if(source.get(s.charAt(start)) == 0) source.remove(s.charAt(start));
                start++;
            }

            if(count >= t.length()) {
                if(min>=i-start+1) {
                    ans = new int[]{start, i};
                    min = i-start+1;
                }
            }
            // System.out.println("Index: "+s.charAt(i) + " i: "+ i);
            // System.out.println("Count: "+count);
            // System.out.println("Min: "+min);
            // System.out.println("Start: "+start);

            // System.out.println("----------XXX----------");
            
        }
        return count >= t.length() ? s.substring(ans[0], ans[1]+1) : "";
    }
}
