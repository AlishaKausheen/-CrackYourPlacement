public class MinimumSwapsToSort {
    public void swap(int[] nums, int i , int j){
        int temp =nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public int minSwaps(int nums[])
    {
        // Code here
        Map<Integer,Integer> map = new HashMap<>();
        int[] numsSorted = nums.clone();
        Arrays.sort(numsSorted);
        for(int i=0;i<numsSorted.length;i++){
            map.put(numsSorted[i],i);
        }
        int swap=0;
        int i=0;
        while(i<nums.length){
            if(map.get(nums[i])==i){
                i++;
            }else{
                swap(nums,i,map.get(nums[i]));
                swap++;
            }
        }
        return swap;
    }
}