/*
==================================================================
Grades.java
==================================================================

Use Student class to get test grades for two students
compute averages, and determine if their date of birth is valid.

==================================================================
*/

import java.util.Scanner;

public class Grade
{

    public static void main(String[] args)
    {

        /*
         * For each student:
         * 1. prompt for and accept student's name and date of birth values;
         * 2. create student;
         * 3. input test scores; and
         * 4. print the student
         */


        Scanner scan = new Scanner(System.in);

        System.out.println("How many student(s) do you want to enter?");
        int n = scan.nextInt();

        for (int i = 0; i < n; i++)
        {

            System.out.println("\n" + "Enter Student " + (i + 1) + "'s Name:");
            String name = scan.next();

            System.out.println("Enter " + name + "`s Year of Birth:");
            int yr = scan.nextInt();

            System.out.println("Enter " + name + "`s Month of Birth:");
            int mth = scan.nextInt();

            System.out.println("Enter " + name + "`s Day of Birth:");
            int dy = scan.nextInt();

            Student Stud = new Student (name, yr, mth, dy);

            Stud.inputGrades(scan);

            System.out.println(Stud.toString());

        }


    } /* end of main method */

} /* end of class */
