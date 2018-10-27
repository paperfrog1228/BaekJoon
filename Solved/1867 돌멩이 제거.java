import java.util.*;
import java.lang.*;

class Main {
    static Scanner scan = new Scanner(System.in);

    static int[][] adj;
    static boolean[] visit;
    static int[] aMatch;
    static int[] bMatch;
    static int n;

    static boolean dfs(int a) {
        if (visit[a])
            return false;
        visit[a] = true;

        for (int b = 1; b <= n; b++) {
            if (adj[a][b] == 1) {
                if (bMatch[b] == -1 || dfs(bMatch[b])) {
                    aMatch[a] = b;
                    bMatch[b] = a;
                    return true;
                }
            }
        }
        return false;

    }

    static int bipartitMatch() {

        for (int i = 0; i <= n; i++) {
            aMatch[i] = -1;
            bMatch[i] = -1;
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) visit[j] = false;
            if (dfs(i)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        n = scan.nextInt();
        aMatch = new int[n + 5];
        bMatch = new int[n + 5];
        int k = scan.nextInt();
        adj = new int[n + 5][n + 5];
        visit = new boolean[n + 5];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                adj[i][j] = -1;

        for (int i = 0; i < k; i++)
            adj[scan.nextInt()][scan.nextInt()] = 1;

        System.out.println(bipartitMatch());

    }
}
