package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class IIQ10 {

    //Sort an array by the order defined by another array

    public int[] sort(Integer[] array, Map<Integer, Integer> map) {

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.containsKey(o1) && map.containsKey(o2)) {
                    return map.get(o1) - map.get(o2);
                } else if (map.containsKey(o1)) {
                    return 1;
                } else if (map.containsKey(o2)) {
                    return -1;
                }
                return o1.compareTo(o2);
            }
        });

        return new int[0];

    }
}
