import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class ThreeSum {
    public ArrayList<ArrayList<Integer>> brute(int[] nums) {
        HashSet<ArrayList<Integer>> set = new HashSet();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for( int k=j+1;k<nums.length;k++){
                    ArrayList<Integer> temp = new ArrayList<>();
                    if(nums[i]+nums[j]+nums[k]==0){
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
    public ArrayList<ArrayList<Integer>> better(int[] nums) {
        HashSet<ArrayList<Integer>> set = new HashSet();
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> newSet = new HashSet();
            for(int j=i+1;j<nums.length;j++){
                int third = -(nums[i]+nums[j]);
                if(newSet.contains(third)){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);
                    Collections.sort(temp);
                    set.add(temp);
                }
                newSet.add(nums[j]);
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
    public ArrayList<ArrayList<Integer>> optimal(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k= nums.length-1;
            while(j<k){
                int sum= nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }else if (sum>0){
                    k--;
                }else{
                    ArrayList<Integer> temp= new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k+1]==nums[k]) k--;
                }
            }
        }
        return ans;
    }
}
