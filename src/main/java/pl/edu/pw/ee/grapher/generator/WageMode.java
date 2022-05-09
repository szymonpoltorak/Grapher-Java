package pl.edu.pw.ee.grapher.generator;

import pl.edu.pw.ee.grapher.EntryData;
import pl.edu.pw.ee.grapher.graph.Graph;

import static pl.edu.pw.ee.grapher.Constants.*;
import static pl.edu.pw.ee.grapher.Constants.LEFT;

public class WageMode extends GraphGenerator {

    @Override
    void makeConnectionFromVertex(int index, Graph graph, EntryData userData) {
        int columns = graph.getColumns();
        int rows = graph.getRows();
        if (index - columns >= 0 && index - columns < columns * rows) {
            graph.getVertex(index).setExistence(UP, true);
            graph.getVertex(index).setWeight(UP, generateWeight(userData.getRangeStart(), userData.getRangeEnd()));
            graph.getVertex(index).setConnections(UP, index - columns);
        }
        if (index + 1 < columns * rows && (index + 1) % columns != 0) {
            graph.getVertex(index).setExistence(RIGHT, true);
            graph.getVertex(index).setWeight(RIGHT, generateWeight(userData.getRangeStart(), userData.getRangeEnd()));
            graph.getVertex(index).setConnections(RIGHT, index + 1);
        }
        if (index + columns > 0 && index + columns < columns * rows) {
            graph.getVertex(index).setExistence(DOWN, true);
            graph.getVertex(index).setWeight(DOWN, generateWeight(userData.getRangeStart(), userData.getRangeEnd()));
            graph.getVertex(index).setConnections(DOWN, index + columns);
        }
        if (index - 1 >= 0 && index % columns != 0) {
            graph.getVertex(index).setExistence(LEFT, true);
            graph.getVertex(index).setWeight(LEFT, generateWeight(userData.getRangeStart(), userData.getRangeEnd()));
            graph.getVertex(index).setConnections(LEFT, index - 1);
        }
    }
}
