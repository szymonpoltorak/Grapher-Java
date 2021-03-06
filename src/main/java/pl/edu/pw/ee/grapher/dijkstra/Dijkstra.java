package pl.edu.pw.ee.grapher.dijkstra;

import org.jetbrains.annotations.NotNull;
import pl.edu.pw.ee.grapher.utils.EntryData;
import pl.edu.pw.ee.grapher.graph.Graph;

import java.util.Arrays;

public class Dijkstra implements PathFinder {
    private final Heap heap;
    private final float[] distance;
    private final int numOfVertices;

    public Dijkstra(int numOfVertices) {
        this.distance = new float[numOfVertices];
        this.heap = new Heap(numOfVertices);
        this.numOfVertices = numOfVertices;
    }

    public @NotNull PathData findPath(@NotNull Graph graph, @NotNull EntryData userData){
        var pathData = new PathData(numOfVertices);
        pathData.setStart(userData.getStartPoint());
        pathData.setEnd(userData.getEndPoint());

        var currentPoint = pathData.getStart();
        Arrays.fill(distance, Float.MAX_VALUE);

        for (int i = 0; i < numOfVertices; i++){
            heap.addToHeap(Float.MAX_VALUE);
        }
        heap.updatePriority(currentPoint, 0);
        distance[currentPoint] = 0;

        while (heap.getLength() != 0){
            currentPoint = heap.popFromHeap();

            for (int i = 0; i < 4; i++){
                var vertex = graph.getVertex(currentPoint);

                if (graph.getVertex(currentPoint).getExistence(i)){
                    var newDistance = distance[currentPoint] + vertex.getWeight(i);
                    var j = vertex.getConnection(i);

                    if (distance[j] > newDistance){
                        heap.updatePriority(j, newDistance);
                        pathData.setPredecessor(j, currentPoint);
                        pathData.setWeight(j, vertex.getWeight(i));
                        distance[j] = newDistance;
                    }
                }
            }
        }
        return pathData;
    }
}
