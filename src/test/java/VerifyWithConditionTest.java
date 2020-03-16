import junit.framework.TestCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VerifyWithConditionTest extends TestCase {
    public void testWithEmptyMetadata() throws IOException {
        Reader reader = new Reader();
        List<String> data = new ArrayList<>();
        {
            data.add("WEB:>A");
            data.add("WEB:>B");
            data.add("WEB:>C");
            data.add("WEB: > {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"request\",\"authKey\":null,\"timeout\":0," +
                    "\"body\":{\"name\":\"Krystian\",\"pwdSha256\":\"dd423f27dce8ae5e8300bd4cd479c62570953578dd968a7634a532ee400aec50\"}}\n");
            data.add("WEB: < {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"response\",\"authKey\":null," +
                    "\"timeout\":0,\"body\":{\"authKey\":\"f0c981bcac764bfab9f034718df17f33590ac4fb\"}}\n");

        }
        List<String> strings = reader.convertToData(data);
        List<String> output = new ArrayList<>();//reader.convertToData(output);
        {
            output.add("WEB:>A");
            output.add("WEB:>B");
            output.add("WEB:>C");
            output.add("WEB: > {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"request\",\"authKey\":null,\"timeout\":0," +
                    "\"body\":{\"name\":\"Krystian\",\"pwdSha256\":\"dd423f27dce8ae5e8300bd4cd479c62570953578dd968a7634a532ee400aec50\"}}\n");
            output.add("WEB: < {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"response\",\"authKey\":null," +
                    "\"timeout\":0,\"body\":{\"authKey\":\"f0c981bcac764bfab9f034718df17f33590ac4fb\"}}\n");

        }
        List<String> metadata= new ArrayList<>();
        Verificator verificator=new Verificator();
        boolean isTestPassed = verificator.verifyWithCondition(strings, metadata, output);
        assertTrue(isTestPassed);
    }
//    public void testWithCorrectMetadata() throws IOException {
//        Reader reader = new Reader();
//        List<String> data = reader.read(new File("data.txt"));
//        List<String> output = reader.read(new File("output.txt"));
//        List<String> metadata = reader.readMetaData(new File("metadata1.txt"));
//        Verificator verificator=new Verificator();
//        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
//        assertTrue(isTestPassed);
//    }
//    public void testWithNotCorrectMetadata() throws IOException {
//        Reader reader = new Reader();
//        List<String> data = reader.read(new File("data.txt"));
//        List<String> output = reader.read(new File("output.txt"));
//        List<String> metadata = reader.readMetaData(new File("metadata2.txt"));
//        Verificator verificator=new Verificator();
//        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
//        assertFalse(isTestPassed);
//    }
//    public void testWithNotCompleteOutput() throws IOException {
//        Reader reader = new Reader();
//        List<String> data = reader.read(new File("data.txt"));
//        List<String> output = reader.read(new File("output1.txt"));
//        List<String> metadata = reader.readMetaData(new File("metadata2.txt"));
//        Verificator verificator=new Verificator();
//        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
//        assertFalse(isTestPassed);
//    }
//    public void testWithNotCompleteData() throws IOException {
//        Reader reader = new Reader();
//        List<String> data = reader.read(new File("data1.txt"));
//        List<String> output = reader.read(new File("output.txt"));
//        List<String> metadata = reader.readMetaData(new File("metadata2.txt"));
//        Verificator verificator=new Verificator();
//        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
//        assertFalse(isTestPassed);
//    }
//    public void testWithMetadataWithWhiteSigns() throws IOException {
//        Reader reader = new Reader();
//        List<String> data = reader.read(new File("data.txt"));
//        List<String> output = reader.read(new File("output.txt"));
//        List<String> metadata = reader.readMetaData(new File("metadataWithWhiteSigns.txt"));
//        Verificator verificator=new Verificator();
//        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
//        assertTrue(isTestPassed);
//    }
}
