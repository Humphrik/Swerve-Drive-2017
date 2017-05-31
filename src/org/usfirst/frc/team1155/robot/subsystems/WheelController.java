package org.usfirst.frc.team1155.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class WheelController extends PIDSubsystem {

	private CANTalon driveTalon, turnTalon;
	private Encoder encoder;
	// TODO: Find wheel radius.
	public final int WHEEL_RADIUS = 2;

	public WheelController(double p, double i, double d, int driveMotor, int turnMotor, int e1, int e2) {
		super(p, i, d);
		driveTalon = new CANTalon(driveMotor);
		turnTalon = new CANTalon(turnMotor);
		encoder = new Encoder(e1, e2);

		getPIDController().setContinuous(true);
		getPIDController().setPercentTolerance(0.0);
		// Adjustments should not stop until told to.
	}

	// CODE FOR ADJUSTING BASED ON ENCODER TO BE IMPLEMENTED
	@Override
	protected double returnPIDInput() {
		return getEncValue();
	}

	@Override
	protected void usePIDOutput(double output) {
		output *= 0.5;
		turnTalon.set(output);
	}

	public void startAdjustment(double setPoint) {
		if (getPIDController().isEnabled())
			disable();
		// Note: setpoint, pre-calculation, is in degrees
		setPoint *= 1024.0 / 360;
		setPoint %= 1024;
		// Sets angle to corresponding reference angle.
		double current = getEncValue();
		setSetpoint((int) (((current - setPoint >= 0 ? 512 : -512) + current - setPoint) / 1024) * 1024 + setPoint);
		enable();
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

	public double getEncValue() {
		return encoder.get();
	}

	public void setSpeed(double s) {
		driveTalon.set(s);
	}

	public void resetEnc() {
		encoder.reset();
	}

}
