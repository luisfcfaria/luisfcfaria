package academy.mindswap;

import java.util.*;

public class WordHistogram implements Iterable<String> {

    Map<String, Integer> map;




    public void analyseString(String analise) {

        String[] words = analise.toLowerCase().replace(".", "").split(" ");
        map = new HashMap<>();

        for (String s : words) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

//        map.forEach((key, value) -> System.out.println(key + ":" + value));

    }

    public int getValue(String key){
        return map.get(key);
    }

    @Override
    public Iterator<String> iterator() {
        return map.keySet().iterator();
    }


}


