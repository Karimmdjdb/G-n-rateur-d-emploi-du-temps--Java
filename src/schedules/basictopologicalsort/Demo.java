package schedules.basictopologicalsort;

//importation des classes de test
import schedulestests.basictopologicalsort.TopologicalSorterTests;

public class Demo
{
    public static void main(String[] args)
    {
        boolean ok = true;
        TopologicalSorterTests tester = new TopologicalSorterTests();
        ok = ok && tester.testBruteForceSort();
        ok = ok && tester.testSchedule();
        ok = ok && tester.testLinearTimeSort();
        System.out.println(ok ? "All tests passed" : "At least one test failed");
    }
}