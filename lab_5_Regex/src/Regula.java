import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regula {

    public Regula() {
    }

    public Boolean Check(String str) {
        if(str.length() < 8){
            return false;
        }
        boolean flag = true;
        Pattern p = Pattern.compile("([A-Z]+)");
        Matcher m = p.matcher(str);
        boolean a = m.find();
        if (!a) {
            flag = false;
        }
        p = Pattern.compile("[0-9]+");
        m = p.matcher(str);
        a = m.find();
        if (!a) {
            flag = false;
        }
        p = Pattern.compile("[a-z]+");
        m = p.matcher(str);
        a = m.find();
        if (!a) {
            flag = false;
        }
        p = Pattern.compile("[-+&*()$#@!/.,№;%:?]+");
        m = p.matcher(str);
        a = m.find();
        if (a) {
            flag = false;
        }
        if (flag) {
            return true;
        } else {
            return false;
        }
    }
}