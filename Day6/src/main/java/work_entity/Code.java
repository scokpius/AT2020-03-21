package work_entity;

public class Code {
    private int workDay;
    private int writeRows = 150;

    public Code(int workDay) {
        this.workDay = workDay;
    }

    public int getWorkDay() {
        return workDay;
    }

    public int develop() {
        return this.getWorkDay() * writeRows;
    }
}
