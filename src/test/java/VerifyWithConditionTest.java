import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class VerifyWithConditionTest extends TestCase {
    public void testWithEmptyMetadata() throws IOException {
        Reader reader = new Reader();
        List<String> data = reader.read(new File("data.txt"));
        List<String> output = reader.read(new File("output.txt"));
        List<String> metadata = reader.readMetaData(new File("metadata.txt"));
        Verificator verificator=new Verificator();
        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
        assertTrue(isTestPassed);
    }
    public void testWithCorrectMetadata() throws IOException {
        Reader reader = new Reader();
        List<String> data = reader.read(new File("data.txt"));
        List<String> output = reader.read(new File("output.txt"));
        List<String> metadata = reader.readMetaData(new File("metadata1.txt"));
        Verificator verificator=new Verificator();
        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
        assertTrue(isTestPassed);
    }
    public void testWithNotCorrectMetadata() throws IOException {
        Reader reader = new Reader();
        List<String> data = reader.read(new File("data.txt"));
        List<String> output = reader.read(new File("output.txt"));
        List<String> metadata = reader.readMetaData(new File("metadata2.txt"));
        Verificator verificator=new Verificator();
        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
        assertFalse(isTestPassed);
    }
    public void testWithNotCompleteOutput() throws IOException {
        Reader reader = new Reader();
        List<String> data = reader.read(new File("data.txt"));
        List<String> output = reader.read(new File("output1.txt"));
        List<String> metadata = reader.readMetaData(new File("metadata2.txt"));
        Verificator verificator=new Verificator();
        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
        assertFalse(isTestPassed);
    }
    public void testWithNotCompleteData() throws IOException {
        Reader reader = new Reader();
        List<String> data = reader.read(new File("data1.txt"));
        List<String> output = reader.read(new File("output.txt"));
        List<String> metadata = reader.readMetaData(new File("metadata2.txt"));
        Verificator verificator=new Verificator();
        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
        assertFalse(isTestPassed);
    }
    public void testWithMetadataWithWhiteSigns() throws IOException {
        Reader reader = new Reader();
        List<String> data = reader.read(new File("data.txt"));
        List<String> output = reader.read(new File("output.txt"));
        List<String> metadata = reader.readMetaData(new File("metadataWithWhiteSigns.txt"));
        Verificator verificator=new Verificator();
        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
        assertTrue(isTestPassed);
    }
}
