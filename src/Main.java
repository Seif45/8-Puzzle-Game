import CustomDataSturctures.State;

import java.util.*;

public class Main {



    public static void main(String[] args){
        SearchingAlgorithms searchingAlgorithms = new SearchingAlgorithms();
        //int[][] values = {{3,1,2},{4,8,0},{6,5,7}};
        int[][] values = {{1,2,3},{4,5,6},{7,8,0}};


        State start = new State(values,0,"",null);

        System.out.println("BFS:\n");
        searchingAlgorithms.BFS(start);
        System.out.println("\n\n");

        System.out.println("DFS:\n");
        searchingAlgorithms.DFS(start);
        System.out.println("\n\n");

        System.out.println("A* with Manhattan distance cost:\n");
        searchingAlgorithms.AStarWithManhattanDistanceCost(start);
        System.out.println("\n\n");

        System.out.println("A* with Euclidean distance cost:\n");
        searchingAlgorithms.AStarWithEuclideanDistanceCost(start);
        System.out.println("\n\n");
    }

}
