package schedules.constraints;

//importation des classes
import schedules.activities.Activity;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class PrecedenceConstraint extends BinaryConstraint  implements Constraint
{
    public PrecedenceConstraint(Activity _first, Activity _second)
    {
        super(_first, _second);
    }

    public boolean isSatisfied(int fTime, int sTime)
    {
        int finishTime = fTime + getFirst().getDuration();
        return finishTime <= sTime;
    }
}