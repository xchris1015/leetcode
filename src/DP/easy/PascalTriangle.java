package DP.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> current, prev = new ArrayList<>();
        prev.add(1);

        if (rowIndex == 0) {
            return prev;
        }

        for (int i = 1 ; i <= rowIndex ; i++ ) {

            current = new ArrayList<>();
            current.add(1);

            for (int j = 1 ; j < i ; j++) {
                current.add(prev.get(j - 1) + prev.get(j));
            }

            current.add(1);
            prev = current;
        }

        return prev;
    }

    //TODO

    // by using one list and set!!!!! from left to right./

//    public List<Integer> getRow(int rowIndex) {
//        List<Integer> row =
//                new ArrayList<>(rowIndex + 1) {
//                    {
//                        add(1);
//                    }
//                };
//
//        for (int i = 0; i < rowIndex; i++) {
//            for (int j = i; j > 0; j--) {
//                row.set(j, row.get(j) + row.get(j - 1));
//            }
//            row.add(1);
//        }
//
//        return row;
//    }
}
