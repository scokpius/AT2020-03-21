package homework_04.test;

import homework_04.entity.AutomatedTest;
import homework_04.entity.ManualTest;
import homework_04.entity.Result;
import homework_04.entity.ATest;
import homework_04.entity.TestLevel;
import homework_04.worker.AutomationEngineer;
import homework_04.worker.Engineer;
import homework_04.worker.TestEngineer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static homework_04.entity.Result.FAILED;
import static homework_04.entity.Result.PASSED;

@RunWith(Parameterized.class)
public class Test2 {
    private static final String MSG = "Test execution for %s by %s Anxiety %s is not correct!";
    private Engineer engineer;
    private ATest test;
    private int skill;
    private Result result;

    public Test2(Engineer engineer, int skill, ATest test,  Result result) {
        this.engineer = engineer;
        this.test = test;
        this.skill = skill;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers(){
        return Arrays.asList(new Object[][] {
                {new TestEngineer(), 1, new ManualTest(TestLevel.UNIT,5), PASSED},
                {new TestEngineer(), 10, new AutomatedTest(TestLevel.UNIT,5), PASSED},
                {new AutomationEngineer(), 10, new ManualTest(TestLevel.UNIT, 5),PASSED},
                {new AutomationEngineer(), 10, new AutomatedTest(TestLevel.UNIT, 5), PASSED}});
    }

    @Test
    public void verifyExecuteTest () {
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
