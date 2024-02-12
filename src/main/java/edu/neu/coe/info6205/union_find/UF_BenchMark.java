package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UF_BenchMark {

    // Method to count the number of connections required to connect all components
    public static int countConnections(int n) {
        // Create an instance of UF_HWQUPC with n elements
        UF_HWQUPC uf = new UF_HWQUPC(n);
        // Create a random number generator
        Random random = new Random();
        // Initialize the count of connections
        int connections = 0;

        // Loop until there is only one component left
        while (uf.components() > 1) {
            // Generate two random integers between 0 and n-1
            int p = random.nextInt(n);
            int q = random.nextInt(n);
            // If the two integers represent unconnected components, union them
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                connections++;
            }
        }

        return connections; // Return the total number of connections made
    }

    public static void main(String[] args) {
        for(int n = 1000; n < 100000; n *= 2) {
            System.out.println("n = " + n + ", Number of average connects(m) : " + countConnections(n));
        }
    }
}
