package schedules.constraints;


import schedules.activities.Activity;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;

public class DisjunctionConstraint implements Constraint
{
    private Constraint constraint,constraint2;

    public DisjunctionConstraint(Constraint _constraint, Constraint _constraint2)
    {
        constraint = _constraint;
        constraint2 = _constraint2;
    }

    public Set<Activity> getActivities()
    {
        Set<Activity> activities = new HashSet<Activity>();
        activities.addAll(constraint.getActivities());
        activities.addAll(constraint2.getActivities());
        return activities;
    }

    public boolean isSatisfied(Map<Activity, Integer> map)
    {
        return constraint.isSatisfied(map) || constraint2.isSatisfied(map);
    }
}