public class SmallestPositiveMissing {
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        for(int i=0;i<size;i++){
            int currentIndex = arr[i]-1;
            while((currentIndex>=0 && currentIndex<size) && arr[i] != arr[currentIndex]){
                int temp =arr[i];
                arr[i]= arr[currentIndex];
                arr[currentIndex] =temp;
                currentIndex = arr[i]-1;
            }
        }
        for(int i=0;i<size;i++){
            if(arr[i]!=i+1) return i+1;
        }
        return size;
    }
}