package schedules.activities;

//Importation des tests
import schedulestests.activities.ActivityTests;

public class Demo
{
    public static void main(String[] args)
    {
        //CODE RELATIF AUX TESTS AUTOMATIQUES
        boolean ok = true;
        ActivityTests activityTester = new ActivityTests();
        ok = ok && activityTester.testGetDescription();
        ok = ok && activityTester.testGetDuration();
        System.out.println(ok? "All tests passed" : "At least one test failed");
    }
}