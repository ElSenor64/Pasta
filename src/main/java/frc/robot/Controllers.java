package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controllers {
    private Joystick manipulatorStick;
    private double openClawTrigger;
    private double closeClawTrigger;
    private double nomInp;
    private boolean scoopUp;
    private boolean scoopDn;
    private boolean doScoop;

    public Controllers() {
        manipulatorStick = new Joystick(Constants.MAN_CON_PORT);
        
    }

    public void setControllerValues() {
        //Claw
        openClawTrigger = manipulatorStick.getRawAxis(Constants.OPEN_CLAW_TRIGGER);
        closeClawTrigger = manipulatorStick.getRawAxis(Constants.CLOSE_CLAW_TRIGGER);

        //Encompasser
        nomInp = manipulatorStick.getRawAxis(Constants.ENCOM_STICK_CHANL);

        //Poop Scoop
        scoopUp = manipulatorStick.getRawButton(Constants.POOSCOO_UPCHNL);
        scoopDn = manipulatorStick.getRawButton(Constants.POOSCOO_DNCHNL);

        if(scoopUp && !scoopDn) {
            doScoop = false;
        }else if(scoopDn && !scoopUp) {
            doScoop = true;
        }
    }

    public double getCloseClawTrigger() {
        return closeClawTrigger;
    }

    public double getOpenClawTrigger() {
        return openClawTrigger;
    }

    public double getNomInp() {
        return nomInp;
    }

    public boolean isDoScoop() {
        return doScoop;
    }
}