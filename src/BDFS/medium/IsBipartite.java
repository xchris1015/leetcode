package BDFS.medium;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsBipartite {

    // for this question, we need to iterater every index and do an bsf if we have an color has connect to same color,
    // return false;
    // how to deal with new color, use the 1 - current color

    // this question need to ask for the edge case

    public boolean isBipartite(int[][] graph) {


        int size = graph.length;
        int[] color = new int[size];
        int notFillColor = -1;
        Arrays.fill(color, notFillColor);

        for (int i = 0 ; i < color.length ; i++ ) {

            if (color[i] == notFillColor) {
                Queue<Integer> queue = new LinkedList<>();
                // fill color
                color[i] = 0;
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int currentIndex = queue.poll();

                    for (int next : graph[currentIndex]) {
                        if (color[next] == notFillColor) {
                            queue.offer(next);
                            color[next] = 1 - color[currentIndex];
                        } else {
                            if (color[next] == color[currentIndex]) {
                                return false;
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }


        }

        return true;
    }




}
