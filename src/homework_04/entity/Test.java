package homework_04.entity;

import java.util.function.Function;

import homework_04.worker.AutomationEngineer;
import homework_04.worker.Engineer;
import homework_04.worker.TestEngineer;

public class Test implements Function<Engineer, Result> {
    private int complexity;

    private int instability;

    Test(TestLevel testLevel) {
        this.complexity = testLevel.COMPLEXITY;
    }

      void setInstability(int instability) {
        this.instability = instability;
    }

    @Override
    public Result apply(Engineer engineer) {
        int anxiety;
        if ((this instanceof ManualTest) && (engineer instanceof AutomationEngineer) ||
                (this instanceof AutomatedTest) && (engineer instanceof TestEngineer)) {
            anxiety = engineer.getAnxiety();
        } else anxiety = 1;

        if (complexity * instability * anxiety > 30) return Result.FAILED;
        else return Result.PASSED;
    }
}
