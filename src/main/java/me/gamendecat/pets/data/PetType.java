package me.gamendecat.pets.data;

public enum PetType {
    common, Uncommon, Rare, Epic, Legendary, Mythical;

    public double getMulti() {
        switch(this) {
            case common:
                return 0.1;
            case Uncommon:
                return 0.2;
            case Rare:
                return 0.4;
            case Epic:
                return 0.8;
            case Legendary:
                return 1.2;
            case Mythical:
                return 2.0;
            default:
                return 0.0;
        }
    }
}
