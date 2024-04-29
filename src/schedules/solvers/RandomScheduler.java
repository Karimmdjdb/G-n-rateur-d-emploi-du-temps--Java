package schedules.solvers;

import java.util.*;
import schedules.activities.Activity;
import schedules.constraints.Constraint;

public class RandomScheduler
{
    private java.util.Random random;

    public RandomScheduler(java.util.Random _random)
    {
        random = _random;
    }

    public Map<Activity, Integer> generateOneSchedule(Set<Activity> activities, int minDate, int maxDate)
    {
        Map<Activity, Integer> map = new HashMap<>();
        for(Activity activity : activities)
        {
            map.put(activity, maxDate != minDate ? random.nextInt(maxDate - minDate + 1) + minDate : minDate);
        }
        return map;
    }

    public Map<Activity, Integer> generateSchedule(Set<Activity> activities, Set<Constraint> constraints, int minDate, int maxDate, int nb)
    {
        Map<Activity, Integer> bestSchedule = null, newSchedule;
        int unsatisfied = Integer.MAX_VALUE;
        int size;
        Verifier verificator = new Verifier(constraints);
        for(int i=0; i<nb; i++)
        {
            newSchedule = generateOneSchedule(activities, minDate, maxDate);
            size = verificator.unsatisfied(newSchedule).size();
            if(size < unsatisfied)
            {
                unsatisfied = size;
                bestSchedule = newSchedule;
            }
        }
        return bestSchedule;
    }
}