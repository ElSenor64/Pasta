package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class PoopScoop {
    public enum PooStates {
        IN, OUT
    }

    PooStates pooState;
    private Solenoid extractable;

    public PoopScoop() {
        extractable = new Solenoid(Constants.POOSCOO_SOL_PORT);
        initialize();
    }

    public void initialize() {
        pooState = PooStates.IN;
        extractable.set(false);
    }

    public void scoop(boolean doScoop) {
        switch(pooState){
            case IN:
                if(doScoop == true) {
                    extractable.set(true);
                    pooState = PooStates.OUT;
                }
                break;
            case OUT:
                if(doScoop == false) {
                    extractable.set(false);
                    pooState = PooStates.IN;
                }
                break;
        }
    }
}