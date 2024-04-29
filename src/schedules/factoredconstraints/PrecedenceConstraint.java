package schedules.factoredconstraints;

//importation des classes
import schedules.activities.Activity;

public class PrecedenceConstraint extends BinaryConstraint
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