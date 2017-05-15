package org.usfirst.frc.team1155.robot.subsystems;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class WheelController extends PIDSubsystem{

	private CANTalon talon;
	private int desiredAngle;
	
	public WheelController(double p, double i, double d, int talonNum) {
		super(p, i, d);
		talon = new CANTalon(talonNum);
		
	}

	
	//CODE FOR ADJUSTING BASED ON ENCODER TO BE IMPLEMENTED
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
	
	public CANTalon getTalon() {
		return talon;
	}
	
	public double getSpeed() {
		return talon.get();
	}
	
	
	public void setSpeed(double s) {
		talon.set(s);
	}

	public void setDesiredAngle(int theta) {
		desiredAngle = theta;
	}
}
