package pl.edu.pw.ee.grapher.graphio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.edu.pw.ee.grapher.testData.GraphCoherent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class GraphSaverTest {
    @Test
    void saveToFile_test_pass() throws IOException {
        //given
        var graph = new GraphCoherent();
        var resultGraph = new File("src/test/resources/resultGraph.txt");
        var expectedGraph = new File("src/test/resources/expectedGraph.txt");

        //when
        GraphSaver.saveToFile(graph.getGraph(), resultGraph);
        var expected = Files.readAllBytes(resultGraph.toPath());
        var result = Files.readAllBytes(expectedGraph.toPath());

        //then
        Assertions.assertArrayEquals(expected, result);
    }
}
