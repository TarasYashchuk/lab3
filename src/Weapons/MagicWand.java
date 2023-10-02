package Weapons;

public class MagicWand implements MagicWeapon{
    @Override
    public int getDamage(){
        return 20;
    }
    @Override
    public String getName(){
        return "Чарівна палочка";
    }
}
