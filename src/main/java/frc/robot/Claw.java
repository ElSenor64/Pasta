package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

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

	public void clawMove(double openClawTrigger, double closeClawTrigger) {
		switch (clawState) {
		case OPENING:
			if (openClawTrigger < 0.2 || closeRawTrigger >= 0.2) {
				clawMotor.set(0);
				clawState = ClawStates.NOT_MOVING;
			}
			break;
		case CLOSING:
			if (closeRawTrigger < 0.2 || openClawTrigger >= 0.2) {
				clawMotor.set(0);
				clawState = ClawStates.NOT_MOVING;
			}
			break;
		case NOT_MOVING:
			if (closeRawTrigger >= 0.2 && openRawTrigger < 0.2) {
				clawMotor.set(-1.0);
				clawState = ClawStates.CLOSING;
			}
			if (openRawTrigger >= 0.2 && closeRawTrigger < 0.2) {
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
