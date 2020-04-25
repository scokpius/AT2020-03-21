package tests.b_splitengineers;

import entity.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

import java.util.Arrays;
import java.util.Collection;

import static entity.Result.FAILED;
import static entity.Result.PASSED;



@RunWith(Parameterized.class)
public class ExecuteTest {
    private static final String MSG = "Test execution for %s by %s Anxiety %s is not correct!";
    private Engineer engineer;
    private ATest test;
    private int skill;
    private Result result;

    public ExecuteTest(Engineer engineer, int skill, ATest test, Result result) {
        this.engineer = engineer;
        this.test = test;
        this.skill = skill;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers(){
        return Arrays.asList(new Object[][] {
                {new TestEngineer(), 1, new AutomatedTest(TestLevel.UNIT, 1), PASSED},
                {new AutomationEngineer(), 10, new AutomatedTest(TestLevel.GUI, 0), PASSED},
                {new TestEngineer(), 1, new ManualTest(TestLevel.API, 0), PASSED},
                {new AutomationEngineer(), 10, new ManualTest(TestLevel.UNIT, 0), PASSED},
                {new TestEngineer(), 10, new ManualTest(TestLevel.UNIT, 10), PASSED},
                {new TestEngineer(), 10, new AutomatedTest(TestLevel.API, 11), PASSED},
                {new TestEngineer(), 1, new AutomatedTest(TestLevel.GUI, 10), FAILED},
                {new TestEngineer(), 1, new ManualTest(TestLevel.GUI, 11), FAILED},
                {new TestEngineer(), 1, new AutomatedTest(TestLevel.API, 0), PASSED},
                {new AutomationEngineer(), 1, new AutomatedTest(TestLevel.UNIT, 11), PASSED},
                {new AutomationEngineer(), 10, new AutomatedTest(TestLevel.API, 1), PASSED},
                {new AutomationEngineer(), 1, new ManualTest(TestLevel.API, 10), FAILED},
                {new AutomationEngineer(), 10, new ManualTest(TestLevel.GUI, 11), PASSED},
                {new AutomationEngineer(), 1, new ManualTest(TestLevel.GUI, 1), PASSED},
                {new TestEngineer(), 10, new ManualTest(TestLevel.API, 1), PASSED},
                {new AutomationEngineer(), 10, new AutomatedTest(TestLevel.API, 10), PASSED},
        });
    }

    @Test
    public void verifyExecuteTest () {
        engineer.setSkill(skill);
        Assert.assertEquals(String.format(MSG, test.getClass().getSimpleName(),
                engineer.getClass().getSimpleName(), engineer.getAnxiety()),
                result, engineer.executeTest(test));
    }


 /*   // checking branches by conditions
    @Test
    public void verifyExecuteManualTestByAutomationEngineer (){
        ManualTest test = new ManualTest(TestLevel.UNIT, 5);
        Assert.assertEquals(String.format(MSG, test.getClass().getSimpleName(),
                automationEngineer.getClass().getSimpleName(), automationEngineer.getAnxiety()),
                PASSED, automationEngineer.executeTest(test));
    }

    @Test
    public void verifyExecuteAutomatedTestByAutomationEngineer(){
        if (automationEngineer.getSkill()>2) automationEngineer.setSkill(2);
        AutomatedTest test = new AutomatedTest(TestLevel.GUI, 10);
        Assert.assertEquals(String.format(MSG, test.getClass().getSimpleName(),
                automationEngineer.getClass().getSimpleName(), automationEngineer.getAnxiety()),
                FAILED, automationEngineer.executeTest(test));
    }
    @Test
    public void verifyExecuteManualTestByTestEngineer (){
        ManualTest test = new ManualTest(TestLevel.GUI, 3);
        Assert.assertEquals(String.format(MSG, test.getClass().getSimpleName(),
                testEngineer.getClass().getSimpleName(), testEngineer.getAnxiety()),
                PASSED, testEngineer.executeTest(test));
    }

    @Test
    public void verifyExecuteAutomatedTestByTestEngineer(){
        if (testEngineer.getSkill()>2) testEngineer.setSkill(2);
        AutomatedTest test = new AutomatedTest(TestLevel.API, 8);
        Assert.assertEquals(String.format(MSG, test.getClass().getSimpleName(),
                testEngineer.getClass().getSimpleName(), testEngineer.getAnxiety()),
                FAILED, testEngineer.executeTest(test));
    }

    // verification of conditions
    // conditions in apply method: if1 (true || false) else (not evaluate), if2 (true);
    @Test
    public void verifyExecuteManualTestByAutomationEngineerPassed () {
        ManualTest test = new ManualTest(TestLevel.UNIT, 5);
        Assert.assertEquals(String.format(MSG, test.getClass().getSimpleName(),
                automationEngineer.getClass().getSimpleName(), automationEngineer.getAnxiety()),
                PASSED, automationEngineer.executeTest(test));
    }

    // conditions in apply method: if1 (true || false) else (not evaluate), if2 (false);
    @Test
    public void verifyExecuteManualTestByAutomationEngineerFailed () {
        if (automationEngineer.getSkill() > 7) automationEngineer.setSkill(7);
        ManualTest test = new ManualTest(TestLevel.GUI, 9);
        Assert.assertEquals(String.format(MSG, test.getClass().getSimpleName(),
                automationEngineer.getClass().getSimpleName(), automationEngineer.getAnxiety()),
                FAILED, automationEngineer.executeTest(test));
    }
*/
    // conditions in apply method: if1 (false || true) else (not evaluate), if2 (true);
 /*   @Test
    public void verifyExecuteAutomatedTestByTestEngineerPassed(){
        if (testEngineer.getSkill()>2) testEngineer.setSkill(2);
        AutomatedTest test = new AutomatedTest(TestLevel.API, 8);
        Assert.assertEquals(String.format(MSG, test.getClass().getSimpleName(),
                testEngineer.getClass().getSimpleName(), testEngineer.getAnxiety()),
                FAILED, testEngineer.executeTest(test));
    }

    // conditions in apply method: if1 (false || true) else (not evaluate), if2 (false);
    @Test
    public void verifyExecuteAutomatedTestByTestEngineerFailed() {
        if (testEngineer.getSkill() < 2) testEngineer.setSkill(7);
        AutomatedTest test = new AutomatedTest(TestLevel.API, 8);
        Assert.assertEquals(String.format(MSG, test.getClass().getSimpleName(),
                testEngineer.getClass().getSimpleName(), testEngineer.getAnxiety()),
                PASSED, testEngineer.executeTest(test));
    }

    // conditions in apply method: if1 (false || false) else (true), if2 (true);
    @Test
    public void verifyExecuteManualTestByTestEngineerPassed (){
        ManualTest test = new ManualTest(TestLevel.GUI, 3);
        Assert.assertEquals(String.format(MSG, test.getClass().getSimpleName(),
                testEngineer.getClass().getSimpleName(), testEngineer.getAnxiety()),
                PASSED, testEngineer.executeTest(test));
    }

    // conditions in apply method: if1 (false || false) else (true), if2 (false);
    @Test
    public void verifyExecuteManualTestByTestEngineerFailed (){
        ManualTest test = new ManualTest(TestLevel.GUI, 3);
        Assert.assertEquals(String.format(MSG, test.getClass().getSimpleName(),
                testEngineer.getClass().getSimpleName(), testEngineer.getAnxiety()),
                PASSED, testEngineer.executeTest(test));
    }
*/
}
