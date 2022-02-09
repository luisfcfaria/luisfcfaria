package academy.mindswap;

import academy.mindswap.Fruits.*;

import java.util.*;

public class DupeFinder<T> {

    private Collection<T> getDupes;

    public DupeFinder(Collection<T> getDupes) {
        this.getDupes = getDupes;
    }

    public int getDupes() {
        Set<T> setOfNames = new HashSet<>(this.getDupes);
        return this.getDupes.size()-setOfNames.size();
    }

    public List<T> listDupes(){
        Set<T> setOfNames = new HashSet<>(this.getDupes);
        ArrayList<T> list = new ArrayList<>(this.getDupes);

        for (T o: setOfNames) {
            list.remove(o);
        }
        return list;
    }


}

