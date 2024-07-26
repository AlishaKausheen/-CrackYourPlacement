public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int start=0,end=0;
        int characterCount = t.length();
        Map<Character, Integer> map = new HashMap<>();
        String ans ="";
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        while(end<s.length()){
            if(map.containsKey(s.charAt(end))){
                if(map.get(s.charAt(end))>0){
                    characterCount-=1;
                }
                map.put(s.charAt(end),map.get(s.charAt(end))-1);
            }
            if(characterCount ==0){
                while(start<=end){
                    if(map.containsKey(s.charAt(start))){
                        boolean isValid = map.get(s.charAt(start))+1 <=0 ? true : false;
                        if(isValid){
                            map.put(s.charAt(start), map.get(s.charAt(start))+1);
                            start++;
                        }else{
                            break;
                        }

                    }else{
                        start++;
                    }
                }
                String temp = s.substring(start,end+1);
                if(ans.isEmpty() || ans.length()> temp.length()){
                    ans = temp;
                }
            }
            end++;
        }
        return ans;
    }
}