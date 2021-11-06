import java.util.Arrays;
import java.util.Random;

public class Test2p5 {

    public static void main(String[] args) {
        int size = 7;
        OrdArray first = new OrdArray(size);
        OrdArray second = new OrdArray(size);
        int bound = 30;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            first.insert(random.nextInt(bound));
            second.insert(random.nextInt(bound));
        }
        long[] merged = second.merge(first.getArray(), second.getArray());
        System.out.println(Arrays.toString(merged));
    }
}
