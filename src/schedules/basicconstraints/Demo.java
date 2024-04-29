package schedules.basicconstraints;

//importation des classes de test
import schedulestests.basicconstraints.PrecedenceConstraintTests;
import schedulestests.basicconstraints.MeetConstraintTests;
import schedulestests.basicconstraints.PrecedenceConstraintWithGapTests;

public class Demo
{
    public static void main(String[] args)
    {
        //CODE RELATIF AUX TESTS AUTOMATIQUES
        boolean ok = true;
        PrecedenceConstraintTests precedenceTester = new PrecedenceConstraintTests();
        ok = ok && precedenceTester.testGetFirst();
        ok = ok && precedenceTester.testGetSecond();
        ok = ok && precedenceTester.testIsSatisfiedBy();
        MeetConstraintTests meetTester = new MeetConstraintTests();
        ok = ok && meetTester.testGetFirst();
        ok = ok && meetTester.testGetSecond();
        ok = ok && meetTester.testIsSatisfiedBy();
        PrecedenceConstraintWithGapTests precedenceConstraintWithGapTester = new PrecedenceConstraintWithGapTests();
        ok = ok && precedenceConstraintWithGapTester.testExtends();
        ok = ok && precedenceConstraintWithGapTester.testGetFirst();
        ok = ok && precedenceConstraintWithGapTester.testGetSecond();
        ok = ok && precedenceConstraintWithGapTester.testIsSatisfiedBy();

        System.out.println(ok ? "All tests passed" : "At least one test failed");
    }
}