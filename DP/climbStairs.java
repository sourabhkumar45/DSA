//https://nados.io/question/climb-stairs?zen=true
import java.util.*;

public class climbStairs {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        System.out.println(climbRec(n));
        
        //System.out.println(fiboMemo(n,new int [n+1]));
    }
    public static int climbRec(int n) {
        if(n<0)
        return 0;
        if(n==0)
        return 1;
        
        int ans = climbRec(n-1) + climbRec(n-2) + climbRec(n-3);
        
        return ans;
    }
    
    public static int climbMemo(int n) {
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        for(int i = 1; i<n+1; i++)
        {
            for(int j = 1; j<=3; j++)
            {
                if(i-j>=0)
                dp[i]+=dp[i-j];
            }
        }
        return dp[n];
    }
}