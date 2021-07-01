import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Remove numbers that occurs more than the specified maximum occurrence
 * */
public class DeleteOccurrence {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(deleteNth(new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3 )));
        System.out.println(Arrays.toString(deleteNth(new int[] { 20, 37, 20, 21 }, 1)));
        System.out.println(Arrays.toString(deleteNth(new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3)));
        System.out.println(Arrays.toString(deleteNth( new int[] { 1, 1, 1, 1, 1 }, 5 )));
        System.out.println(Arrays.toString(deleteNth(new int[] { }, 5)));
        System.out.println(Arrays.toString(deleteNth(new int[]
                {21, 68, 49, 22, 50, 18, 4, 41, 18, 9, 65, 34, 81, 49, 65, 4, 23, 61, 75, 71, 1, 70, 51,
                        7, 65, 11, 46, 30, 0, 79, 68, 44, 81, 42, 18, 46, 7, 15, 55, 14, 6, 32, 30, 75,
                        47, 4, 22, 3, 33, 71, 65, 9, 79, 1, 75, 79, 41, 79,
                        58, 75, 27, 74, 14, 46, 5, 21, 68, 76, 49, 82, 42, 41, 48, 29, 35, 48, 45, 42, 68, 64, 5, 65, 3}, 1)));

    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        List<Integer> elementList = Arrays.stream(elements).boxed().collect(Collectors.toList());
        List<Integer> uniqueArray = new ArrayList<>();

        elementList.forEach(element->{
            if(!uniqueArray.contains(element)){
                uniqueArray.add(element);
            }
        });

        for (Integer uniqueNumber: uniqueArray) {
            int occurrence = 0;

            for (int i = 0; i < elementList.size(); i++) {

                if(elementList.get(i) == uniqueNumber) occurrence++;

                if(occurrence > maxOccurrences){
                    elementList.remove(i);
                    elementList.add(i, null);

                    occurrence--;
                }

            }

        }

        return elementList.stream().filter(each->each!=null).mapToInt(e->e).toArray();
    }

    public static int[] deleteNth1(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> occurrence = new HashMap<>();
        return IntStream.of(elements)
                .filter(motif -> occurrence.merge(motif, 1, Integer::sum) <= maxOccurrences)
                .toArray();
    }

}
