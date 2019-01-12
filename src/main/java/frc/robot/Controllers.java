package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controllers {
    private Joystick manipulatorStick;

    public Controllers() {
        manipulatorStick = new Joystick(Constants.MAN_CON_PORT);
        
    }
}