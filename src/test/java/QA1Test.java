import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Alexandr on 22.04.2017.
 */
public class QA1Test {

    @Test
    public void test_1 () {
        QA1 qa1 = new QA1();
        Assert.assertEquals(3.0, qa1.calc(6,2,"Div"),"Result:");
    }

    @Test
    public void test_6 () {
        QA1 qa1 = new QA1();
        Assert.assertEquals( -1.0, qa1.calc(6,0,"Div"),"Result:");
    }

    @Test
    public void test_2 () {
        QA1 qa1 = new QA1();
        Assert.assertEquals(12.0, qa1.calc(6,2,"Mult"),"Result:");
    }

    @Test
    public void test_3 () {
        QA1 qa1 = new QA1();
        Assert.assertEquals(4.0, qa1.calc(6,2,"Diff"),"Result:");
    }

    @Test
    public void test_4 () {
        QA1 qa1 = new QA1();
        Assert.assertEquals(8.0, qa1.calc(6,2,"Sum"),"Result:");
    }
}
