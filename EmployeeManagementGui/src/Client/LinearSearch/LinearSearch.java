package Client.LinearSearch;

import java.util.List;

public class LinearSearch<E> {
    public static <E> int Search(List<E> list, E key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
