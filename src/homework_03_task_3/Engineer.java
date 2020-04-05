package homework_03_task_3;

public class Engineer extends Person {
    private static Boolean engineerAutomation=false;

    private static Boolean engineerManual=false;

    private static String getEngineer() {
        if (engineerAutomation) {
            engineerAutomation = false;
            return "Automation";
        }
        if (engineerManual) {
            engineerManual = false;
            return "Manual";
        }
        return "Engineer";
    }

    private void inventCode(){
        System.out.println(" I can invent code. ");
    }

    void setEngineerAutomation() {
        engineerAutomation = true;
    }

    void setEngineerManual() {
        engineerManual = true;
    }

    @Override
    public String toString() {
        System.out.println(" Hi! \n My name is " + name + ". \n My surname is " + surName + ".");
        this.speak();
        this.inventCode();
        return " I am Engineer" + getEngineer() + "\n";
    }
}
