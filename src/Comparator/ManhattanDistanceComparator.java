package Comparator;

import CustomDataSturctures.State;

import java.util.Comparator;

public class ManhattanDistanceComparator implements Comparator<State> {

    @Override
    public int compare(State state1, State state2) {
        return cost(state1) - cost(state2);
    }

    private int cost(State state) {
        int[][] values = state.getValues();
        int cost = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                int cellValue = values[i][j];
                int targetXIndex = cellValue / 3;
                int targetYIndex = cellValue % 3;
                cost += Math.abs(i - targetXIndex) + Math.abs(j - targetYIndex);
            }
        }
        return cost;
    }
}
