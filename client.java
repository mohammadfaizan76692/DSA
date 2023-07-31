import java.util.*;
public class client {
    public static void main(String[] args) {
        HashMapImp<String,Integer> map = new HashMapImp<>();
        map.put("Faizan",38); //  put
        map.put("aizan",3);
        map.put("izan",87);
        map.put("Faiz",89);
        map.put("Fain",89);
        System.out.println(map);
        System.out.println(map.containsKey("faizan")); // containsKey()
        System.out.println(map.containsKey("Faizan"));
        System.out.println(map.get("Faizan"));  //get 
        map.remove("Faizan");  //remove 
        System.out.println(map);

    }
    
}
