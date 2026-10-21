class Solution {
    public int minOperations(String s) {
        int n=s.length();

        boolean issort=true;
        char min = s.charAt(0);
        char max = s.charAt(0);

        for(int i=1;i<n;i++){
            char c = s.charAt(i);
            if (c < min) min = s.charAt(i);
            if (c > max) max = s.charAt(i);

            if(c<s.charAt(i-1)){
                issort=false;
            }
        }
        if(issort)return 0;
        if(n==2)return -1;
        if(max==s.charAt(n-1) || min==s.charAt(0))  return 1;

        int maxCount = 0, minCount = 0;
        for (int i = 0; i < n; i++) {
        char c = s.charAt(i);
        if (c == max) maxCount++;
        if (c == min) minCount++;
        }
        if (s.charAt(0) == max && s.charAt(n - 1) == min && maxCount == 1 && minCount == 1) return 3;
       return 2;
    }
}