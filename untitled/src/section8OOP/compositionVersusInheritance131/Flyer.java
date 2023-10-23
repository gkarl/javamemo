package section8OOP.compositionVersusInheritance131;

//__________3__________Extract Interface => On crée une interface à partir des methode présente dans la class Pilot
public interface Flyer {
    void fly();

    int getHoursFlows();

    void setHoursFlows(int hoursFlows);

    boolean isIfr();

    void setIfr(boolean ifr);
}
