/* Input: Take marks obtained (out of 100) in each subject.
Calculate Total Marks: Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
average percentage.
Grade Calculation: Assign grades based on the average percentage achieved.
Display Results: Show the total marks, average percentage, and the corresponding grade to the user */


import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter no of subjects : ");
        int noOfSubjects = input.nextInt();
        double[] marks = new double[noOfSubjects];

        for (int i = 0; i < noOfSubjects; i++) {
            System.out.print("Enter mark for subject-" + (i + 1) + " : ");
            marks[i] = input.nextDouble();
        }

        double totalMark = getTotalMarks(marks);
        double avgPercentage = totalMark / noOfSubjects;
        String grade = getGrades(avgPercentage);

        System.out.println("Total Marks : " + totalMark);
        System.out.println("Average Percentage : " + avgPercentage);
        System.out.println("Grade : " + grade);
    }

    static double getTotalMarks(double[] marks) {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum;
    }

    static String getGrades(double avgMark) {
        if (avgMark >= 90) {
            return "A+";
        } else if (avgMark >= 80) {
            return "A";
        } else if (avgMark >= 70) {
            return "B+";
        } else if (avgMark >= 60) {
            return "B";
        } else if (avgMark >= 50) {
            return "C";
        }
        return "U";
    }
}