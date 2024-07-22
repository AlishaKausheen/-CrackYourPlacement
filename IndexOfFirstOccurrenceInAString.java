public class IndexOfFirstOccurrenceInAString {
    public int brute(String haystack, String needle) {

        for(int i=0;i<=haystack.length()-needle.length();i++){
            for(int j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)!= needle.charAt(j) ) break;
                if(j==needle.length()-1) return i;
            }
        }
        return -1;
    }
    public int optimal(String haystack, String needle) {
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(haystack.substring(i,needle.length()+i).equals(needle)) return i;

            }
        }
        return -1;
    }
}
