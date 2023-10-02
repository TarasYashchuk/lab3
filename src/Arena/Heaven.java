package Arena;

import Droids.Droid;

public class Heaven implements Arena {
    @Override
    public void modifyDroidsStats(Droid droid){
        droid.increaseHealth(30);
    }
}
