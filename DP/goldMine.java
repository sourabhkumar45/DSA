// https://nados.io/question/goldmine?zen=true
import java.util.*;

public class goldMine {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] goldMine = new int[n][m];

        for(int i = 0; i<n; i++) 
        for(int j = 0; j<m; j++)
        goldMine[i][j] = scn.nextInt();
        System.out.println(maxGold(goldMine)); 
        scn.close();
    }
    public static int maxGold(int[][] goldMine) {
        int N = goldMine.length;
        int M = goldMine[0].length;
        int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
        int [][] dp = new int[N][M];

        for(int sc = M -1; sc>=0; sc--) {
            for(int sr = N-1; sr>=0; sr--) {
                if(sc==M-1) {
                    dp[sr][sc] = goldMine[sr][sc];
                    continue;
                }
                int maxGold = 0;
                for(int[] d: dir) {
                    int r = sr+d[0];
                    int c = sc+d[1];
                    if(r>=0 && c>=0 && c<M && r<N) {
                        maxGold = Math.max(maxGold, goldMine[sr][sc]+dp[r][c]);
                    }
                }
                dp[sr][sc] = maxGold;  
            }
        }

        int maxGold = 0;
        for(int r = 0; r<N; r++) {
            maxGold = Math.max(maxGold, dp[r][0]);
        }
        return maxGold;
    }
}