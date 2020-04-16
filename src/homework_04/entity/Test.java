package homework_04.entity;

import java.util.function.Function;

import homework_04.worker.AutomationEngineer;
import homework_04.worker.Engineer;
import homework_04.worker.TestEngineer;

public abstract class Test implements Function<Engineer, Result> {
    private int complexity;

    private int instability;

    Test(TestLevel testLevel, int instability) {
        this.complexity = testLevel.COMPLEXITY;
        if (instability == 0) this.instability = 1;
        else if (instability > 10) this.instability = 10;
        else this.instability = instability;
    }


    @Override
    public Result apply(Engineer engineer) {
        int anxiety;
        if ((this instanceof ManualTest) && (engineer instanceof AutomationEngineer) ||
                (this instanceof AutomatedTest) && (engineer instanceof TestEngineer)) {
            anxiety = engineer.getAnxiety();
        } else anxiety = 1;

        if (complexity * instability * anxiety/engineer.getSkill() > 30) return Result.FAILED;
        else return Result.PASSED;
    }
}
