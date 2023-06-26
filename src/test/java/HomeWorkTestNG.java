import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeWorkTestNG {
    @Parameters({"num1", "num2"}) //with parameters done
    @Test(groups = "myExample")
    public void num1PlusNum2(int num1, int num2) {
        int result = num1 + num2;//num1 and num2 are added through configurations
        System.out.println(num1 + "+" + num2 + "=" + result);
    }

    @Test(groups = "secondExample")
    @DataProvider(name = "generateNumbers")
    public Object[][] generateNumbers() {
        return new Object[][]{
                {2, 3, 5},
                {5, 7, 9}
        };
    }
    @Test (dataProvider = "generateNumbers")
    public void num1PlusNum2dataProvider(int a, int b, int expectedSum) {
        int sum = a + b;
        Assert.assertEquals(expectedSum,sum, "If test pass, yes they are equal");
    }

    @Parameters({"num1", "num2"}) //with parameters done
    @Test(groups = "myExampleMinus")
    public void num1MinusNum2(int num1, int num2) {
        int result = num1 - num2;//num1 and num2 are added through configurations
        System.out.println(num1 + "-" + num2 + "=" + result);
    }

    @Test(groups = "thirdExampleMinus")
    @DataProvider(name = "generateNumbers2")
    public Object[][] generateNumbers2() {
        return new Object[][]{
                {7, 3, 4},
                {5, 2, 9}
        };
    }
    @Test (dataProvider = "generateNumbers2")
    public void num1MinusNum2(int a, int b, int expectedSum) {
        int sum = a - b;
        Assert.assertEquals(expectedSum,sum, "If test fail, the extraction is wrong");
    }

    @Parameters({"num1", "num2"}) //with parameters done
    @Test(groups = "myExampleMultiply")
    public void num1MultiplyNum2(int num1, int num2) {
        int result = num1 * num2;//num1 and num2 are added through configurations
        System.out.println(num1 + "*" + num2 + "=" + result);
    }

    @Test(groups = "thirdExampleMultiply")
    @DataProvider(name = "generateNumbers1")
    public Object[][] generateNumbers1() {
        return new Object[][]{
                {7, 3, 21},
                {5, 2, 9}
        };
    }
    @Test (dataProvider = "generateNumbers1")
    public void num1MultiplyNum2dataProvider(int a, int b, int expectedSum) {
        int sum = a * b;
        Assert.assertEquals(expectedSum,sum, "If test fail, the multiply is wrong");
    }

    @Parameters({"num1", "num2"}) //with parameters done
    @Test(groups = "myExampleDivide")
    public void num1DivideNum2(int num1, int num2) {
        int result = num1 / num2;//num1 and num2 are added through configurations
        System.out.println(num1 + "/" + num2 + "=" + result);
    }

    @Test(groups = "fourthExampleDivide")
    @DataProvider(name = "generateNumbers3")
    public Object[][] generateNumbers3() {
        return new Object[][]{
                {16, 8, 2},
                {13, 3, 4}
        };
    }
    @Test (dataProvider = "generateNumbers3")
    public void num1DivideNum2dataProvider1(int a, int b, int expectedSum) {
        int sum = a / b;
        Assert.assertEquals(expectedSum,sum, "If test fail, the result of arithmetic action is wrong");
    }

}

//adding and code from xml file (testng-parallel.xml) 
<suite name="Iliya first parallel run" verbose="1" parallel="methods" thread-count="1">//now is on method level, but also can be on class or suite
    <test name="Parallel Tests">
        <classes>
            <class name="HomeWorkTestNG"></class>
        </classes>
    </test>
</suite>
