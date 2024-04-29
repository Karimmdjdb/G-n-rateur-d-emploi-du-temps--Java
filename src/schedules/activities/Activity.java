package schedules.activities;

public class Activity
{
    private String description;
    private int duration;

    public Activity(String _description, int _duration)
    {
        description = _description;
        duration = _duration;
    }

    public String getDescription()
    {
        return description;
    }

    public int getDuration()
    {
        return duration;
    }

    public String toString()
    {
        return "Description : " + description + ", Durée : " + duration + "\n";
    }
}