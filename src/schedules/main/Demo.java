package schedules.main;

//importations des classes du projet
import schedules.activities.Activity;
import schedules.basicconstraints.*;
import schedules.basictopologicalsort.*;
//importation des classes de collection
import java.util.HashSet;
import java.util.Arrays;

public class Demo
{
    public static void main(String[] args)
    {
        ////CODE RELATIF AUX TESTS PERSONNELS
        Activity a1 = new Activity("Aller à la fac", 200);
        Activity a2 = new Activity("Aller travailler", 250);
        Activity a3 = new Activity("Rentrer à la maison", 50);
        PrecedenceConstraint pc1 = new PrecedenceConstraint(a1, a2);
        PrecedenceConstraint pc2 = new PrecedenceConstraint(a2, a3);
        MeetConstraint mc1 = new MeetConstraint(a1, a2);
        PrecedenceConstraintWithGap pcg1 = new PrecedenceConstraintWithGap(a1,a2, 20, 100);
        System.out.println(pc1.isSatisfied(500, 800));
        System.out.println(pc1.isSatisfied(500, 700));
        System.out.println(pc1.isSatisfied(500, 600));
        System.out.println(mc1.isSatisfied(500, 800));
        System.out.println(mc1.isSatisfied(500, 700));
        System.out.println(mc1.isSatisfied(500, 600));
        System.out.println(pcg1.isSatisfied(500, 900));
        System.out.println(pcg1.isSatisfied(500, 800));
        System.out.println(pcg1.isSatisfied(500, 700));
        TopologicalSorter ts1 = new TopologicalSorter();
        HashSet<Activity> aSet = new HashSet<Activity>(Arrays.asList(new Activity[]{a2,a3, a1}));
        HashSet<PrecedenceConstraint> cSet = new HashSet<PrecedenceConstraint>(Arrays.asList(new PrecedenceConstraint[]{pc2, pc1}));
        System.out.println(ts1.bruteForceSort(aSet, cSet));



        ////CODE RELATIF AUX TESTS AUTOMATIQUES FOURNIS
        boolean ok = true;

        ///Partie activités
        schedulestests.activities.ActivityTests activityTester = new schedulestests.activities.ActivityTests();
        ok = ok && activityTester.testGetDescription();
        ok = ok && activityTester.testGetDuration();

        ///Partie contraintes
        schedulestests.basicconstraints.PrecedenceConstraintTests precedenceTester = new schedulestests.basicconstraints.PrecedenceConstraintTests();
        ok = ok && precedenceTester.testGetFirst();
        ok = ok && precedenceTester.testGetSecond();
        ok = ok && precedenceTester.testIsSatisfiedBy();
        schedulestests.basicconstraints.MeetConstraintTests meetTester = new schedulestests.basicconstraints.MeetConstraintTests();
        ok = ok && meetTester.testGetFirst();
        ok = ok && meetTester.testGetSecond();
        ok = ok && meetTester.testIsSatisfiedBy();
        schedulestests.basicconstraints.PrecedenceConstraintWithGapTests precedenceConstraintWithGapTester = new schedulestests.basicconstraints.PrecedenceConstraintWithGapTests();
        ok = ok && precedenceConstraintWithGapTester.testExtends();
        ok = ok && precedenceConstraintWithGapTester.testGetFirst();
        ok = ok && precedenceConstraintWithGapTester.testGetSecond();
        ok = ok && precedenceConstraintWithGapTester.testIsSatisfiedBy();

        ///Partie tri
        schedulestests.basictopologicalsort.TopologicalSorterTests sortTester = new schedulestests.basictopologicalsort.TopologicalSorterTests();
        ok = ok && sortTester.testBruteForceSort();
        ok = ok && sortTester.testSchedule();
        ok = ok && sortTester.testLinearTimeSort();

        ///Partie contraintes factorisée
        // Precedence constraints
        schedulestests.factoredconstraints.PrecedenceConstraintTests precedenceConstraintTester
        = new schedulestests.factoredconstraints.PrecedenceConstraintTests();
        ok = ok && precedenceConstraintTester.testGetFirst();
        ok = ok && precedenceConstraintTester.testGetSecond();
        ok = ok && precedenceConstraintTester.testExtends();
        ok = ok && precedenceConstraintTester.testIsSatisfiedBy();
        // Meet constraints
        schedulestests.factoredconstraints.MeetConstraintTests meetConstraintTester = new schedulestests.factoredconstraints.MeetConstraintTests();
        ok = ok && meetConstraintTester.testGetFirst();
        ok = ok && meetConstraintTester.testGetSecond();
        ok = ok && meetConstraintTester.testExtends();
        ok = ok && meetConstraintTester.testIsSatisfiedBy();
        // Precedence constraints with gap
        schedulestests.factoredconstraints.PrecedenceConstraintWithGapTests factPrecedenceConstraintWithGapTester
        = new schedulestests.factoredconstraints.PrecedenceConstraintWithGapTests();
        ok = ok && factPrecedenceConstraintWithGapTester.testExtends();
        ok = ok && factPrecedenceConstraintWithGapTester.testGetFirst();
        ok = ok && factPrecedenceConstraintWithGapTester.testGetSecond();
        ok = ok && factPrecedenceConstraintWithGapTester.testIsSatisfiedBy();
        // Abstract class
        schedulestests.factoredconstraints.AbstractionTests abstracttionTester = new schedulestests.factoredconstraints.AbstractionTests();
        ok = ok && abstracttionTester.test();

        ///Partie tri factorisée
        schedulestests.factoredtopologicalsort.TopologicalSorterTests factSortTester = new schedulestests.factoredtopologicalsort.TopologicalSorterTests();
        ok = ok && factSortTester.testBruteForceSort();
        ok = ok && factSortTester.testSchedule();
        ok = ok && factSortTester.testLinearTimeSort();
        
        ///Affichage du resultat
        System.out.println(ok? "All tests passed" : "At least one test failed");
    }
}