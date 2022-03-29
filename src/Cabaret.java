import java.util.ArrayList;

public class Cabaret {
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name)
    {
        this.name = name;
        performers = new ArrayList<Performer>();
    }

    public String getName()
    {
        return name;
    }

    public ArrayList getPerformers()
    {
        return performers;
    }

    public boolean addPerformer(Performer newPerformer)
    {
        if (performers.contains(newPerformer))
        {
            return false;
        }
        else
        {
            performers.add(newPerformer);
            return true;
        }
    }

    public boolean removePerformer(Performer remove)
    {
        if (performers.contains(remove)) {
            int index = performers.indexOf(remove);
            performers.remove(index);
            return true;
        }
        else
        {
            return false;
        }
    }

    public double averagePerformerAge()
    {
        double sum = 0.0;
        for (Performer performer : performers)
        {
            sum += performer.getAge();
        }
        return sum / performers.size();
    }

    public ArrayList performersOverAge (int years)
    {
        ArrayList<Performer> overAge = new ArrayList<Performer>();
        for (Performer performer: performers)
        {
            if (performer.getAge() >= years)
            {
                overAge.add(performer);
            }
        }
        return overAge;
    }

    public void groupRehearsal()
    {
        for (Performer performer : performers)
        {
            System.out.println("REHEARSAL CALL! " + performer.getName());
            if (performer instanceof Comedian)
            {
                ((Comedian) performer).rehearse(false);
            }
            else
            {

                performer.rehearse();
            }
        }
    }

    public void cabaretShow()
    {
        for (Performer performer : performers)
        {
            System.out.println("Welcome to the cabaret! Next act up… " + performer.getName());
            if (performer instanceof Dancer)
            {
                ((Dancer) performer).pirouette(2);
                performer.perform();
            }
            else 
            {
                performer.perform();
            }
        }
    }

}
