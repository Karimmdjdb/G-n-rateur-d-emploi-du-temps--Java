package schedules.solvers;

//importation des classes de collections
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
//importation des autres classes
import schedules.activities.Activity;
import schedules.constraints.PrecedenceConstraint;

public class TopologicalSorter
{
    public TopologicalSorter()
    {
    }

    public List<Activity> bruteForceSort(Set<Activity> _activities, Set<PrecedenceConstraint> constraints)
    {
        Set<Activity> activities = new HashSet<Activity>(_activities);
        List<Activity> sorted = new ArrayList<Activity>();
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

    private Activity searchForAvailable(Set<Activity> activities, Set<PrecedenceConstraint> constraints, List<Activity> sorted)
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

    public Map<Activity, Integer> schedule(Set<Activity> _activities, Set<PrecedenceConstraint> constraints, int start)
    {
        List<Activity> sortedActivities = bruteForceSort(_activities, constraints);
        Map<Activity, Integer> activitiesMap = new HashMap<Activity, Integer>();
        
        if(sortedActivities == null) return null;
        
        for(Activity activity : sortedActivities)
        {
            activitiesMap.put(activity, start);
            start += activity.getDuration();
        }
        return activitiesMap;
    }

    public List<Activity> linearTimeSort(Set<Activity> _activities, Set<PrecedenceConstraint> constraints)
    {
        Map<Activity, Integer> nbPredecessors = new HashMap<Activity, Integer>();
        Map<Activity, List<Activity>> successors = new HashMap<Activity, List<Activity>>();
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

        List<Activity> L = new ArrayList<Activity>();
        List<Activity> res = new ArrayList<Activity>();

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