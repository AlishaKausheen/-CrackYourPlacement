public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int n= board.length, m= board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((board[i][j] == word.charAt(0)) && find(board,i,j,0,word))
                    return true;
            }
        }
        return false;
    }
    public boolean find(char[][] board, int i,int j, int index, String word){

        if(index==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='$') return false;
        if(board[i][j] != word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j]='$';
        boolean found = find(board,i+1,j, index+1, word) || find(board,i-1,j, index+1, word)
                || find(board,i,j+1,index+1,word) || find(board,i,j-1, index+1,word);
        board[i][j]= temp;
        return found;
    }
}
