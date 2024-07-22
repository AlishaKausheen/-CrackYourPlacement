import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistributionProblem {
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        int start =0;
        int end= m-1;
        long mini=Integer.MAX_VALUE;

        while(end<a.size()){
            mini = Math.min((a.get(end)-a.get(start)),mini);
            start++;
            end++;
        }
        return mini;
    }
}
