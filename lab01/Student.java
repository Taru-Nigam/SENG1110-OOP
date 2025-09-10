public class Student {
    String name;
    Subject subject1;
    Subject subject2;

    public Student(String studentName, Subject sub1, Subject sub2){
        name = studentName;
        subject1 = sub1;
        subject2 = sub2;
    }
    public boolean allMarks(String subjectName){
        if (subject1.getName().equals(subjectName)){
            System.out.println("Marks for "+ subject1.getName() + ":");
            System.out.println("Assignment 1 " + subject1.getAssign1());
            System.out.println("Assignment 2 " + subject1.getAssign2());
            System.out.println("Assignment 3 " + subject1.getAssign3());
            System.out.println("Exam 1 " + subject1.getExam1());
            System.out.println("Exam 2 " + subject1.getExam2());
            return true;
        } else if (subject2.getName().equals(subjectName)){
            System.out.println("Marks for "+ subject2.getName() + ":");
            System.out.println("Assignment 1 " + subject2.getAssign1());
            System.out.println("Assignment 2 " + subject2.getAssign2());
            System.out.println("Assignment 3 " + subject2.getAssign3());
            System.out.println("Exam 1 " + subject2.getExam1());
            System.out.println("Exam 2 " + subject2.getExam2());
            return true;
        }
        return false;
    }

    public double calcAverage(){
        double
    }


}
