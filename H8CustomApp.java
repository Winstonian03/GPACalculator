///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           8z, GPA calculator
// Course:          CS 200, Spring 2024
//
// Author:          Winston Chan
// Email:           wchan35@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// No help given or received.
//
///////////////////////////////// REFLECTION ///////////////////////////////////
//
// 1. Describe the problem you wrote the program to solve: To calculate the GPA, given the number
//    of subjects and the grade for the course. It also prompts the user for their subject title.
// 2. What are the biggest challenges you encountered: Incorporating a 2D array to allow
//    inputs into the rows and columns to organize the data on a "chart".
// 3. What did you learn from this assignment: The use of arrays, and how it can be helpful when
//    calculating averages and sorting large amounts of data.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.Scanner;

/**
 * This class contains code to calculate the average GPA across all subjects this semester from the
 * UW-Madison grading scale to the 4.0 GPA scale.
 *
 * @author Winston Chan
 */
public class H8CustomApp {
    /**
     * This method converts and stores the GPA weights on a 4.0 scale into a separate array under
     * the same index as the subject.
     *
     * @param semesterSubjectGPA    - double dimensional array for subjects and letter grades
     * @return double array of GPA grades
     */
    public static double[] convertLetterToGPA(String[][] semesterSubjectGPA) {
        double[] subjectGPA = new double[semesterSubjectGPA.length];
        for (int i = 0; i < semesterSubjectGPA.length; i++) {
            switch (semesterSubjectGPA[i][1]) {
                case "A":
                    subjectGPA[i] = 4.0;
                    break;
                case "AB":
                    subjectGPA[i] = 3.5;
                    break;
                case "B":
                    subjectGPA[i] = 3.0;
                    break;
                case "BC":
                    subjectGPA[i] = 2.5;
                    break;
                case "C":
                    subjectGPA[i] = 2.0;
                    break;
                case "D":
                    subjectGPA[i] = 1.0;
                    break;
                case "F":
                    subjectGPA[i] = 0.0;
                    break;
                default:
                    System.out.print("Enter a valid letter grade ");
            }
        }
        return subjectGPA;
    }

    /**
     * This method sums the GPA values from the convertLetterToGPA method, and averages it out
     * using the length of the array.
     *
     * @param subjectGPA    - array of weighted grades in their respective subject index
     * @return double value of the average GPA this semester
     */
    public static double averageGPA(double[] subjectGPA) {
        double totalGPAValue = 0;
        double avgGPAValue;
        for (int i = 0; i < subjectGPA.length; i++) {
            totalGPAValue += subjectGPA[i];
        }
        avgGPAValue = totalGPAValue / subjectGPA.length;
        return avgGPAValue;
    }

    /**
     * This method prompts the user for the subjects, and grades for each subject. It then
     * stores these values into a 2D array, and calculates the average GPA this semester
     * using the methods above.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("How many subjects are you taking this semester: ");
        boolean isValid = false;
        int numOfSubjects = 0;
        while (!isValid) {
            if (scnr.hasNextInt()) {
                numOfSubjects = scnr.nextInt();
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer value.");
                scnr.nextLine();
            }
        }

        String[][] semesterSubjectGPA = new String[numOfSubjects][2];
        scnr.nextLine();
        for (int i = 0; i < numOfSubjects; i++) {
            System.out.println("What is subject no." + (i + 1) + "?");
            semesterSubjectGPA[i][0] = scnr.nextLine();
            System.out.println("What is your grade for that subject? (A, AB, B, BC, C, D, F): ");
            isValid = false;
            String letterGrade;
            while (!isValid) {
                letterGrade = scnr.next();
                letterGrade = letterGrade.toUpperCase();
                if (letterGrade.equals("A") || letterGrade.equals("AB") || letterGrade.equals("B")
                        || letterGrade.equals("BC") || letterGrade.equals("C")
                        || letterGrade.equals("D") || letterGrade.equals("F")) {
                    semesterSubjectGPA[i][1] = letterGrade.toUpperCase();
                    isValid = true;
                } else {
                    System.out.println("Invalid input. Please enter a valid grade value " +
                            "(A, AB, B, BC, C, D, F).");
                }
                scnr.nextLine();
            }
        }

        double[] subjectGPA;
        subjectGPA = convertLetterToGPA(semesterSubjectGPA);
        double avgGPAValue;
        avgGPAValue = averageGPA(subjectGPA);
        System.out.println("Your average GPA this semester is " + avgGPAValue);

        scnr.close();
    }
}
