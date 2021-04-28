import offer.offer_1_50.offer_38.Permutation;
import offer.offer_1_50.offer_38.impl.PermutationByRecursionImpl;
import org.junit.Test;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 16:24
 * @Version: 1.0
 */
public class Offer38_PermutationTest38 {
    @Test
    public void test() {
        Permutation permutation = new PermutationByRecursionImpl();
        String[] abcs = permutation.permutation("abcc");
        for (String abc : abcs) {
            System.out.println(abc);
        }
    }
}
