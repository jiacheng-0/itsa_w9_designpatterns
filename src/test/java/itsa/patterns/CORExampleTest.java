package itsa.patterns;

// import java.util.*;
// import static org.junit.Assert.*;

import org.junit.Test;

public class CORExampleTest {
    @Test
    public void testCOR() {
        ApproverHandler rootChain = new ApproverHandler("1", 500);
        rootChain.add(new ApproverHandler("2", 1000));
        rootChain.add(new ApproverHandler("3", 1500));
        rootChain.add(new ApproverHandler("4", 1000000));

        int[] requests = {500, 1000, 1500, 5000};
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < requests.length; i++) {
            ans.append(rootChain.execute(requests[i]));

            if (i < requests.length - 1) {
                ans.append("-");
            }
        }
        System.out.println(ans);
        // In COR, the sequence should be 1-12-123-1234
        assert ans.toString().equals("1-12-123-1234") : "Sequence does not matched";
    }
}
