/*
=================================================================
Student.java
=================================================================

Define a student class that stores name, date of birth, scores 
for five (5) tests. 

Methods:
1. prompt for and read in grades, 
2. checks that the date of birth can create a valid date, 
3. checks if student is a minor, i.e, underage, 
4. computes the average, 
5. computes the standard deviation;  and 
6. return a string containing a summary of the student's data.
=================================================================

*/

import java.util.ArrayList;
import java.util.Scanner;


public class Student
{

    /*
     * Declare instance data here
     * Don't forget to use appropriate modifiers
     */


    /*
     * ---------------------------------------------
     * Global Variables:
     * ---------------------------------------------
     */

    private String stuName;

    private Date DOB;

    String res;

    double stDEV;

    float aveRAGE;

    /*
     * ---------------------------------------------
     * Lists:
     * ---------------------------------------------
     */



    ArrayList<String> testInfo = new ArrayList<String>();

    ArrayList<Float> gradeInfo = new ArrayList<Float>();

    /*
     * ---------------------------------------------
     * Constructor
     * ---------------------------------------------
     */

    public Student (String stuName, int year, int month, int day)
    {

        this.stuName = stuName;
        DOB = new Date(year, month, day);

    }

    /*
     * Add accessors (7) and mutators (7) for the instance
     * data
     */

    /*
     * ---------------------------------------------
     * Accessors
     * ---------------------------------------------
     */

    public String getstuName()
    {

        return stuName;

    }

    public Date getDOB()
    {

        return DOB;

    }


    /*
     * ---------------------------------------------
     * Mutators
     * ---------------------------------------------
     */

    public void setstuName(String stuName)
    {

        this.stuName = stuName;

    }

    public void setDOB(int y, int m, int d)
    {

        this.DOB = new Date(y, m, d);

    }


    /*
     * ---------------------------------------------
     * inputGrades:
     *
     * 1. use the Scanner object that is passed into
     * the method to prompt for and accept in the
     * student's grades for the tests.
     * 2. Use the name instance data in prompts,
     * e.g., "Enter's Pricillia's score for test 1".
     * ---------------------------------------------
     */

    public void inputGrades(Scanner scan)
    {

        System.out.println("How many test(s) and test score(s) do you want to enter?");
        int n = scan.nextInt();

        for (int i = 0; i < n; i++)
        {

            System.out.println("Enter the name of the test, for test score number #" + (i+1));
            String testName = scan.next();

            System.out.println("Enter the test score for " + testName);
            float studScore = scan.nextFloat();

            gradeInfo.add(studScore);

            System.out.println("Enter the test date`s year for " + testName);
            int tstYR = scan.nextInt();

            System.out.println("Enter the test date`s month for " + testName);
            int tstMTH = scan.nextInt();

            System.out.println("Enter the test date`s day for " + testName);
            int tstDY = scan.nextInt();

            TestScore TestInfo = new TestScore (testName, studScore, tstYR, tstMTH, tstDY);

            testInfo.add(TestInfo.toString());


        }

    }

    /*
     * ---------------------------------------------
     * getAverage:
     *
     * compute and return the average (mean) of the
     * student’s test scores
     * --------------------------------------------
     */

    public float getaveRAGE()
    {

        int length = gradeInfo.size();

        if (length == 0)
        {

            return -1;

        }
        else
        {

            float sum = 0f;

            for (int i = 0; i < length; i++)
            {

                sum = sum + gradeInfo.get(i);

            }

            aveRAGE = sum / length;

        }
        return aveRAGE;

    }


    /*
     * --------------------------------------------------
     *
     * getLetterGrade:
     *
     * compute and return the character lettergrade
     * corresponding to a student's average
     *
     * ---------------------------------------------------
     */

    public String getLetterGrade(float aveRAGE)
    {

        String letterGrade;

        int i = 0;

        if (aveRAGE > 82)
        {

            i = 1;

        }

        if ((aveRAGE <= 83) && (aveRAGE > 62))
        {

            i = 2;

        }

        if ((aveRAGE <= 62) && (aveRAGE > 50))
        {


            i = 3;

        }


        switch(i)
        {

            case 1:

                letterGrade = "A";

                break;

            case 2:

                letterGrade = "B";

                break;

            case 3:

                letterGrade = "C";

                break;

            default:

                letterGrade = "F";

                break;

        }

        return letterGrade;

    }



    /*
     * ---------------------------------------------
     * getStandardDeviation:
     *
     * compute and return the standard deviation
     * of the student’s test scores
     * --------------------------------------------
     */

