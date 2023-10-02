package Weapons;

public class Bow implements RangeWeapon{
    @Override
    public int getDamage(){
        return 20;
    }
    @Override
    public String getName(){
        return "Лук";
    }
}
