import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class InsertDeleteGetRandomDuplicateAllowed {

    class RandomizedCollection {
        HashMap<Integer, HashSet<Integer>> map;
        ArrayList<Integer> list;
        Random r;
        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
            r = new Random();
        }

        public boolean insert(int val) {
            boolean flag;
            HashSet<Integer> set;
            if(map.containsKey(val)==true){
                set=map.get(val);
                flag = false;
            }else{
                set = new HashSet<>();
                flag = true;
            }
            set.add(list.size());
            list.add(val);
            map.put(val,set);
            return flag;
        }

        public boolean remove(int val) {
            HashSet<Integer> set;
            boolean flag;
            if(map.containsKey(val)==true){
                set= map.get(val);
            }else{
                return false;
            }
            int randomIndex=-1;
            for(int i:set){
                randomIndex=i;
                break;
            }
            set.remove(randomIndex);
            map.put(val,set);
            if(map.get(val).size()==0){
                map.remove(val);
            }
            if(randomIndex== list.size()-1){
                list.remove(list.size()-1);
            }else{
                list.set(randomIndex, list.get(list.size()-1));
                list.remove(list.size()-1);
                int newVal = list.get(randomIndex);
                HashSet<Integer> temp = map.get(newVal);
                temp.remove(list.size());
                temp.add(randomIndex);
                map.put(newVal,temp);
            }
            return true;
        }

        public int getRandom() {
            int randomIndex = r.nextInt(list.size());
            return list.get(randomIndex);
        }
    }
}
