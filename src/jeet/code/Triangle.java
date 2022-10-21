package jeet.code;

import java.util.List;

public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1) {
            return 0;
        }
        int result = 0;
        int column = 0;
        for (int i=0;i<triangle.size();i++) {
                if (i == 0) {
                    result += triangle.get(i).get(column);
                } else if (triangle.get(i).size() > column) {
                    if (triangle.get(i).get(column) > triangle.get(i).get(column+1)) {
                        column += 1;
                        result += triangle.get(i).get(column);
                    } else {
                        result += triangle.get(i).get(column);
                    }
                } else {
                    result += triangle.get(i).get(column);
                }
        }
        return result;
    }
}
