package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controllers {
    private Joystick manipulatorStick;
    private double openClawTrigger;
    private double closeClawTrigger;
    private double nomInp;

    public Controllers() {
        manipulatorStick = new Joystick(Constants.MAN_CON_PORT);
        
    }

    public void setControllerValues() {
        //Claw
        openClawTrigger = manipulatorStick.getRawAxis(Constants.OPEN_CLAW_TRIGGER);
        closeClawTrigger = manipulatorStick.getRawAxis(Constants.CLOSE_CLAW_TRIGGER);
        //Encompasser
        nomInp = manipulatorStick.getRawAxis(Constants.ENCOM_STICK_CHANL);

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
}