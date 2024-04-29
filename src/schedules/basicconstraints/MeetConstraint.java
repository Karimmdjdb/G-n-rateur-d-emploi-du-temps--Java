package schedules.basicconstraints;

//importation des classes
import schedules.activities.Activity;

public class MeetConstraint
{
    private Activity first;
    private Activity second;

    public MeetConstraint(Activity _first, Activity _second)
    {
        first = _first;
        second = _second;
    }

    public Activity getFirst()
    {
        return first;
    }

    public Activity getSecond()
    {
        return second;
    }

    public boolean isSatisfied(int fTime, int sTime)
    {
        return fTime + first.getDuration() == sTime;
    }
}