public class ReverseWordsInAString {
    public String aprroach1(String s) {
        String[] words = s.split(" +");
        StringBuilder ans = new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            ans.append(words[i]);
            ans.append(" ");
        }
        return ans.toString().trim();
    }
    public String approach2(String s) {
        String ans ="";
        for (int i=0;i<s.length();i++){
            StringBuilder sb = new StringBuilder();
            while (i<s.length() && s.charAt(i) != ' '){
                sb.append(s.charAt(i));
                i++;
            }
            if (sb.length() !=0){
                ans = " "+ sb+ans;
            }
        }

        return ans.substring(1);
    }
}