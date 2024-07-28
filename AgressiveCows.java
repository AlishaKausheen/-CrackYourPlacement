public class AgressiveCows {
    public int approach(int[] arr , int cows){
        int ans =-1;
        Arrays.sort(arr);
        int low=1 ,high = arr[arr.length-1]-arr[0];
        while (low<=high){
            int mid = (low+high)/2;
            if (placeCows(arr,mid,cows)==true);
            {
                ans =mid;
                low =mid+1;
            }else high =mid-1;
        }
        return ans;
    }
    public boolean placeCows(int[] arr, int distance, int cows){
        int count =1, last=arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i]-last >=distance){
                count++;
                last = arr[i];
            }
            if (count>=cows) return true;
        }

        return false;
    }
}