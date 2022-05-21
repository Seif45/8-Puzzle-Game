import Comparator.EuclideanDistanceComparator;
import Comparator.ManhattanDistanceComparator;
import CustomDataSturctures.*;
import CustomDataSturctures.AbstractQueue;

import java.util.*;

public class SearchingAlgorithms {


    /**
     *
     * @param start initial state.
     * @param abstractQueue the custom dataStructure used in searching algorithm.
     *
     *  implementation of searching algorithm from initial state to the target state.
     */
    public void customSearch(State start, AbstractQueue abstractQueue) {
        long startTime = System.nanoTime();
        abstractQueue.push(start);
        Set explored = new HashSet();
        int costOfPath;
        ArrayList<String> path;
        int numOfExpandedNodes = 0;
        while (!abstractQueue.isEmpty()) {
            State current = abstractQueue.pop();
            System.out.println(current.toString());
            explored.add(current.toString());
            if (current.equalsTarget()) {
                path = getPath(current);
                System.out.println("Path: "+path);
                costOfPath = current.getCost();
                System.out.println("costOfPath: " + costOfPath);
                System.out.println("num of nodes expanded: "+numOfExpandedNodes);
                System.out.println("search depth: "+path.size());
                break;
            }
            numOfExpandedNodes++;
            ArrayList<State> neighbours = current.getNeighbours();
            for (State neighbour : neighbours) {
                if (!explored.contains(neighbour.toString()) && !abstractQueue.contains(neighbour.toString())) {
                    abstractQueue.push(neighbour);
                }
            }
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("run time: "+totalTime/1000000.0+" milliseconds.");
    }

    private ArrayList<String> getPath(State current) {
        ArrayList<String> path = new ArrayList<>();
        while(current.getParent() != null){
            path.add(current.getDirection());
            current = current.getParent();
        }
        Collections.reverse(path);
        return path;
    }


    public void DFS(State start) {
        CustomStack stack = new CustomStack();
        customSearch(start, stack);
    }

    public void BFS(State start) {
        CustomQueue queue = new CustomQueue();
        customSearch(start, queue);
    }

    public void AStarWithManhattanDistanceCost(State start) {
        CustomPriorityQueue priorityQueue = new CustomPriorityQueue(new ManhattanDistanceComparator());
        customSearch(start, priorityQueue);
    }

    public void AStarWithEuclideanDistanceCost(State start) {
        CustomPriorityQueue priorityQueue = new CustomPriorityQueue(new EuclideanDistanceComparator());
        customSearch(start, priorityQueue);
    }

}
