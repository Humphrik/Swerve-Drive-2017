package org.usfirst.frc.team1155.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SwerveDriveSubsystem extends Subsystem {

	private double FWD, STR, RCW;
	// TODO: Update for robot's dimensions.
	private static final double LENGTH = 0;
	private static final double WIDTH = 0;
	private static final double DIAGONAL = Math.sqrt(LENGTH * LENGTH + WIDTH * WIDTH);
	private static double P, I, D;
	public WheelController frTalon, flTalon, blTalon, brTalon;

	public SwerveDriveSubsystem() {
		// TODO: Find corresponding numbers for each talon.
		// TODO: Find ports.
		frTalon = new WheelController(P, I, D, 0, 1, 0, 1);
		flTalon = new WheelController(P, I, D, 2, 3, 2, 3);
		blTalon = new WheelController(P, I, D, 4, 5, 4, 5);
		brTalon = new WheelController(P, I, D, 6, 7, 6, 7);

		updateJoystickValues(0, 0, 0);
	}

	protected void initDefaultCommand() {

	}

	public double getFWD() {
		return FWD;
	}

	public double getSTR() {
		return STR;
	}

	public double getRCW() {
		return RCW;
	}


	public void setPID(double pp, double ii, double dd) {
		P = pp;
		I = ii;
		D = dd;
	}

	public void updateJoystickValues(double f, double s, double r) {
		// TODO Auto-generated method stub
		FWD = f;
		STR = s;
		RCW = r;
	}

}
