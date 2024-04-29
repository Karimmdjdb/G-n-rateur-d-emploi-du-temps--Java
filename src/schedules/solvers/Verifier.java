package schedules.solvers;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import schedules.activities.Activity;
import schedules.constraints.Constraint;

public class Verifier
{
    private Set<Constraint> constraints;
    
    public Verifier(Set<Constraint> _constraints)
    {
        constraints = _constraints;
    }

    public Set<Constraint> unsatisfied(Map<Activity, Integer> activities)
    {
        Set<Constraint> unsatisfied_constraints = new HashSet<>();
        for(Constraint constraint : constraints)
        {
            if(!constraint.isSatisfied(activities)) unsatisfied_constraints.add(constraint);
        }
        return unsatisfied_constraints;
    }
}