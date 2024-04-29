package schedules.constraints;

import schedulestests.constraints.AbstractionTests;
import schedulestests.constraints.MaxSpanConstraintTests;
import schedulestests.constraints.MeetConstraintTests;
import schedulestests.constraints.PrecedenceConstraintTests;
import schedulestests.constraints.PrecedenceConstraintWithGapTests;
import schedulestests.constraints.UnaryConstraintTests;

import schedules.activities.Activity;
import java.util.HashMap;

public class Demo
{
    public static void main(String[] args)
    {
        Activity act = new Activity("manger", 1);
        Activity act2 = new Activity("bosser", 100);
        Activity act3 = new Activity("pause", 60);
        Activity act4 = new Activity("dormir", 500);
        UnaryConstraint cst = new UnaryConstraint(act, 0, 0);
        HashMap<Activity, Integer> set = new HashMap<Activity, Integer>();
        set.put(act, 0);
        set.put(act2, 0);
        set.put(act3, 0);
        set.put(act4, 0);
        System.out.println(cst.isSatisfied(set));

        boolean ok = true;
        // Precedence constraints
        PrecedenceConstraintTests precedenceConstraintTester
        = new PrecedenceConstraintTests();
        ok = ok && precedenceConstraintTester.testExtends();
        ok = ok && precedenceConstraintTester.testImplements();
        ok = ok && precedenceConstraintTester.testGetActivities();
        ok = ok && precedenceConstraintTester.testGetFirst();
        ok = ok && precedenceConstraintTester.testGetSecond();
        ok = ok && precedenceConstraintTester.testIsSatisfied();
        // Meet constraints
        MeetConstraintTests meetConstraintTester = new MeetConstraintTests();
        ok = ok && meetConstraintTester.testExtends();
        ok = ok && meetConstraintTester.testImplements();
        ok = ok && meetConstraintTester.testGetActivities();
        ok = ok && meetConstraintTester.testGetFirst();
        ok = ok && meetConstraintTester.testGetSecond();
        ok = ok && meetConstraintTester.testIsSatisfied();
        // Precedence constraints with gap
        PrecedenceConstraintWithGapTests precedenceConstraintWithGapTester
        = new PrecedenceConstraintWithGapTests();
        ok = ok && precedenceConstraintWithGapTester.testExtends();
        ok = ok && precedenceConstraintWithGapTester.testImplements();

        ok = ok && precedenceConstraintWithGapTester.testGetActivities();
        ok = ok && precedenceConstraintWithGapTester.testGetFirst();
        ok = ok && precedenceConstraintWithGapTester.testGetSecond();
        ok = ok && precedenceConstraintWithGapTester.testIsSatisfied();
        // Abstract class
        AbstractionTests abstractionTester = new AbstractionTests();
        ok = ok && abstractionTester.testImplements();
        ok = ok && abstractionTester.testGetActivities();
        ok = ok && abstractionTester.testIsSatisfied();
        // Unary constraints
        UnaryConstraintTests unaryConstraintTester = new UnaryConstraintTests();
        ok = ok && unaryConstraintTester.testImplements();
        ok = ok && unaryConstraintTester.testGetActivities();
        ok = ok && unaryConstraintTester.testIsSatisfied();
        // Max span constraints
        MaxSpanConstraintTests maxSpanConstraintTester = new MaxSpanConstraintTests();
        ok = ok && maxSpanConstraintTester.testImplements();
        ok = ok && maxSpanConstraintTester.testGetActivities();
        ok = ok && maxSpanConstraintTester.testIsSatisfied();
        System.out.println(ok ? "All tests passed" : "At least one test failed");
    }
}