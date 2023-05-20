public class TestScore
{

    /*
     * ---------------------------------------------
     * Instance data :
     * ---------------------------------------------
     */
    private float studScore;
    private String testName;
    private Date takenOn;

    private int year, month, day;



    /*
     * ---------------------------------------------
     * Constructor :
     * ---------------------------------------------
     */

    public TestScore(String testName, float studScore, int year, int month, int day)
    {

        this.testName = testName;
        this.studScore = studScore;
        takenOn = new Date(year, month, day);

    }

    /*
     * ---------------------------------------------
     * Accessors :
     * ---------------------------------------------
     */


    public String getestName()
    {

        return testName;

    }

    public float getstudScore()
    {

        return studScore;

    }

    public Date gettakenOn()
    {

        return takenOn;

    }

    /*
     * ---------------------------------------------
     * Mutators :
     * ---------------------------------------------
     */

    public void setestName(String testName)
    {

        this.testName = testName;

    }

    public void setstudScore(float studScore)
    {

        this.studScore = studScore;

    }

    public void setakenOn(int y, int m, int d)
    {

        this.takenOn = new Date(y, m, d);

    }

    public String toString()
    {

        String ton = takenOn.toString();

        String scoreInfo = "";

        scoreInfo = ton + " " + testName + " " + studScore;

        return scoreInfo;

    }

}
