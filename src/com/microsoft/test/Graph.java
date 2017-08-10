package com.microsoft.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//representation
class Main {
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency List Represntation
	int count = 0;

	// Constructor
	Main(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	int isCyclicUtil(int source, int distance) {
		Integer i;

		Iterator<Integer> it = adj[source].iterator();
		while (it.hasNext()) {
			i = it.next();

			if (distance == 0) {
				count++;
			} else
				isCyclicUtil(i, distance - 1);
		}
		return count;
	}

	int count(int dist) {
		return isCyclicUtil(1, dist - 1);

	}

	public static void main(String args[]) throws IOException {
		String line;
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		line = inp.readLine();
		// Use the following code to print output
		String[] list = line.split(" ");
		int edges = Integer.parseInt(list[0]);
		int distance = Integer.parseInt(list[1]);
		Main g1 = new Main(edges);
		for (int i = 0; i < edges-1; i++) {
			line = inp.readLine();
			String[] vertices = line.split(" ");
			g1.addEdge(Integer.parseInt(vertices[0]), Integer.parseInt(vertices[1]));
		}
		System.out.println(g1.count(distance));

	}
}