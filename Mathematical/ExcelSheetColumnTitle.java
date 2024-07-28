public class ExcelSheetColumnTitle {
    public String convertToTitle(int col) {
        StringBuilder ans= new StringBuilder();
        while(col>0){
            int r = (col-1)%26;
            ans.append((char)(r+'A'));
            col = (col-1)/26;
        }
        return   ans.reverse().toString();
    }
}