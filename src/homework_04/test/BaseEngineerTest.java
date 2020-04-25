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
public class BaseEngineerTest {
    private Engineer engineer;

    public BaseEngineerTest(Engineer engineer) {
        this.engineer = engineer;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers(){
        return Arrays.asList(new Object[][] {{new TestEngineer()},{new AutomationEngineer()}});
    }


    @Test
    public void verifyRandomSkillbyAutomation() {
        Assert.assertTrue("Random Engineer Skill is not correct!",
                1<=engineer.getSkill() && engineer.getSkill()<11 );
    }
    @Test
    public void verifySetSkillbyAutomationMax() {
        engineer.setSkill(10);
        Assert.assertEquals("Skill Engineer mas set is not correct!", 10, engineer.getSkill());
    }
    @Test
    public void verifySetSkillbyAutomationMin() {
        engineer.setSkill(1);
        Assert.assertEquals("Skill Engineer mas set is not correct!", 1, engineer.getSkill());
    }
    @Test
    public void verifyDefaultAnxietyByManual() {
        Assert.assertEquals("Default Engineer Anxiety is not correct!", 3 , engineer.getAnxiety());
    }

}
