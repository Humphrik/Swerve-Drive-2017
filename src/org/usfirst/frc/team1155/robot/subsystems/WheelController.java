package org.usfirst.frc.team1155.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class WheelController extends PIDSubsystem {

	private CANTalon driveTalon, turnTalon;
	private int desiredAngle;

	public WheelController(double p, double i, double d, int driveMotor, int turnMotor) {
		super(p, i, d);
		driveTalon = new CANTalon(driveMotor);
		turnTalon = new CANTalon(turnMotor);
	}

	// CODE FOR ADJUSTING BASED ON ENCODER TO BE IMPLEMENTED
	@Override
	protected double returnPIDInput() {
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {

	}

	@Override
	protected void initDefaultCommand() {

	}

	public CANTalon getDriveTalon() {
		return driveTalon;
	}

	public CANTalon getTurnTalon() {
		return turnTalon;
	}

	public double getSpeed() {
		return driveTalon.get();
	}

	public void setSpeed(double s) {
		driveTalon.set(s);
	}

	public void setDesiredAngle(int theta) {
		desiredAngle = theta;
	}
}
