import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader=new Reader();
        reader.read(new File("data.txt"));
    }
}
