package homework_04.test;

import homework_04.entity.AutomatedTest;
import homework_04.entity.ManualTest;
import homework_04.entity.TestLevel;
import homework_04.worker.AutomationEngineer;
import org.junit.Assert;
import org.junit.Test;

import static homework_04.entity.Result.FAILED;
import static homework_04.entity.Result.PASSED;

public class AutomationEngineerTests {

    @Test
    public void manualTestUnit (){
        AutomationEngineer engineer = new AutomationEngineer();
        ManualTest test = new ManualTest(TestLevel.UNIT, 5);
        Assert.assertEquals("Manual test UNIT, instability = 5", PASSED, engineer.executeTest(test));
        System.out.println(engineer.executeTest(test));
    }

    @Test
    public void autoTestGui(){
        AutomationEngineer engineer = new AutomationEngineer();
        AutomatedTest test = new AutomatedTest(TestLevel.GUI, 4);
        Assert.assertEquals("Manual test UNIT, instability = 4", FAILED, engineer.executeTest(test));
        System.out.println(engineer.executeTest(test));
    }
}
