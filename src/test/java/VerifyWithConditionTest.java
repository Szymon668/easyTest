import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class VerifyWithConditionTest extends TestCase {
    public void testWithEmptyMetadata() {
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
        List<String> output = new ArrayList<>();
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
    public void testConvertToDataTest(){
        Reader reader = new Reader();
        List<String> data = new ArrayList<>();
        {
            data.add("WEB:>");
            data.add("A");
            data.add("WEB:>");
            data.add("B");
            data.add("WEB:>");
            data.add("C");
        }

        List<String> strings = reader.convertToData(data);
        List<String> output = new ArrayList<>();
        {

            output.add("WEB:>A");
            output.add("WEB:>B");
            output.add("WEB:>C");
        }
        List<String> metadata= new ArrayList<>();
        Verificator verificator=new Verificator();
        boolean isTestPassed = verificator.verifyWithCondition(strings, metadata, output);
        assertTrue(isTestPassed);

    }
    public void testWithCorrectMetadata(){
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

        List<String> output = new ArrayList<>();
        {
            output.add("WEB:>A");
            output.add("WEB:>B");
            output.add("WEB:>C");
            output.add("WEB: > {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"request\",\"authKey\":null,\"timeout\":0," +
                    "\"body\":{\"name\":\"Krystian\",\"pwdSha256\":\"dd423f27dce8ae5e8300bd4cd479c62570953578dd968a7634a532ee400aec50\"}}\n");
            output.add("WEB: < {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"response\",\"authKey\":null," +
                    "\"timeout\":0,\"body\":{\"authKey\":\"f0c981bcac764bfab9f034718df17f33590ac4fb\"}}\n");

        }
        List<String> metadataBeforeFormat=new ArrayList<>();
        {
            metadataBeforeFormat.add("WEB>A->WEB>B");
            metadataBeforeFormat.add("WEB>A->WEB>C");
        }
        List<String> metadata = reader.convertToMetadat(metadataBeforeFormat);
        Verificator verificator=new Verificator();
        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
        assertTrue(isTestPassed);
    }
    public void testWithNotCorrectMetadata()  {
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

        List<String> output = new ArrayList<>();
        {
            output.add("WEB:>A");
            output.add("WEB:>B");
            output.add("WEB:>C");
            output.add("WEB: > {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"request\",\"authKey\":null,\"timeout\":0," +
                    "\"body\":{\"name\":\"Krystian\",\"pwdSha256\":\"dd423f27dce8ae5e8300bd4cd479c62570953578dd968a7634a532ee400aec50\"}}\n");
            output.add("WEB: < {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"response\",\"authKey\":null," +
                    "\"timeout\":0,\"body\":{\"authKey\":\"f0c981bcac764bfab9f034718df17f33590ac4fb\"}}\n");

        }
        List<String> metadataBeforeFormat=new ArrayList<>();
        {
            metadataBeforeFormat.add("WEB:>C->WEB:>A");
        }
        List<String> metadata = reader.convertToMetadat(metadataBeforeFormat);
        Verificator verificator=new Verificator();
        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
        assertFalse(isTestPassed);
    }
    public void testWithNotCompleteOutput() {
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

        List<String> output = new ArrayList<>();
        {
            output.add("WEB:>A");
            output.add("WEB:>B");
            output.add("WEB: > {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"request\",\"authKey\":null,\"timeout\":0," +
                    "\"body\":{\"name\":\"Krystian\",\"pwdSha256\":\"dd423f27dce8ae5e8300bd4cd479c62570953578dd968a7634a532ee400aec50\"}}\n");
            output.add("WEB: < {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"response\",\"authKey\":null," +
                    "\"timeout\":0,\"body\":{\"authKey\":\"f0c981bcac764bfab9f034718df17f33590ac4fb\"}}\n");

        }
        List<String> metadataBeforeFormat=new ArrayList<>();
        {
            metadataBeforeFormat.add("WEB>A->WEB>B");
            metadataBeforeFormat.add("WEB>A->WEB>C");
        }
        List<String> metadata = reader.convertToMetadat(metadataBeforeFormat);
        Verificator verificator=new Verificator();
        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
        assertFalse(isTestPassed);
    }
    public void testWithNotCompleteData()  {
        Reader reader = new Reader();
        List<String> data = new ArrayList<>();
        {
            data.add("WEB:>A");
            data.add("WEB: > {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"request\",\"authKey\":null,\"timeout\":0," +
                    "\"body\":{\"name\":\"Krystian\",\"pwdSha256\":\"dd423f27dce8ae5e8300bd4cd479c62570953578dd968a7634a532ee400aec50\"}}\n");
            data.add("WEB: < {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"response\",\"authKey\":null," +
                    "\"timeout\":0,\"body\":{\"authKey\":\"f0c981bcac764bfab9f034718df17f33590ac4fb\"}}\n");

        }

        List<String> output = new ArrayList<>();
        {
            output.add("WEB:>A");
            output.add("WEB:>B");
            output.add("WEB:>C");
            output.add("WEB: > {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"request\",\"authKey\":null,\"timeout\":0," +
                    "\"body\":{\"name\":\"Krystian\",\"pwdSha256\":\"dd423f27dce8ae5e8300bd4cd479c62570953578dd968a7634a532ee400aec50\"}}\n");
            output.add("WEB: < {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"response\",\"authKey\":null," +
                    "\"timeout\":0,\"body\":{\"authKey\":\"f0c981bcac764bfab9f034718df17f33590ac4fb\"}}\n");

        }
        List<String> metadataBeforeFormat=new ArrayList<>();
        {
            metadataBeforeFormat.add("WEB>A->WEB>B");
            metadataBeforeFormat.add("WEB>A->WEB>C");
        }
        List<String> metadata = reader.convertToMetadat(metadataBeforeFormat);
        Verificator verificator=new Verificator();
        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
        assertFalse(isTestPassed);
    }
    public void testWithMetadataWithWhiteSigns()  {
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

        List<String> output = new ArrayList<>();
        {
            output.add("WEB:>A");
            output.add("WEB:>B");
            output.add("WEB:>C");
            output.add("WEB: > {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"request\",\"authKey\":null,\"timeout\":0," +
                    "\"body\":{\"name\":\"Krystian\",\"pwdSha256\":\"dd423f27dce8ae5e8300bd4cd479c62570953578dd968a7634a532ee400aec50\"}}\n");
            output.add("WEB: < {\"id\":6294295475024804864,\"name\":\"bittech.lib.bitflow.web.commands.LoginCommand\",\"type\":\"response\",\"authKey\":null," +
                    "\"timeout\":0,\"body\":{\"authKey\":\"f0c981bcac764bfab9f034718df17f33590ac4fb\"}}\n");

        }
        List<String> metadataBeforeFormat=new ArrayList<>();
        {
            metadataBeforeFormat.add("WEB >A -> WEB > C");
            metadataBeforeFormat.add("WEB >A -> WEB > B");
        }
        List<String> metadata = reader.convertToMetadat(metadataBeforeFormat);
        Verificator verificator=new Verificator();
        boolean isTestPassed = verificator.verifyWithCondition(data, metadata, output);
        assertTrue(isTestPassed);
    }
}
