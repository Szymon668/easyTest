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
        List<String >linesBeforeCondition=new ArrayList<>();
        for (int i=1;i<conditions.size();i+=2) {
            for (String s1:output) {
                linesBeforeCondition.add(s1);
                if(s1.equals(conditions.get(i))){
                   if(!linesBeforeCondition.contains(conditions.get(i-1))){
                       return false;
                   }
                }
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
