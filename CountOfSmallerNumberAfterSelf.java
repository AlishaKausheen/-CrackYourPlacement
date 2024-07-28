public class CountOfSmallerNumberAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> smallerToRight = new LinkedList<>();
        List<Integer> sortedList = new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            int index = insert(sortedList,nums[i]);
            smallerToRight.add(0,index);
        }
        return smallerToRight;
    }
    private int insert(List<Integer> sortedList, int num){
        int low =0;
        int high = sortedList.size()-1;
        if(sortedList.isEmpty() || num< sortedList.get(0)){
            sortedList.add(0,num);
            return 0;
        }
        if(num>sortedList.get(high)){
            sortedList.add(num);
            return high+1;
        }
        while(high-low>1){
            int mid = (low+high)/2;
            if(num<=sortedList.get(mid)){
                high =mid;
            }else{
                low =mid;
            }
        }
        if(num<=sortedList.get(low)){
            sortedList.add(low,num);
            return low;
        }else if(num> sortedList.get(high)){
            sortedList.add(high+1,num);
            return high+1;
        }else{
            sortedList.add(high,num);
            return high;
        }
    }
}