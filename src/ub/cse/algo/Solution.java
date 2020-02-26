package ub.cse.algo;

import java.util.*;

public class Solution {
	  private int startNode;
	  private HashMap<Integer, ArrayList<Integer>> graph;
	  public Solution(int node, HashMap<Integer, ArrayList<Integer>> g){
	    startNode = node;
	    graph = g;
	  }

	  public int[] outputDistances(){

	  	int[] distanceList = new int[this.graph.size()];
	  	Queue<Integer> toExplore = new LinkedList<>();
	  	Set<Integer> explored = new HashSet<>();

	  	toExplore.add(this.startNode);
	  	explored.add(this.startNode);
	  	distanceList[this.startNode] = 0;

	  	while (!toExplore.isEmpty()) {

	  		int node = toExplore.remove();

		  	for (int adjacentNode : this.graph.get(node)) {

		  		if (!explored.contains(adjacentNode)) {
		  			int distance = distanceList[node] + 1;
					toExplore.add(adjacentNode);
					distanceList[adjacentNode] = distance;
					explored.add(adjacentNode);
				}
			}
	  	}

	  	for (int node : this.graph.keySet()) {
	  		if (!explored.contains(node)) {
	  			distanceList[node] = -1;
			  }
	  	}

	    return distanceList;
	  }
}
