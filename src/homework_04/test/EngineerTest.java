package homework_04.test;

import homework_04.entity.AutomatedTest;
import homework_04.entity.ManualTest;
import homework_04.entity.TestLevel;
import homework_04.worker.AutomationEngineer;
import homework_04.worker.Engineer;
import homework_04.worker.TestEngineer;
import org.junit.Assert;
import org.junit.Test;

import static homework_04.entity.Result.FAILED;
import static homework_04.entity.Result.PASSED;

public class EngineerTest {
    private static final String MSG = "Test execution for %s by %s Anxiety %s is not correct!";
    private Engineer testEngineer = new TestEngineer();
    private Engineer automationEngineer = new AutomationEngineer();
    private homework_04.entity.Test manualTest = new ManualTest(TestLevel.UNIT,5);

    @Test
    public void verifyRandomSkillbyAutomation() {
        Assert.assertTrue("Random Engineer Skill is not correct!",
                1<=testEngineer.getSkill() && testEngineer.getSkill()>10 );
    }
    @Test
    public void verifySetSkillbyAutomation() {
        automationEngineer.setSkill(5);
        Assert.assertEquals("Skill Engineer mas set is not correct!", 5, automationEngineer.getSkill());
    }
    @Test
    public void verifyDefaultAnxietyByManual() {
        Assert.assertEquals("Default Engineer Anxiety is not correct!", 3 , automationEngineer.getAnxiety());
    }
    // checking branches by conditions
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

    // conditions in apply method: if1 (false || true) else (not evaluate), if2 (true);
    @Test
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
    // checking instability value min
    @Test
    public void verifyExecuteInstabilityMin(){
        AutomatedTest test = new AutomatedTest(TestLevel.API, 0);
        Assert.assertEquals("Instability is not expected!", 1, test.getInstability());
    }
    // checking instability value max
    @Test
    public void verifyExecuteInstabilityMax(){
        AutomatedTest test = new AutomatedTest(TestLevel.API, 15);
        Assert.assertEquals("Instability is not expected!", 10, test.getInstability());
    }
}
