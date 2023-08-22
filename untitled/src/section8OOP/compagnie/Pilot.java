package section8OOP.compagnie;

public class Pilot implements Flyer {

    private int hoursFlows = 0;
    private boolean ifr = false;

    public Pilot(int hoursFlows, boolean ifr) {
        this.hoursFlows = hoursFlows;
        this.ifr = ifr;
    }

    @Override
    public void fly() {
        System.out.println("Prepare for take off");
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