    public double getStandardDeviation()
    {

        boolean ans = gradeInfo.isEmpty();
        int length = gradeInfo.size();

        if (length <= 1)
        {

            return -1;

        }
        else
        {
            double sum = 0.0;
            double stdDeviation = 0.0;
            double mean = 0.0;
            double sq = 0.0;


            for (int i = 0; i < length; i++)
            {

                sum = sum + gradeInfo.get(i);

            }

            mean = sum / length;

            for (int i = 0; i < length; i++)
            {

                stdDeviation = stdDeviation + Math.pow((gradeInfo.get(i) - mean), 2);


            }

            stDEV = Math.sqrt(stdDeviation/length);
        }
        return stDEV;

    }

    /*
     * ---------------------------------------------
     * isUnderAge:
     *
     * check if the student is less than 18 years old,
     * use the date on the day of the lab as the
     * current date when calculating the age of the
     * student
     * -------------------------------------------
     */

    public boolean isUnderAge()
    {

        Boolean isanswer = null;

        if ((DOB.getyear()) < 2004)
        {

            isanswer = false;

        }
        else
        {
            if ((DOB.getyear()) == 2004)
            {

                if ((DOB.getmonth()) < 9)
                {

                    isanswer = false;

                }
                else
                {

                    if ((DOB.getmonth()) == 9)
                    {

                        if ((DOB.getday()) < 21)
                        {

                            isanswer = false;

                        }
                        else
                        {

                            isanswer = true;

                        }


                    }
                    else if ((DOB.getmonth()) > 9)
                    {

                        isanswer = true;

                    }


                }

            }
            else if ((DOB.getyear()) > 2004)
            {

                isanswer = true;

            }

        }
        return isanswer;


    }

    /*
     * ---------------------------------------------
     * validDOB:
     *
     * Returns true if the dateOfBirth is a valid
     * date and false otherwise.
     *
     * --------------------------------------------
     */

    public boolean ValidDOB()
    {

        Boolean answer;

        if ((DOB.dateIsValid()) == true)
        {

            answer = true;

        }
        else
        {

            answer = false;

        }

        return answer;

    }



    /*
     * ----------------------------------------------------
     * toString:
     *
     * returns a String representing the Student object
     * this method needs updating
     *
     * Use the toString method in the Date class to get
     * a string representation the student's date of birth.
     * ----------------------------------------------------
     */



    public String listTOstring(ArrayList <String> testInfo)
    {

        String delim = "\n" + "\t";

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < testInfo.size() - 1)
        {
            sb.append(testInfo.get(i));
            sb.append(delim);
            i++;
        }

        sb.append(testInfo.get(i));

        res = sb.toString();
        return res;

    }


    public String toString()
    {

        System.out.println("\n" + "\n" + "Output Screen for " + stuName);

        String StudInfo = "";

        String StudDOB = DOB.toString();

        float averRG = getaveRAGE();

        String gRADES = listTOstring(testInfo);

        String lgRADES = getLetterGrade(averRG);

        double stDV = getStandardDeviation();

        if (stDV == -1)
        {

            if (averRG == -1 )
            {

                StudInfo = ("\n" + "Name:" + stuName + "\n" + "\t" + "Date of Birth: " + StudDOB + "\n" + "Tests: " + "\n" + "\t" + "None" + "\n" + "\t" + "_________________________" + "\n" + "\t" + "Test Average: NETT" + "\n" + "\t" + "Letter Grade: " + lgRADES +  "\n" + "\t" + "Test Standard Deviation: NETT");


            }

            else
            {

                StudInfo = ("\n" + "Name:" + stuName + "\n" + "\t" + "Date of Birth: " + StudDOB + "\n" + "Tests: " + "\n" + "\t" + gRADES + "\n" + "\t" + "_________________________" + "\n" + "\t" + "Test Average: " + averRG + "\n" + "\t" + "Letter Grade: " + lgRADES +  "\n" + "\t" + "Test Standard Deviation: NETT");


            }


        }
        else
        {

            StudInfo = ("\n" + "Name:" + stuName + "\n" + "\t" + "Date of Birth: " + StudDOB + "\n" + "Tests:" + "\n" + "\t" + gRADES + "\n" + "\t" + "_________________________" + "\n" + "\t" + "Test Average: " + averRG + "\n" + "\t" + "Letter Grade: " + lgRADES + "\n" + "\t" + "Test Standard Deviation: " + stDV);

        }

        return StudInfo;


    }


}
/* end of class definition */