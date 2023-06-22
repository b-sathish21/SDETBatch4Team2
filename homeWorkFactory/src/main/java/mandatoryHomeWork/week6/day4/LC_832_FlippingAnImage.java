class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        //Complexity: Time - O(n * m) & Space - O(1)
        for(int i=0; i<image.length; i++){
            for(int j=0, k=image.length-1; j<=k; j++, k--){          
                if(j!=k){
                    //flip
                    int t = image[i][j];
                    image[i][j] = image[i][k];
                    image[i][k] = t;
                    
                    //invert
                    if(image[i][k] == 0) image[i][k] = 1;
                    else image[i][k] = 0;
                }
                //invert
                    if(image[i][j] == 0) image[i][j] = 1;
                    else image[i][j] = 0; 
            }
        }
        return image;
    }
}