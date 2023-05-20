public class Date
{

    /*
     * ---------------------------------------------
     * Instance data :
     * ---------------------------------------------
     */
    private int year, month, day;
    private String mnth;


    /*
     * ---------------------------------------------
     * Constructor :
     * ---------------------------------------------
     */

    public Date(int y, int m, int d)
    {
        year = y;
        month = m;
        day = d;
    }

    /*
     * ---------------------------------------------
     * Accessors :
     * ---------------------------------------------
     */

    public int getyear()
    {

        return year;

    }

    public int getmonth()
    {

        return month;

    }

    public String getmnth()
    {

        return mnth;

    }

    public int getday()
    {

        return day;

    }


    /*
     * ---------------------------------------------
     * dateIsValid :
     *
     * check if the year, month, and day values passed
     * to it can be used to create a valid date and
     * returns true if the condition can be satisfied
     * and false otherwise.
     *
     * To validate the date:
     * 1. check to see if month is valid
     * 2. check to see if year is valid
     * 3. determine whether it's a leap year
     * 4. determine number of days in month
     * 5. User number of days in month to check to see
     * if day is valid
     * 6. Determine whether date is valid and return
     * an appropriate value
     * --------------------------------------------
     */

    public boolean dateIsValid()
    {

        if ((month >= 1 && month <= 12) && (day >= 1 && day <= 31) && (year >= 1910 && year <= 2022))
        {

            return true;

        }
        else
        {

            return false;
        }


    }

    public boolean isLeapYear()
    {


        if ((year % 400) == 0)
        {

            return true;

        }
        else if (((year % 4) == 0) && ((year % 100) != 0))
        {

            return true;

        }
        else
        {

            return false;

        }


    }

    public boolean isValidDay (int month, int day, int year)
    {

        boolean leap = isLeapYear();

        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8  || month == 10) && ((day <= 31) && (day >= 1)))
        {

            return true;

        }
        else if ((month == 4 || month == 6 || month == 9 || month == 11) && ((day <= 30) && (day >= 1)))
        {

            return true;

        }
        else if ((month == 2) && (!leap) && ((day <= 28) && (day >= 1)))
        {

            return true;

        }
        else if ((month == 2) && (leap) && ((day <= 29) && (day >= 1)))
        {

            return true;

        }
        else
        {

            return false;

        }


    }

    /*
     *
     * ---------------------------------------------
     * difference:
     *
     * returns the difference in years
     * between the dates that are passed in
     * -----------------------------------------
     */

    public static int difference (Date fromDate, Date toDate)
    {

        if (fromDate.dateIsValid() && toDate.dateIsValid())
        {

            return (toDate.year - fromDate.year);

        }
        else
        {

            return (-1);

        }

    }

    public String mts(int month)
    {

        switch (this.month)
        {


            case 1:
                mnth = "January";
                break;

            case 2:
                mnth = "February";
                break;

            case 3:
                mnth = "March";
                break;

            case 4:
                mnth = "April";
                break;
            case 5:
                mnth = "May";
                break;
            case 6:
                mnth = "June";
                break;

            case 7:
                mnth = "July";
                break;

            case 8:
                mnth = "August";
                break;

            case 9:
                mnth = "September";
                break;

            case 10:
                mnth = "October";
                break;

            case 11:
                mnth = "November";
                break;

            case 12:
                mnth = "December";
                break;

        }
        return mnth;

    }

    /*
     * ---------------------------------------------
     * Don't forget to add a toString Method in this
     * class
     * ---------------------------------------------
     */

    public String toString()
    {

        String mth = mts(month);

        String dATE = (mth + " " + day + ", " + year);

        return dATE;

    }




}