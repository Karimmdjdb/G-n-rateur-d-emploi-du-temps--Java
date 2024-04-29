package schedules.basictopologicalsort;

//importation des classes de collections
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
//importation des autres classes
import schedules.activities.Activity;
import schedules.basicconstraints.PrecedenceConstraint;

public class TopologicalSorter
{
    public TopologicalSorter(){}

    public ArrayList<Activity> bruteForceSort(HashSet<Activity> _activities, HashSet<PrecedenceConstraint> constraints)
    {
        HashSet<Activity> activities = new HashSet<Activity>(_activities);
        ArrayList<Activity> sorted = new ArrayList<Activity>();
        Activity available;
        boolean ok;

        while(!activities.isEmpty())
        {
            //recherche d'une activité disponible
            available = searchForAvailable(activities, constraints, sorted);

            //on continue le brute-forcing
            if(available == null)
            {
                return null;
            }
            else
            {
                sorted.add(available);
                activities.remove(available);
            }
        }
        return sorted;
    }

    private Activity searchForAvailable(HashSet<Activity> activities, HashSet<PrecedenceConstraint> constraints, ArrayList<Activity> sorted)
    {
        boolean ok;
        for(Activity activity : activities)
        {
            ok = true;
            for(PrecedenceConstraint constraint : constraints)
            {
                if(constraint.getSecond() == activity && !sorted.contains(constraint.getFirst()))
                {
                    ok = false;
                    break;
                }
            }
            if(ok) return activity;
        }
        return null;
    }

    public HashMap<Activity, Integer> schedule(HashSet<Activity> _activities, HashSet<PrecedenceConstraint> constraints, int start)
    {
        ArrayList<Activity> sortedActivities = bruteForceSort(_activities, constraints);
        HashMap<Activity, Integer> activitiesMap = new HashMap<Activity, Integer>();
        
        if(sortedActivities == null) return null;
        
        for(Activity activity : sortedActivities)
        {
            activitiesMap.put(activity, start);
            start += activity.getDuration();
        }
        return activitiesMap;
    }

    public ArrayList<Activity> linearTimeSort(HashSet<Activity> _activities, HashSet<PrecedenceConstraint> constraints)
    {
        HashMap<Activity, Integer> nbPredecessors = new HashMap<Activity, Integer>();
        HashMap<Activity, ArrayList<Activity>> successors = new HashMap<Activity, ArrayList<Activity>>();
        for(Activity activity : _activities)
        {
            nbPredecessors.put(activity, 0);
            successors.put(activity, new ArrayList<Activity>());
        }

        for(PrecedenceConstraint constraint : constraints)
        {
            nbPredecessors.put(constraint.getSecond(), nbPredecessors.get(constraint.getSecond())+1);
            successors.get(constraint.getFirst()).add(constraint.getSecond());
        }

        ArrayList<Activity> L = new ArrayList<Activity>();
        ArrayList<Activity> res = new ArrayList<Activity>();

        for(Activity activity : _activities)
        {
            if(nbPredecessors.get(activity) == 0) L.add(activity);
        }

        while(!L.isEmpty())
        {
            Activity activity = L.get(0);
            res.add(activity);
            L.remove(activity);

            for(Activity activity2 : successors.get(activity))
            {
                nbPredecessors.put(activity2, nbPredecessors.get(activity2)-1);
                if(nbPredecessors.get(activity2)==0) L.add(activity2);
            }
        }

        if(res.size() == _activities.size()) return res;
        return null;
    }
}