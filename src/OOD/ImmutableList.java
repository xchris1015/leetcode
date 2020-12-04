package OOD;

import java.util.*;

public final class ImmutableList {

    private List<Integer> list;

    public ImmutableList(List<Integer> list) {
        this.list = list;
    }

    public Integer getter(int index) {
        return list.get(index);
    }


}
