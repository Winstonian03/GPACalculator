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
    public static final double INVALID_GRADE = -1.0;
    /**
     * This method converts a letter grade to a numeric GPA grade.
     *
     * @param semesterSubjectGPA    - String letter grade
     * @return double value of the numeric string letter grade
     */
    public static double convertLetterToGPA(String semesterSubjectGPA) {
        switch (semesterSubjectGPA) {
            case "A":
                return 4.0;
            case "AB":
                return 3.5;
            case "B":
                return 3.0;
            case "BC":
                return 2.5;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
        }
        return INVALID_GRADE;
    }

    /**
     * This method sums the GPA values from the convertLetterToGPA method, and averages it out
     * using the length of the array.
     *
     * @param twoDimensionalArray   - String array with converted numeric GPA
     * @return double average
     */
    public static double computeSemesterGPA(String[][] twoDimensionalArray) {
        double gpa;
        double gpaAverage = 0;
        for(int i = 0; i < twoDimensionalArray.length; i++) {
            gpa = convertLetterToGPA(twoDimensionalArray[i][1]);
            if (gpa != -1) {
                gpaAverage += gpa;
            }
        }
        return gpaAverage / (double)twoDimensionalArray.length;
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
        int numOfSubjects = 1;
        while (!isValid) {
            if (scnr.hasNextInt()) {
                numOfSubjects = scnr.nextInt();
                if (numOfSubjects >= 1) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input. Please enter a valid positive " +
                            "integer value.");
                }
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

        double avgGPAValue = computeSemesterGPA(semesterSubjectGPA);
        System.out.println("Your average GPA this semester is " + avgGPAValue);

        scnr.close();
    }
}
