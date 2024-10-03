package coding.프로그래머스.고득점kit.깊이너비우선탐색;

import java.util.*;
public class 네트워크 {
    class UnionFind{
        int[] parent;
        int[] size;
        int count;

        public UnionFind(int numNodes){
            parent = new int[numNodes];
            size = new int[numNodes];
            for(int i = 0; i < numNodes; i++){
                parent[i] = i;
                size[i] = 1;
                count++;
            }
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
//we can optimize to keep the larget set on the root
            if(rootX != rootY){
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
                count--;
            }
        }

        public int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
    }
    public int solution(int n, int[][] computers) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                if(computers[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
}
