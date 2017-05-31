package org.usfirst.frc.team1155.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class SwerveDriveSubsystem extends Subsystem {

	private double FWD, STR, RCW;
	// TODO: Update for robot's dimensions.
	public final double LENGTH = 0;
	public final double WIDTH = 0;
	public final double DIAGONAL = Math.sqrt(LENGTH * LENGTH + WIDTH * WIDTH);
	private static double P, I, D;
	public WheelController frTalon, flTalon, blTalon, brTalon;

	// TODO: Convert this to ADXRS450_GYRO
	private Gyro gyro;

	public SwerveDriveSubsystem() {
		// TODO: Find corresponding numbers for each talon.
		// TODO: Find encoder ports.
		frTalon = new WheelController(P, I, D, 0, 1, 0, 1);
		flTalon = new WheelController(P, I, D, 2, 3, 2, 3);
		blTalon = new WheelController(P, I, D, 4, 5, 4, 5);
		brTalon = new WheelController(P, I, D, 6, 7, 6, 7);

		// TODO: Make this a ADXRS450_Gyro
		gyro = new AnalogGyro(0);
		updateJoystickValues(0, 0, 0);
	}

	protected void initDefaultCommand() {

	}

	public WheelController getWheelController(int i) {
		switch(i) {
		case 0:
			return frTalon;
		case 1:
			return brTalon;
		case 2:
			return blTalon;
		default:
			return flTalon;
		}
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

	public double getAngle() {
		return gyro.getAngle();
	}

	public void setFWD(double f) {
		FWD = f;
	}

	public void setSTR(double s) {
		STR = s;
	}

	public void setRCW(double r) {
		RCW = r;
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
