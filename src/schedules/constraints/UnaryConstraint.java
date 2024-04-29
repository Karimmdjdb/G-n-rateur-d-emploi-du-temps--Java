package schedules.constraints;

import schedules.activities.Activity;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class UnaryConstraint implements Constraint
{
    private Activity activity;
    private int minDate, maxDate;

    public UnaryConstraint(Activity _activity, int _minDate, int _maxDate)
    {
        activity = _activity;
        minDate = _minDate;
        maxDate = _maxDate;
    }

    public Set<Activity> getActivities()
    {
        Set<Activity> activities = new HashSet<>();
        activities.add(activity);
        return activities;
    }
    public boolean isSatisfied(Map<Activity, Integer> map)
    {
        return map.containsKey(activity) && map.get(activity) >= minDate && map.get(activity) <= maxDate;
    }

    public String toString()
    {
        return "Contrainte unaire (activité = [" + activity + "], min = " + minDate + ", max = " + maxDate;
    }
}