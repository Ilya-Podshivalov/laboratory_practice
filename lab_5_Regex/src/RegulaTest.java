import org.junit.Assert;
import org.junit.Test;

public class RegulaTest {

    @Test
    public void CheckTest() {
        Regula reg = new Regula();
        boolean result = true;
        String str = "skdsaJK39_";
        boolean check = reg.Check(str);
        Assert.assertEquals(result, check);
    }

    @Test
    public void CheckTest2() {
        Regula reg = new Regula();
        boolean result = false;
        String str = "kskADsld_ads";
        boolean check = reg.Check(str);
        Assert.assertEquals(result, check);
    }
    @Test
    public void CheckTest3() {
        Regula reg = new Regula();
        boolean result = false;
        String str = "(Password12)";
        boolean check = reg.Check(str);
        Assert.assertEquals(result, check);
    }

    @Test
    public void CheckTest4() {
        Regula reg = new Regula();
        boolean result = true;
        String str = "Pass_Word23";
        boolean check = reg.Check(str);
        Assert.assertEquals(result, check);
    }
}