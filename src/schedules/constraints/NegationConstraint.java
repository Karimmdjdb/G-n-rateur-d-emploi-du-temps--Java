package schedules.constraints;

import schedules.activities.Activity;
import java.util.Set;
import java.util.Map;

public class NegationConstraint implements Constraint
{
    private Constraint constraint;

    public NegationConstraint(Constraint _constraint)
    {
        constraint = _constraint;
    }

    public Set<Activity> getActivities()
    {
        return constraint.getActivities();
    }

    public boolean isSatisfied(Map<Activity, Integer> map)
    {
        return !constraint.isSatisfied(map);
    }
}