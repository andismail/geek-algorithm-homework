package common;

import java.util.*;

public class Foo6 {

    public static void main(String[] args) {
        /*Map<String, Integer> map = new LinkedHashMap<>();
        map.put("AAAAA", 1);
        map.put("BBBBB", 2);
        map.put("CCCCC", 3);
        map.put("DDDDD", 4);
        map.put("EEEEE", 5);
        map.put("FFFFF", 6);
        map.put("GGGGG", 7);

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey());
        }*/


        Map<String, Integer> m = new HashMap<>();
        m.put("AAAAA", 1);
        m.put("BBBBB", 2);
        m.put("CCCCC", 3);
        m.put("DDDDD", 4);
        m.put("EEEEE", 5);
        m.put("FFFFF", 6);
        m.put("GGGGG", 7);
        Set<Map.Entry<String, Integer>> entries = m.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entries.iterator();

        Set<Integer> s = new HashSet<>();
        s.add(1);
        Iterator<Integer> iterator = s.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(m.put("AAAAA", null));
        System.out.println(m.put("AAAAA", 3));

    }
}
