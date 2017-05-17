package org.usfirst.frc.team1155.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SwerveDriveSubsystem extends Subsystem {

	private int FWD, STR, RCW;
	// TODO: Update for robot's dimensions.
	private static final double LENGTH = 0;
	private static final double WIDTH = 0;
	private static final double DIAGONAL = Math.sqrt(LENGTH * LENGTH + WIDTH * WIDTH);
	private static double P, I, D;
	private WheelController frTalon, flTalon, blTalon, brTalon;
	private Encoder frEnc, flEnc, blEnc, brEnc;

	public SwerveDriveSubsystem() {
		// TODO: Find corresponding numbers for each talon.
		frTalon = new WheelController(P, I, D, 0, 1);
		flTalon = new WheelController(P, I, D, 2, 3);
		blTalon = new WheelController(P, I, D, 4, 5);
		brTalon = new WheelController(P, I, D, 6, 7);
		frEnc = new Encoder(0, 1);
		flEnc = new Encoder(2, 3);
		blEnc = new Encoder(4, 5);
		brEnc = new Encoder(6, 7);
		updateJoystickValues(0, 0, 0);
	}

	protected void initDefaultCommand() {

	}

	public int getFWD() {
		return FWD;
	}

	public int getSTR() {
		return STR;
	}

	public int getRCW() {
		return RCW;
	}

	public void updateJoystickValues(int f, int s, int r) {
		FWD = f;
		STR = s;
		RCW = r;
	}

	public void setPID(double pp, double ii, double dd) {
		P = pp;
		I = ii;
		D = dd;
	}

}
