package jeet.code;

import java.util.*;

public class MapSortByValueDesc {

    /**
     * This is only available for the sort by key desc.
     */
    class KeyComparatorDesc implements Comparator<Integer> {
        Map<Integer, Integer> base;

        public KeyComparatorDesc(Map<Integer, Integer> base) {
            this.base = base;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            int delta = o1 - o2;
            if(delta >= 0) {
                return -1;
            }else{
                return 1;
            }
        }
    }

    public static Map<Integer, Integer> sortByValue(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        Map<Integer, Integer> result = new LinkedHashMap<>();
        for(Map.Entry<Integer, Integer> entry: list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void main(String[] atgs) {
        Map<Integer, Integer> map  = new HashMap<>();
        map.put(4, 44);
        map.put(1, 11);
        map.put(3, 33);
        map.put(2, 22);
        map.put(8, 8);
        map.put(9, 99);
                /*KeyComparatorDesc comparator = new MapSortByValueDesc().new KeyComparatorDesc(map);
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(map);
        sortedMap.forEach((k,v) -> System.out.println(k));*/

        map.forEach((k, v) -> System.out.println(k+" | "+v));
        System.out.println(" -------------- ");

        MapSortByValueDesc.sortByValue(map).forEach((k, v) -> System.out.println(k+" | "+v));
        System.out.println(" -------------- ");

        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();

        map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(m -> result.put(m.getKey(), m.getValue()));

        result.forEach((k, v) -> System.out.println(k+" | "+v));
    }
}
