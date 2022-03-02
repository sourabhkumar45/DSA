//https://nados.io/question/fibonacci-dp?zen=true
import java.util.*;

public class fibonacci {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        System.out.println(fiboRec(n));
        
        System.out.println(fiboMemo(n,new int [n+1]));
    }
    public static int fiboRec(int n) {
        if(n==0 || n==1) {
            return n;
        }
        int fibo1 = fiboRec(n-1);
        int fibo2 = fiboRec(n-2); 
        int ans = fibo1+fibo2;
        return ans;
    }
    public static int fiboMemo(int n, int[] dp) {
        if(n==0 || n==1) {
            return n;
        }

        if(dp[n]!=0) {
            return dp[n];
        }

        int fibo1 = fiboMemo(n-1, dp);
        int fibo2 = fiboMemo(n-2, dp); 
        int ans = fibo1+fibo2;
        dp[n] = ans;
        return ans;
    }

}