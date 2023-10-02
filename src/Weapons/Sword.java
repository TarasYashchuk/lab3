package Weapons;

public class Sword implements MeeleWeapon{
    @Override
    public int getDamage(){
        return 30;
    }
    @Override
    public String getName(){
        return "Меч";
    }
}
