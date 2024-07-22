import java.util.ArrayDeque;
import java.util.Deque;

public class MaxValueOfEquation {
    public int brute(int[][] points, int k) {
        int maxi =Integer.MIN_VALUE;
        int ans=-1;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                if(Math.abs(points[j][0]-points[i][0])<=k){
                    ans = Math.max(maxi, points[j][1]+points[i][1]+Math.abs(points[j][0]-points[i][0]));
                }
            }
        }
        return ans;
    }
    public int better(int[][] points, int k) {
        int max= Integer.MIN_VALUE; //assign the lowest number
        int res = 0;
        int mod = 0;
        int flag = 1;
        for(int i = 0;i<points.length-1;i++) //iteration over the points
        {
            if(flag<i+1)
                flag = i+1;
            for(int j = flag;j<points.length;j++)
            //iteration over the points again so that we can deliver the variables in the equation
            {
                mod = points[i][0]-points[j][0];
                if(mod<0)
                    mod = -mod;
                if(mod>k)
                    break;
                res = points[i][1]+points[j][1]+mod; //final equation
                if(max<res)
                {
                    max = res; //updation of max
                    flag = j-1;
                }
            }
        }
        return max;
    }
    public int optimal(int[][] points, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0 ; i < points.length; i++) {

            while (!q.isEmpty() && points[i][0] - points[q.peek()][0] > k)
                q.poll();
            if (!q.isEmpty())
                ans = Math.max(ans, points[i][0] + points[i][1] + points[q.peek()][1] - points[q.peek()][0]);

            while (!q.isEmpty() && points[q.peekLast()][1] - points[q.peekLast()][0] < points[i][1] - points[i][0])
                q.pollLast();

            q.addLast(i);
        }
        return ans;
    }
}
