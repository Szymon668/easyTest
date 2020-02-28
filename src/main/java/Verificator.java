import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Verificator {

    public boolean verify(List<String> data, Map<String,String> conditions, List<String> output) {
        for (String s : data) {
            if (!output.contains(s)) {
                return false;
            }
        }
        return true;
    }
    public boolean verifyWithCondition(List<String> data,List<String> conditions, List<String> output) {

        for (int i=1;i<conditions.size();i+=2) {
            List<String >linesBeforeCondition=new ArrayList<>();
            for (String s1:output) {
                System.out.println(conditions.get(i));
                if(s1.equals(conditions.get(i))){
                   if(!linesBeforeCondition.contains(conditions.get(i-1))){
                       return false;
                   }
                }
                linesBeforeCondition.add(s1);
            }
        }
        for (String s : data) {
            if (!output.contains(s)) {
                return false;
            }
        }
        return true;

    }

}
