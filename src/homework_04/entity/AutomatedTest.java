package homework_04.entity;

public class AutomatedTest extends Test {
    public AutomatedTest(TestLevel testLevel, int instability) {
        super(testLevel);
        setInstability(instability);
    }
}
