package homework_04.test;

import homework_04.entity.AutomatedTest;
import homework_04.entity.ManualTest;
import homework_04.entity.TestLevel;
import homework_04.worker.AutomationEngineer;
import homework_04.worker.Engineer;
import homework_04.worker.TestEngineer;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class test1 {

    private Engineer engineer;

    public test1(Engineer engineer) {
        this.engineer = engineer;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers(){
        return Arrays.asList(new Object[][] {{new TestEngineer()},{new AutomationEngineer()}});
    }
//    private static final String MSG = "Test execution for %s by %s Anxiety %s is not correct!";
//    private Engineer testEngineer = new TestEngineer();
//    private Engineer automationEngineer = new AutomationEngineer();

    @Test
    public void verifyRandomSkillbyAutomation() {
        Assert.assertTrue("Random Engineer Skill is not correct!",
                1<=engineer.getSkill() && engineer.getSkill()>10 );
    }
    @Test
    public void verifySetSkillbyAutomation() {
        engineer.setSkill(5);
        Assert.assertEquals("Skill Engineer mas set is not correct!", 5, engineer.getSkill());
    }
    @Test
    public void verifyDefaultAnxietyByManual() {
        Assert.assertEquals("Default Engineer Anxiety is not correct!", 3 , engineer.getAnxiety());
    }
    @Test
    public void verifyDefaultAnxietyByManualSet() {
        engineer.setSkill(2);
        Assert.assertEquals("Default Engineer Anxiety is not correct!", 2 , engineer.getAnxiety());
    }

    /*@Test
    public void verifyExecuteInstabilityMin(){
        AutomatedTest test = new AutomatedTest(TestLevel.API, 0);
        Assert.assertEquals("Instability is not expected!", 1, test.getInstability());
    }
    // checking instability value max
    @Test
    public void verifyExecuteInstabilityMax(){
        AutomatedTest test = new AutomatedTest(TestLevel.API, 15);
        Assert.assertEquals("Instability is not expected!", 10, test.getInstability());
    }*/
}
