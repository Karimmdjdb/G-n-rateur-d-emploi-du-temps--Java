package schedules.constraints;

//importation des classes
import schedules.activities.Activity;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public abstract class BinaryConstraint implements Constraint
{
    private Activity activity1, activity2;

    public BinaryConstraint(Activity _act1, Activity _act2)
    {
        activity1 = _act1;
        activity2 = _act2;
    }

    public Activity getFirst()
    {
        return activity1;
    }

    public Activity getSecond()
    {
        return activity2;
    }

    public abstract boolean isSatisfied(int fTime, int sTime);

    public Set<Activity> getActivities()
    {
        Set<Activity> activities = new HashSet<>();
        activities.add(activity1);
        activities.add(activity2);
        return activities;
    }
    
    public boolean isSatisfied(Map<Activity, Integer> map)
    {
        return isSatisfied(map.get(activity1), map.get(activity2));
    }
}