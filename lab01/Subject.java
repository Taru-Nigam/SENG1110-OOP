public class Subject {
    private final String name;
    private int exam1, exam2, assign1, assign2, assign3;

    public Subject(String subjectName) {
        name = subjectName; // Set the name
        assign1 = 0;
        assign2 = 0;
        assign3 = 0;
        exam1 = 0;
        exam2 = 0;
    }

    // Method to set assignments' marks
    public void setAssign(int a1, int a2, int a3) {
        assign1 = a1;
        assign2 = a2;
        assign3 = a3;
    }

    // Method to set exams' marks
    public void setExams(int e1, int e2) {
        exam1 = e1;
        exam2 = e2;
    }

    // Method to calculate and return the average of marks
    public double getAverage() {
        int totalAssign = assign1 + assign2 + assign3;
        int totalExam = exam1 + exam2;
        double average = ((totalAssign / 3.0) * 0.1) + ((totalExam / 2.0) * 0.35);
        return average;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getters for assignment and exam marks
    public int getAssign1() {
        return assign1;
    }

    public int getAssign2() {
        return assign2;
    }

    public int getAssign3() {
        return assign3;
    }

    public int getExam1() {
        return exam1;
    }

    public int getExam2() {
        return exam2;
    }

}
