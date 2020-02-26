import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader=new Reader();
        List<String> data = reader.read(new File("data.txt"));
        List<String> output = reader.read(new File("output.txt"));
        List<String> metadata=reader.readMetaData(new File("metadata.txt"));
        Verificator verificator=new Verificator();
        System.out.println(verificator.verifyWithCondition(data,metadata,output));

    }
}
