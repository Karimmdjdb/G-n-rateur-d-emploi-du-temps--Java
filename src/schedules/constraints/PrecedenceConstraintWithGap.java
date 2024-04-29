package schedules.constraints;

//importation des classes
import schedules.activities.Activity;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint  implements Constraint
{
    private int minTime, maxTime;
    
    public PrecedenceConstraintWithGap(Activity _first, Activity _second, int _minTime, int _maxTime)
    {
        super(_first, _second);
        minTime = _minTime;
        maxTime = _maxTime;
    }

    public boolean isSatisfied(int fTime, int sTime)
    {
        int finishTime = fTime + getFirst().getDuration();
        int gap = sTime - finishTime;
        return (finishTime <= sTime && gap <= maxTime && gap >= minTime);
    }
}