import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams {
    public static String GenerateKey(String str){
        int freq[] = new int[26];
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            freq[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            sb.append(freq[i]+" ");
        }
        return sb.toString();
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            String key = GenerateKey(s);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key:map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
    public static void main(String[] args) {
        String strs[]={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> list = groupAnagrams(strs);
        for(List<String> li:list){
            System.out.println(li);
        }

        
    }

    
    
}
