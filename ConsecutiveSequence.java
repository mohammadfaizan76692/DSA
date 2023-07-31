import java.util.*;
public class ConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        // if map.get(key) it can be start of sequence

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]-1)){
                map.put(nums[i],false);

            }
           else{
                map.put(nums[i],true);
            }
            if(map.containsKey(nums[i]+1)){
                map.put(nums[i]+1,false);
            }

        }
        int ans =0;
        for(int key:map.keySet()){
            if(map.get(key)){
                int curr =0;
                while(map.containsKey(key)){
                    key++;
                    curr++;
                }
                ans = Math.max(ans,curr);

            }
        }
        return ans;     
    }
    public static void main(String[] args) {
        int  nums[] = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));

        
    }
    
}
