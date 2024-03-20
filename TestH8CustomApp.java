///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           8z, Test GPA calculator
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

/**
 * This class contains test cases for testing the calculation methods in
 * H8CustomApp.
 */
public class TestH8CustomApp {

    /**
     * This has various test cases that call the calculation methods to verify they work
     * according to the descriptions in the calculation method header comments.  If all the
     * test cases pass, then true is returned, otherwise false. This method is called
     * by a zyBooks test. Note the latest, highest scoring submission will be the one
     * that is human graded.
     *
     * @return true when all test cases pass, false otherwise.
     */
    public static boolean testH8CustomApp() {
        boolean error = false;

        {  //test case 1, this checks whether the convertLetterToGPA assigns the correct GPA value
            // to corresponding letter. This checks if B is equal to 3.0 is false.
            double expected = 3.0;
            String[][] semesterSubjectGPA = new String[1][2];
            semesterSubjectGPA[0][1] = "B";
            double[] subjectGPA;
            subjectGPA = H8CustomApp.convertLetterToGPA(semesterSubjectGPA);
            double result = subjectGPA[0];
            if (Math.abs(result - expected) > 0.0001) {
                error = true;
                System.out.println("exampleMethod 1) expected:" + expected + " result:" + result);
            }
        }

        { //test case 2, this checks whether the averageGPA of 3.5 calculation is false.
            double expected = 3.5;
            double[] subjectGPA = new double[3];
            subjectGPA[0] = 3.5;
            subjectGPA[1] = 4.0;
            subjectGPA[2] = 3.0;
            double result = H8CustomApp.averageGPA(subjectGPA);
            if (Math.abs(result - expected) > 0.0001) {
                error = true;
                System.out.println("exampleMethod 2) expected:" + expected + " result:" + result);
            }
        }

        //need at least 2 total test cases, passing arguments to the calculation method in
        // H8CustomApp for which the outcomes are predetermined - for example, you calculated
        // the return value by hand.

        if (error) {
            System.out.println("Error(s) in test cases.");
        } else {
            System.out.println("All test cases passed.");
        }
        return !error;
    }

    /**
     * This calls the testH8CustomApp method and prints out the result.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        System.out.println("Success: " + testH8CustomApp());
    }
}
