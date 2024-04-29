package schedules.constraints;

import schedules.activities.Activity;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class MaxSpanConstraint implements Constraint
{
    private Set<Activity> activities;
    private int duration;

    public MaxSpanConstraint(Set<Activity> _activities, int _duration)
    {
        activities = _activities;
        duration = _duration;
    }

    public Set<Activity> getActivities()
    {
        return activities;
    }
    
    public boolean isSatisfied(Map<Activity, Integer> map)
    {
        if(activities.isEmpty()) return true;
        int min = Integer.MAX_VALUE, max = 0, start = 0, end = 0;
        for(Activity activity : activities)
        {
            start = map.get(activity);
            end = start + activity.getDuration();
            min = start < min ? start : min;
            max = end > max ? end : max;
        }
        return max - min <= duration;
    }

    public String toString()
    {
        return "Contrainte max span (durée = " + duration + ")";
    }
}