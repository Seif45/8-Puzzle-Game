package CustomDataSturctures;

import java.util.ArrayList;
import java.util.Arrays;

public class State {

    private int[][] target;
    private int[][] values;
    private int cost;
    private String direction;
    private State parent;

    public State(int[][] values, int cost, String direction, State parent) {
        this.values = values;
        this.cost = cost;
        this.direction = direction;
        this.parent = parent;
        target = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    }

    /**
     *
     * @return list of next states.
     */
    public ArrayList<State> getNeighbours() {
        ArrayList<State> neighbours = new ArrayList<>();
        int zeroXIndex;
        int zeroYIndex = 0;
        boolean found = false;
        for (zeroXIndex = 0; zeroXIndex < values.length; zeroXIndex++) {
            for (zeroYIndex = 0; zeroYIndex < values[0].length; zeroYIndex++) {
                if (values[zeroXIndex][zeroYIndex] == 0) {
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        if (zeroXIndex > 0) { // Up
            neighbours.add(new State(getNeighbour(zeroXIndex, zeroYIndex, zeroXIndex - 1, zeroYIndex),cost+1,"Up",this));
        }
        if (zeroXIndex < 2) { // Down
            neighbours.add(new State(getNeighbour(zeroXIndex, zeroYIndex, zeroXIndex + 1, zeroYIndex),cost+1,"Down",this));
        }
        if (zeroYIndex > 0) { // Left
            neighbours.add(new State(getNeighbour(zeroXIndex, zeroYIndex, zeroXIndex, zeroYIndex - 1),cost+1,"Left",this));
        }
        if (zeroYIndex < 2) { // Right
            neighbours.add(new State(getNeighbour(zeroXIndex, zeroYIndex, zeroXIndex, zeroYIndex + 1),cost+1,"Right",this));
        }
        return neighbours;
    }

    /**
     *
     * @return the next state
     */
    private int[][] getNeighbour(int fromX, int fromY, int toX, int toY) {
        int[][] valuesCloned = new int[3][3];
        for(int i = 0; i < values.length;i++){
            for(int j = 0; j < values[0].length; j++){
                valuesCloned[i][j] = values[i][j];
            }
        }
        int temp = valuesCloned[fromX][fromY];
        valuesCloned[fromX][fromY] =  values[toX][toY];
        valuesCloned[toX][toY] = temp;
        return valuesCloned;
    }


    public boolean equalsTarget() {
        return Arrays.deepEquals(values, getTarget());
    }

    public int[][] getTarget() {
        return target;
    }

    public int[][] getValues() {
        return values;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < values.length; i++){
            for(int j = 0; j < values[0].length; j++){
                s += values[i][j] + " ";
            }
            s += "\n";
        }
        return s;

    }

    public int getCost() {
        return cost;
    }

    public String getDirection() {
        return direction;
    }

    public State getParent() {
        return parent;
    }
}
