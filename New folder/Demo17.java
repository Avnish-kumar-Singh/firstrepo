import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
         List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length(); 
        int numWords = words.length; 
        int totalLen = wordLen * numWords; 
        int strLen = s.length(); 

        if (strLen < totalLen) return result; 

        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> seenWords = new HashMap<>();

            while (right + wordLen <= strLen) {
                
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCount.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                    count++;

                    
                    while (seenWords.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                   
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    
                    seenWords.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
public class Demo17{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s=sc.nextLine();
        System.out.println("Enter the number of words:");
        int n=sc.nextInt();
        String[] words=new String[n];
        System.out.println("Enter the words:");
        for(int i=0;i<n;i++){
            words[i]=sc.next();
        }
        Solution sol=new Solution();
        List<Integer> result=sol.findSubstring(s, words);
        System.out.println("The starting indices of the substrings are:");
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
        sc.close();
    }
}