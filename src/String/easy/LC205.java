package String.easy;

import java.util.HashMap;
import java.util.Map;

public class LC205 {

    // use two maps to keep the one to one relationship
    // could be advance to 512, 256, or 26 array even bits

    public boolean isIsomorphic(String s, String t) {

        //cc

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0 ; i < s.length() ; i++ ) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);

            if (!sToT.containsKey(ss) && !tToS.containsKey(tt)) {
                sToT.put(ss, tt);
                tToS.put(tt, ss);
            } else if (!sToT.containsKey(ss) || !tToS.containsKey(tt)) {
                return false;
            } else {
                if (!(sToT.get(ss) == tt && tToS.get(tt) == ss)) {
                    return false;
                }
            }
        }

        return true;
    }
}
