public class SetMatrixZero {
    public void brute(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    markRow(i, matrix);
                    markColumn(j, matrix);
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
    }
    public void markRow(int i, int[][] matrix){
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j]!=0) matrix[i][j]=-1;
        }
    }
    public void markColumn(int j, int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][j]!=0) matrix[i][j]=-1;
        }
    }
    public void better(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public void optimal(int[][] matrix) {
        int col0=1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j!=0) matrix[0][j]=0;
                    else col0=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]!=0){
                    if(matrix[0][j]==0|| matrix[i][0]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }
        if(matrix[0][0]==0){
            for(int j=0;j<matrix[0].length;j++) matrix[0][j]=0;
        }
        if(col0==0){
            for(int i=0;i<matrix.length;i++) matrix[i][0]=0;
        }
    }
}
