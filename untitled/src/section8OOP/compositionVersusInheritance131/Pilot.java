package section8OOP.compositionVersusInheritance131;

/**
 * Rappel on souhaite que CEO puisse etre de type Employee mais également de type Pilot
 */
//__________0__________crée la class Pilot
//__________3__________clic D sur le nom de la class / Refactor / Extract Interface => On crée une interface à partir des methode présente dans la class Pilot
class Pilot implements Flyer {
    private int hoursFlows = 0;
    private boolean ifr = false;

    public Pilot(int hoursFlows, boolean ifr) {
        this.hoursFlows = hoursFlows;
        this.ifr = ifr;
    }

    @Override
    public void fly() {  // Il rajoute cette metode un Pilote peut voler
        System.out.println("Prepare for take off!");
    }

    @Override
    public int getHoursFlows() {
        return hoursFlows;
    }

    @Override
    public void setHoursFlows(int hoursFlows) {
        this.hoursFlows = hoursFlows;
    }

    @Override
    public boolean isIfr() {
        return ifr;
    }

    @Override
    public void setIfr(boolean ifr) {
        this.ifr = ifr;
    }
}
