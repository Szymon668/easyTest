import bittech.lib.utils.Utils;
import bittech.lib.utils.exceptions.StoredException;
import bittech.lib.utils.json.JsonBuilder;
import java.io.File;
import java.util.*;


public class Reader {
    public List<String> read(File data) {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(data)) {

            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                lines.add(nextLine);
            }

            return lines;
        }catch (Exception ex){
            throw new StoredException("Can't read from file ",ex);
        }



    }

    public List<String> convertToData(List<String> stringsToConvert) {
        String createdString = "";
        List<String> data=new ArrayList<>();
        for (String s :stringsToConvert) {
            if(s.contains("WEB")){
                if(createdString.isEmpty()){
                    createdString+=s;
                }
                else if(createdString.contains("WEB")){
                    System.out.println(createdString);
                    data.add(createdString);
                    createdString=s;
                }
            }
            else {
                createdString+=s;
            }

        }
        data.add(createdString);
        System.out.println(createdString);
        return data;

    }

    public List<String> convertToMetadat(List<String> metaDatLines) {
        try {
            List<String> condition = new ArrayList<>();
            for (String s:metaDatLines) {
                String[] split = s.split("->");
                Utils.prn(split);
                condition.add(split[0]);
                condition.add(split[1]);
            }
            System.out.println(JsonBuilder.build().toJson(condition));
            return condition;
        }catch (Exception e){
            throw new StoredException("Can 't read metadata !",e);
        }
    }

}
