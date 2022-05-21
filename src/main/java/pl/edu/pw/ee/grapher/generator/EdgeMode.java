package pl.edu.pw.ee.grapher.generator;

import org.jetbrains.annotations.NotNull;
import pl.edu.pw.ee.grapher.utils.EntryData;
import pl.edu.pw.ee.grapher.bfs.Bfs;
import pl.edu.pw.ee.grapher.graph.Graph;

public class EdgeMode extends GraphGenerator{
    @Override
    public void generate(@NotNull Graph graph, EntryData userData) {
        var continueGeneration = true;
        var numOfTries = 0;
        var maxNumOfTries = 500;
        var numOfVertices = graph.getNumOfVertices();

        for (int i = 0; i < numOfVertices; i++) {
            makeConnectionFromVertex(i, graph, userData);
        }

        while (!Bfs.checkIfCoherent(graph) && continueGeneration){
            for (int i = 0; i < numOfVertices; i++) {
                makeConnectionFromVertex(i, graph, userData);
            }
            numOfTries++;
            if(numOfTries >= maxNumOfTries){
                /*
                TODO
                Ask user if they want to continue generation
                 */
                continueGeneration = true; //or false
            }
        }

    }
}
