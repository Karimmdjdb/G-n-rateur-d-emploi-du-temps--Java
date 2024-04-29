package schedules.solvers;

//importation des tests
import schedulestests.solvers.TopologicalSorterTests;
import schedulestests.solvers.VerifierTests;
import java.util.Random;
import schedulestests.solvers.RandomSchedulerTests;

public class Demo
{
    public static void main(String[] args)
    {
        boolean ok = true;
        Random random = new Random();
        TopologicalSorterTests topologicalSortTester = new TopologicalSorterTests();
        ok = ok && topologicalSortTester.testBruteForceSort();
        ok = ok && topologicalSortTester.testSchedule();
        ok = ok && topologicalSortTester.testLinearTimeSort();
        VerifierTests verifierTester = new VerifierTests();
        ok = ok && verifierTester.testUnsatisfied();
        RandomSchedulerTests randomSchedulerTester = new RandomSchedulerTests(random);
        ok = ok && randomSchedulerTester.testGenerateSchedule();
        System.out.println(ok ? "All tests passed" : "At least one test failed");
    }
}