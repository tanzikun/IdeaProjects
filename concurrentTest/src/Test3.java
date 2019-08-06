import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Test3 {

    //Collection<Integer> aCollection = new ArrayList();

    Integer[] merge(Integer[] arr1, Integer[] arr2) {
        java.util.Collection<Integer> aCollection = new ArrayList();

        aCollection.addAll(Arrays.asList(arr1))	;
        aCollection.addAll(Arrays.asList(arr2))	;

        Integer[] arr3 = new Integer[aCollection.size()];
        aCollection.toArray(arr3);
        return arr3;


    }

}
