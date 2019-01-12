package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;

public class Claw {
	public enum ClawStates {
		OPENING, CLOSING, NOT_MOVING
	}

	ClawStates clawState;
	private Joystick manCon;
	private WPI_TalonSRX clawMotor;

	public Claw() {
		clawState = ClawStates.NOT_MOVING;
		manCon = new Joystick(Constants.MAN_CON_PORT);
		clawMotor = new WPI_TalonSRX(0);
	}

	public void clawMove() {
		switch (clawState) {
		case OPENING:
			if (manCon.getRawAxis(3) < 0.2 || manCon.getRawAxis(2) >= 0.2) {
				clawMotor.set(0);
				clawState = ClawStates.NOT_MOVING;
			}
			break;
		case CLOSING:
			if (manCon.getRawAxis(2) < 0.2 || manCon.getRawAxis(3) >= 0.2) {
				clawMotor.set(0);
				clawState = ClawStates.NOT_MOVING;
			}
			break;
		case NOT_MOVING:
			if (manCon.getRawAxis(2) >= 0.2 && manCon.getRawAxis(3) < 0.2) {
				clawMotor.set(-1.0);
				clawState = ClawStates.CLOSING;
			}
			if (manCon.getRawAxis(3) >= 0.2 && manCon.getRawAxis(2) < 0.2) {
				clawMotor.set(1.0);
				clawState = ClawStates.OPENING;
			}
			break;
		}
	}

	public WPI_TalonSRX getClawMotor() {
		return clawMotor;
	}
	
	

}
