package schedules.factoredconstraints;

//importation des classes
import schedules.activities.Activity;

public class MeetConstraint extends BinaryConstraint
{

    public MeetConstraint(Activity _first, Activity _second)
    {
        super(_first, _second);
    }

    public boolean isSatisfied(int fTime, int sTime)
    {
        int finishTime = fTime + getFirst().getDuration();
        return finishTime == sTime;
    }
}