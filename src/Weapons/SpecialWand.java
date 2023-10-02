package Weapons;

public class SpecialWand implements SpecialWeapon{
    @Override
    public int getDamage(){
        return 10;
    }
    @Override
    public String getName(){
        return "Магічна палка";
    }
}
