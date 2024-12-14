public class EX11{
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

    }

    public static int maxArea(int[] height) {
        int maxAreaSoFar = 0;
        int left = 0, right = height.length - 1;

        while(right > left){
            maxAreaSoFar = Math.max(Math.min(height[right], height[left]) * (right-left), maxAreaSoFar);
            if(height[left] > height[right]){
                right--;
            }
            else{
                left++;
            }
        }

        return maxAreaSoFar;
    }
}