package homework_04.main;


import homework_04.worker.AutomationEngineer;
import homework_04.worker.TestEngineer;

public class Runner {
    public static void main(String[] args) {
        AutomationEngineer engineerOne = new AutomationEngineer(30, "Vasy", "Cidorov");
        System.out.printf("I invented in 5 days %d rows code.\n", engineerOne.inventRowsCode());
        engineerOne.testReport();
        TestEngineer engineerTwo = new TestEngineer(28, "Masha", "Ivanova");
        System.out.printf("I invented in 5 days %d rows code.\n",engineerTwo.inventRowsCode());

      //  System.out.println(engineerOne);
      //  System.out.println(engineerTwo);

    }
}
