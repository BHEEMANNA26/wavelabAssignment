package com.mk;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {{0, 1}, {0, 2}, {1, 2}};
        int minConnections = makeConnected(n, connections);
        System.out.println(minConnections); 
    }

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            
            return -1;
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int extraConnections = 0;
        for (int[] connection : connections) {
            int parent1 = find(parent, connection[0]);
            int parent2 = find(parent, connection[1]);
            if (parent1 != parent2) {
                parent[parent1] = parent2;
            } else {
                extraConnections++;
            }
        }

        int numSets = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                numSets++;
            }
        }

        if (extraConnections >= numSets - 1) {
            return numSets - 1;
        } else {
            return -1;
        }
    }

    private static int find(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = find(parent, parent[node]);
        return parent[node];
    }
}


