import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class Reader {
    public List<String> read(File data) throws IOException {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(data)) {
            String createdString = "";
            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                createdString += nextLine;

            }
            String[] webs = createdString.split("(?=WEB)");
            for (String s : webs) {
                lines.add(s);
                System.out.println(s);
            }

        }
        return lines;

    }
    public List<String> readMetaData(File metadata) throws FileNotFoundException {
            List<String> condition=new ArrayList<>();
       try(Scanner scanner=new Scanner(metadata)) {
           while (scanner.hasNext()){
               String[] split = scanner.nextLine().split("->");
               condition.add(split[0]);
               condition.add(split[1]);
           }
       }
       return condition;

    }

}
