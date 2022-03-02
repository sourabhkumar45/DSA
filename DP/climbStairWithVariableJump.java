// https://nados.io/question/climb-stairs-with-variable-jumps?zen=true
import java.util.*;

public class climbStairWithVariableJump {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] steps = new int[n];
        for(int i = 0; i<n; i++)
        {
            steps[i] = scn.nextInt();
        }
        scn.close();
        int[] dp = new int[n+1];
        //System.out.println(climbStairsRec(0, steps));
        //System.out.println(climbStairsMem(0, steps, dp));
        System.out.println(climbStairsTab(n, steps, dp));
    }
   public static int climbStairsTab(int dest , int[] steps, int[] dp)
   {
       dp[steps.length] = 1;
       for(int i = steps.length - 1; i>=0; i--)
       {
           for(int j = 1; j<=steps[i]; j++)
           {
               if(i+j<=dest)
               {
                   dp[i]+=dp[i+j];
               }
           }
       }
       return dp[0];
   }
   public static int climbStairsRec(int source, int[] steps)
   {
       if(source==steps.length)
       return 1;
       else if(source>steps.length)
       return 0;
      
       int ans = 0;
       
       
           for(int j = 1; j<=steps[source]; j++)
           {
               int t = climbStairsRec(source + j, steps);
               ans+=t;
           }
       return ans;
   }
    public static int climbStairsMem(int source, int[] steps, int[] dp)
   {
       if(source==steps.length)
       return 1;
       else if(source>steps.length)
       return 0;
       
      if(dp[source]!=0)
      return dp[source];
      
       int ans = 0;
       
       for(int j = 1; j<=steps[source]; j++)
           {
               int t = climbStairsMem(source + j, steps, dp);
               ans+=t;
           }
       dp[source] = ans;
       return dp[source];
       
   }   
       
}    
      