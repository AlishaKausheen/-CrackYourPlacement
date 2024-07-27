public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> ans = new ArrayList<>();
        int n = words.length;
        int i=0;
        while(i<n){
            int lettersCount = words[i].length();
            int j=i+1;
            int space=0;
            while(j<n  && words[j].length()+1+ space + lettersCount <=maxWidth){
                lettersCount +=words[j].length();
                space+=1;
                j++;
            }
            int remainingSlots = maxWidth-lettersCount;
            int eachDistributedSpace = space==0  ? 0 : remainingSlots/space;
            int extraSpace = space==0  ? 0 : remainingSlots%space;

            if(j==n){
                //left justification
                eachDistributedSpace =1;
                extraSpace =0;
            }
            ans.add(findLine(i,j,eachDistributedSpace,extraSpace, words, maxWidth));
            i=j;
        }
        return ans;
    }
    private String findLine(int i,int j, int eachDistributedSpace, int extraSpace, String[] words,int maxWidth){
        String line = "";
        for(int k=i;k<j;k++){
            line+=words[k];
            if(k==j-1) continue;
            for(int z=1;z<=eachDistributedSpace;z++){
                line+=" ";
            }
            if(extraSpace >0){
                line+=" ";
                extraSpace--;
            }
        }
        while(line.length() <  maxWidth){
            line+=" ";
        }
        return line;
    }

}