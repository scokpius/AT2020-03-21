package homework_03_task_3;

public class Runner {
    public static void main(String[] args) {
        Engineer engineerOne = new Engineer();
        Engineer engineerTwo = new Engineer();
        engineerOne.setEngineerAutomation();
        engineerOne.name = "Vasy";
        engineerOne.surName = "Cidorov";
        engineerTwo.setEngineerManual();
        engineerTwo.name = "Masha";
        engineerTwo.surName = "Ivanova";
        System.out.println(engineerOne);
        System.out.println(engineerTwo);

    }
}
