package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



public class Claw {
	public enum ClawStates {
		OPENING, CLOSING, NOT_MOVING
	}

	ClawStates clawState;
	private WPI_TalonSRX clawMotor;

	public Claw() {
		clawMotor = new WPI_TalonSRX(0);
		initialize();
	}

	public void initialize() {
		clawState = ClawStates.NOT_MOVING;
		clawMotor.set(0);
	}

	public void clawMove(double openClawTrigger, double closeClawTrigger) {
		switch (clawState) {
		case OPENING:
			if (openClawTrigger < 0.2 || closeClawTrigger >= 0.2) {
				clawMotor.set(0);
				clawState = ClawStates.NOT_MOVING;
			}
			break;
		case CLOSING:
			if (closeClawTrigger < 0.2 || openClawTrigger >= 0.2) {
				clawMotor.set(0);
				clawState = ClawStates.NOT_MOVING;
			}
			break;
		case NOT_MOVING:
			if (closeClawTrigger >= 0.2 && openClawTrigger < 0.2) {
				clawMotor.set(-1.0);
				clawState = ClawStates.CLOSING;
			}
			if (openClawTrigger >= 0.2 && closeClawTrigger < 0.2) {
				clawMotor.set(1.0);
				clawState = ClawStates.OPENING;
			}
			break;
		}
	}
	

}
