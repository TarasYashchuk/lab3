package Arena;

import Droids.Droid;

public class Foog implements Arena {
@Override
   public void modifyDroidsStats(Droid droid){
        droid.decreaseHealth(30);
    }

}
