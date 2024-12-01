import java.util.Scanner;
import java.util.HashMap;

public class ED198{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        XSUM biggestSum = new XSUM(scn);
        System.out.println(biggestSum.s1());
    }
}

class XSUM{
    private Scanner s;
    private int[] arr;
    private int ans;
    XSUM(Scanner scn){
        s = scn;
        readData();
    }

    private void readData(){
        int n = s.nextInt();
        arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = s.nextInt();
        }

    }

    public int s1(){
        ans = -10^4 - 1;
        int cur_sum = 0;

        for(int i: arr){
            cur_sum += i;
            ans = Math.max(cur_sum, ans);

            if(cur_sum < 0) cur_sum = 0;
        }

        return ans;
    }

//    Input:
//    -1  4 -2  5 -5  2 -20  6
//    Output:
//    7 (4 + (-2) + 5)



}