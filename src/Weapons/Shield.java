package Weapons;

public class Shield implements DefenceWeapon{
    @Override
    public int getDamage(){
        return 10;
    }
    @Override
    public String getName(){
        return "Щит із шипами";
    }
}
