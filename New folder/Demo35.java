import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int i = 0;
        while (i < strs.length) {
        String str = strs[i];
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String sortedStr = new String(charArray);
        if (!map.containsKey(sortedStr)) {
        map.put(sortedStr, new ArrayList<>());
    }
    map.get(sortedStr).add(str);
    i++;  
   }
   return new ArrayList<>(map.values());

    }
}
public class Demo35{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of strings:");
        int n=sc.nextInt();
        String[] str=new String[n];
        System.out.println("Enter the strings:");
        for(int i=0;i<n;i++){
            str[i]=sc.next();
        }
        Solution sol=new Solution();
        List<List<String>> res=sol.groupAnagrams(str);
        System.out.println(res);
        sc.close();
    }
}