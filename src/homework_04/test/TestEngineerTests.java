package homework_04.test;


import homework_04.entity.AutomatedTest;
import homework_04.entity.ManualTest;
import homework_04.entity.TestLevel;
import homework_04.worker.TestEngineer;
import org.junit.Assert;
import org.junit.Test;

import static homework_04.entity.Result.FAILED;
import static homework_04.entity.Result.PASSED;

public class TestEngineerTests {
    @Test
    public void manualTestGui (){
        TestEngineer engineer = new TestEngineer();
        ManualTest test = new ManualTest(TestLevel.GUI, 3);
        Assert.assertEquals("Manual test UNIT, instability = 3", PASSED, engineer.executeTest(test));
        System.out.println(engineer.executeTest(test));
    }

    @Test
    public void autoTestApi(){
        TestEngineer engineer = new TestEngineer();
        AutomatedTest test = new AutomatedTest(TestLevel.API, 8);
        Assert.assertEquals("Manual test UNIT, instability = 8", FAILED, engineer.executeTest(test));
        System.out.println(engineer.executeTest(test));
    }
}
