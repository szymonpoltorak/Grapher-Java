package pl.edu.pw.ee.grapher.graphio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.edu.pw.ee.grapher.testData.GraphCoherent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GraphSaverTest {
    @Test
    public void saveToFile_test_pass() throws IOException {
        //given
        GraphCoherent graph = new GraphCoherent();
        File resultGraph = new File("testFiles/resultGraph.txt");
        File expectedGraph = new File("testFiles/expectedGraph.txt");

        //when
        GraphSaver.saveToFile(graph.getGraph(), resultGraph);
        byte[] expected = Files.readAllBytes(resultGraph.toPath());
        byte[] result = Files.readAllBytes(expectedGraph.toPath());

        //then
        Assertions.assertArrayEquals(expected, result);
    }
}
