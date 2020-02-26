import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Reader {


    public void read(File data) throws IOException {
        List<String> lines= new ArrayList<>();
        try (Scanner scanner = new Scanner(data)) {
            String createdString="";
            while (scanner.hasNext()) {
                String nextLine=scanner.nextLine();
              createdString+=nextLine;

        }
            StringTokenizer ss=new StringTokenizer(createdString,"WEB");
            String[] webs = createdString.split("(?=WEB)");
            for (String s:webs
                 ) {
                System.out.println(s);
            }

    }


}

}
