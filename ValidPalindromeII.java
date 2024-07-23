public class ValidPalindromeII {
    public boolean brute(String s) {
        int left =0;
        int right = s.length()-1;
        int count=0;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else if(s.charAt(left)!=s.charAt(right) && count==0){
                if(s.charAt(left+1)==s.charAt(right)){
                    left=left+1;
                    count++;
                }else{
                    right--;
                    count++;
                }
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean optimal(String s) {
        int left=0, right = s.length()-1;
        while(left<right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1);
            }
        }
        return true;
    }
    public boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}