package homework_04.worker;


import homework_04.entity.*;
import homework_04.people.Person;
import homework_04.work_entity.Code;
import homework_04.work_entity.InventableCode;

public abstract class Engineer extends Person implements InventableCode {
    private int skill;

    private int anxiety = 3;

    public int getSkill() {
        return skill;
    }

    private void setSkill() {
        this.skill = (int) (Math.random()*10)+1;
    }

    public int getAnxiety() {
        return anxiety;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    Engineer(int age, String name, String surName) {
        super(age, name, surName);
        setSkill();
        System.out.printf("My name is %s.\nI am %d. I have %d skills.\n", name + " " + surName, age, this.skill);
    }

    @Override
    public int inventRowsCode() {
        int day = 5;
        Code code = new Code(day);
        return code.develop();
    }

    @Override
    public void testReport() {
        int random;
        String str;
        System.out.println("Test report:");
        for (int i = 1; i < 6; i++) {
            random = (int) (Math.random()*3)+1;
            switch (random){
                case 1: { Result result = executeTest(new AutomatedTest(TestLevel.UNIT, 9));
                            if (result == Result.FAILED) str = "FAILED";
                            else {
                                str = "PASSED";
                            }
                            System.out.printf("Test № %d result %s.\n", i, str);
                            break;
                }
                case 2: { Result result = executeTest(new AutomatedTest(TestLevel.API, 3));
                            if (result == Result.FAILED) { str = "FAILED";
                            }
                            else {
                                str = "PASSED";
                            }
                            System.out.printf("Test № %d result %s.\n", i, str);
                            break;
                }
                case 3: { Result result = executeTest(new AutomatedTest(TestLevel.GUI, 9));
                             if (result == Result.FAILED) str = "FAILED";
                             else {
                                 str = "PASSED";
                             }
                             System.out.printf("Test № %d result %s.\n", i, str);
                             break;
                }
                default:
                    break;
            }
        }

    }

    public Result executeTest(ATest test){
     return test.apply(this);
    }
}
