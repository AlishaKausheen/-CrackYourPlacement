public class MoveZeroes {
    public void brute(int[] nums) {
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) count++;
        }
        int[] temp= new int[count];
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                temp[j]=nums[i];
                j++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i<temp.length){
                nums[i]=temp[i];
            }else{
                nums[i]=0;
            }
        }
    }
    public void optimal(int[] nums) {
        int j=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }
        for(int i=j+1;i<nums.length;i++){
            if(nums[i]!=0){
                if(j!=-1){
                    int temp =nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    j++;
                }
            }
        }
    }
}
