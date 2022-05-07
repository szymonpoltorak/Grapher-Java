package pl.edu.pw.ee.grapher.generator;

import pl.edu.pw.ee.grapher.EntryData;
import pl.edu.pw.ee.grapher.bfs.Bfs;
import pl.edu.pw.ee.grapher.graph.Graph;

public class EdgeMode extends GraphGenerator{
    @Override
    public void generate(Graph graph, EntryData userData) {
        int numOfTries = 0;
        int maxNumOfTries = 500;
        int numOfVertices = graph.getNumOfVertices();

        for (int i = 0; i < numOfVertices; i++) {
            makeConnectionFromVertex(i, graph, userData);
        }

        while (!Bfs.checkIfCoherent(graph) && numOfTries <= maxNumOfTries){
            for (int i = 0; i < numOfVertices; i++) {
                makeConnectionFromVertex(i, graph, userData);
            }
            numOfTries++;
        }

    }
}
