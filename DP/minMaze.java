//https://nados.io/question/min-cost-in-maze-traversal?zen=true
import java.util.*;

public class minMaze {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] maze = new int[n][m];
        int[][] dp = new int[n][m];
        for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        maze[i][j] = scn.nextInt();

        scn.close();
        
        
        System.out.println(minMazeRec(maze, 0, 0, n-1, m-1, dp));
        System.out.println(minStepTabulation(maze));
    }

    public static int minMazeRec(int[][] maze, int sr, int sc, int dr, int dc, int[][] dp)
    {
        
        if(sr>dr || sc>dc)
        return Integer.MAX_VALUE-1001;
        
        if(sr==dr && sc==dc)
        return maze[dr][dc];
        
        if(dp[sr][sc]!=0)
        return dp[sr][sc];
        
        int hCost = minMazeRec(maze, sr, sc+1, dr, dc, dp);
        int vCost = minMazeRec(maze, sr+1, sc, dr, dc, dp);
        
        int cost = Math.min(maze[sr][sc]+hCost, maze[sr][sc]+vCost);
        dp[sr][sc] = cost;
        
        return dp[sr][sc];
        
    }

    public static int minStepTabulation(int[][] maze)
    {
        int[][] dp = new int[maze.length][maze[0].length];
        
        for(int i = dp.length -1; i>=0; i--)
        {
            for(int j = dp[0].length - 1; j>=0; j--)
            {
                if(i == dp.length-1 && j== dp[0].length - 1)
                {
                    dp[i][j] = maze[i][j];
                }
                else if(j == dp[0].length - 1)
                {
                    dp[i][j] = maze[i][j] + dp[i+1][j];
                }
                else if(i == dp.length - 1)
                {
                    dp[i][j] = maze[i][j] + dp[i][j+1];
                }
                else
                {
                    dp[i][j] = maze[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }

}