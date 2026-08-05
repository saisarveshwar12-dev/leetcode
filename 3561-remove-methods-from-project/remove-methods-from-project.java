import java.util.*;

class Solution {

    boolean[] suspicious;
    boolean[] vis;

    ArrayList<Integer>[] f;
    ArrayList<Integer>[] g;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        suspicious = new boolean[n];
        vis = new boolean[n];

        f = new ArrayList[n];
        g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            f[i] = new ArrayList<>();
            g[i] = new ArrayList<>();
        }

        for (int[] e : invocations) {

            int a = e[0];
            int b = e[1];

            f[a].add(b);
            f[b].add(a);

            g[a].add(b);
        }

        dfs(k);

        for (int i = 0; i < n; i++) {

            if (!suspicious[i] && !vis[i]) {
                dfs2(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void dfs(int node) {

        suspicious[node] = true;

        for (int next : g[node]) {

            if (!suspicious[next]) {
                dfs(next);
            }
        }
    }

    private void dfs2(int node) {

        vis[node] = true;

        for (int next : f[node]) {

            if (!vis[next]) {

                suspicious[next] = false;
                dfs2(next);
            }
        }
    }
}