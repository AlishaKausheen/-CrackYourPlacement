public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum=0,rightSum=0,maxSum=0;
        for(int i=0;i<k;i++) leftSum+=cardPoints[i];
        maxSum=leftSum;
        int rightIndex= cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            leftSum =leftSum-cardPoints[i];
            rightSum+=cardPoints[rightIndex];
            rightIndex--;
            maxSum= Math.max(maxSum, leftSum+rightSum);
        }
        return maxSum;
    }
}
