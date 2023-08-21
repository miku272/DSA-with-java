/*
We are given a bar of chocolate composed of 'm x n' square pieces. One should break the chocolate into single square, Each break of a part of the chocolate is charged a cost expressed by a positive integer. This cost does not depend on the size of  the part of the part that is being broken but only depends on the line the break goes along. Let us denote the cost of breaking along consecutive vertical lines with x1, x2, ...., xm - 1 and horizontal lines with y1, y2, ..., yn - 1. Compute the minimal cost of breaking the whole chocolate into single squares.
*/

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        // int rows = 4, cols = 6;
        Integer[] costVert = { 2, 1, 3, 1, 4 };
        Integer[] costHoriz = { 4, 1, 2 };

        Arrays.sort(costVert, Collections.reverseOrder());
        Arrays.sort(costHoriz, Collections.reverseOrder());

        int h = 0, v = 0, hp = 1, vp = 1, cost = 0;

        while (h < costHoriz.length && v < costVert.length) {
            if (costVert[v] <= costHoriz[h]) { // Horizontal cut
                cost += (costHoriz[h] * vp);
                hp++;
                h++;
            } else { // Vertical cut
                cost += (costVert[v] * hp);
                vp++;
                v++;
            }
        }

        while (h < costHoriz.length) {
            cost += (costHoriz[h] * vp);
            hp++;
            h++;
        }

        while (v < costVert.length) {
            cost += (costVert[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Minimum cost: " + cost);
    }
}
