import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
            }

        }
        return lines;

    }

}
