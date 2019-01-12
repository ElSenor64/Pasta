package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controllers {
    private Joystick manipulatorStick;
    private double openClawTrigger;
    private double closeClawTrigger;

    public Controllers() {
        manipulatorStick = new Joystick(Constants.MAN_CON_PORT);
        
    }

    public void setControllerValues() {
        openClawTrigger = manipulatorStick.getRawAxis(Constants.OPEN_CLAW_TRIGGER);
        closeClawTrigger = manipulatorStick.getRawAxis(Constants.CLOSE_CLAW_TRIGGER);
    }

    public double getCloseClawTrigger() {
        return closeClawTrigger;
    }
}