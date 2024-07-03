import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine()) - 1;
        List<int[]>[] g = new List[V];
        for (int i = 0; i < V; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            g[from].add(new int[]{to, weight});
        }

        int[] d = new int[V];

        for (int i = 0; i < V; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        boolean[] v = new boolean[V];

        d[start] = 0;
        pq.offer(new int[]{start, d[start]});

        while (!pq.isEmpty()) {
            int[] vw = pq.poll();
            int minVertex = vw[0];
            int min = vw[1];

            if (v[minVertex])
                continue;
            v[minVertex] = true;

            // System.out.println("minVertex : " + minVertex + ", min : " + min);

            for (int[] j : g[minVertex]) {
                if (!v[j[0]] && d[j[0]] > min + j[1]) {
                    d[j[0]] = min + j[1];
                    pq.offer(new int[]{j[0], d[j[0]]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < V; i++) {
            if (d[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(d[i]).append("\n");
            }
        }
        System.out.print(sb.toString());

    }
}