package schedules.factoredconstraints;

//importation des classes
import schedules.activities.Activity;

public abstract class BinaryConstraint
{
    private Activity activity1, activity2;

    public BinaryConstraint(Activity _act1, Activity _act2)
    {
        activity1 = _act1;
        activity2 = _act2;
    }

    public Activity getFirst()
    {
        return activity1;
    }

    public Activity getSecond()
    {
        return activity2;
    }

    public abstract boolean isSatisfied(int fTime, int sTime);
}