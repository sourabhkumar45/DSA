// https://nados.io/question/climb-stairs-with-minimum-moves?zen=true
import java.util.*;

public class climbStairWithMiniMoves {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] steps = new int[n];
        for(int i = 0; i<n; i++)
        steps[i] = scn.nextInt();
        int[] dp = new int[n+1];
        scn.close();
        Arrays.fill(dp, -1);
        //System.out.println(minStepRec(steps, 0));
        //System.out.println(minStepMem(steps, 0, dp));
        System.out.println(minStepTab(steps, dp));
    }
    public static int minStepRec(int[] steps, int src)
    {
        if(src==steps.length-1)
        return 0;
        if(src>=steps.length)
        return Integer.MAX_VALUE-1;
        
        int min = Integer.MAX_VALUE-1;
        for(int jump = 1; jump<=steps[src]; jump++)
        {
            int i = src+jump;
            min = Math.min(minStepRec(steps, i), min);
        }
        return min+1;
    }
    public static int minStepMem(int[] steps, int src, int[] dp)
    {
        if(src==steps.length-1)
        return 0;
        if(src>=steps.length)
        return Integer.MAX_VALUE-1;
        
        if(dp[src]!=-1)
        return dp[src];
        
        int min = Integer.MAX_VALUE-1;
        for(int jump = 1; jump<=steps[src]; jump++)
        {
            int i = src+jump;
            min = Math.min(minStepRec(steps, i), min);
        }
        dp[src] = min+1;
        return min+1;
    }
    public static int minStepTab(int[] steps, int[] dp)
    {
        dp[steps.length - 1] = 0;
        for(int i = steps.length - 2; i>=0; i--)
        {
            if(steps[i]==0)
            dp[i] = Integer.MAX_VALUE - 1;
            else
            {
                int min = Integer.MAX_VALUE - 1;
                for(int j = 1; j<=steps[i]; j++)
                {
                    if(j+i<steps.length)
                    min = Math.min(dp[i+j], min);
                }
                dp[i] = min + 1;
            }
        }
        return dp[0];
    }

}