package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.OI;
import org.usfirst.frc.team1155.robot.Robot;
import org.usfirst.frc.team1155.robot.subsystems.SwerveDriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {
	private SwerveDriveSubsystem sds;
	private double[] wheelSpeeds;
	private double[] wheelAngles;

	public DriveCommand() {
		requires(Robot.swerveDriveSubsystem);
		// To keep things concise.
		sds = Robot.swerveDriveSubsystem;
		wheelSpeeds = new double[4];
		wheelAngles = new double[4];
	}

	public void execute() {
		Robot.swerveDriveSubsystem.updateJoystickValues(-OI.joystick.getY(), OI.joystick.getX(), OI.joystick.getZ());
		double temp = sds.getFWD() * Math.cos(Math.toRadians(sds.getAngle() % 360))
				+ sds.getSTR() * Math.sin(Math.toRadians(sds.getAngle() % 360));

		sds.setSTR(-sds.getFWD() * Math.sin(Math.toRadians(sds.getAngle() % 360))
				+ sds.getSTR() * Math.cos(Math.toRadians(sds.getAngle() % 360)));

		sds.setFWD(temp);

		/*
		 * The Order of the Wheels are: Top Right >> Bot Right >> Bot Left >>
		 * Top Left
		 */

		// Fancy math stuff nobody actually understands.
		double A, B, C, D;
		A = sds.getSTR() - sds.getRCW() * (sds.LENGTH / sds.DIAGONAL);
		B = sds.getSTR() + sds.getRCW() * (sds.LENGTH / sds.DIAGONAL);
		C = sds.getFWD() - sds.getRCW() * (sds.LENGTH / sds.DIAGONAL);
		D = sds.getFWD() + sds.getRCW() * (sds.LENGTH / sds.DIAGONAL);
		wheelSpeeds[0] = Math.sqrt(B * B + C * C);
		wheelAngles[0] = Math.atan2(B, C) * 180 / Math.PI;
		wheelSpeeds[1] = Math.sqrt(B * B + D * D);
		wheelAngles[1] = Math.atan2(B, D) * 180 / Math.PI;
		wheelSpeeds[2] = Math.sqrt(A * A + D * D);
		wheelAngles[2] = Math.atan2(A, D) * 180 / Math.PI;
		wheelSpeeds[3] = Math.sqrt(A * A + C * C);
		wheelAngles[3] = Math.atan2(A, C) * 180 / Math.PI;

		// Normalizes the wheel speeds so none are > 1.
		double max = wheelSpeeds[0];
		for (double speeds : wheelSpeeds)
			if (speeds > max)
				max = speeds;
		if (max > 1)
			for (int i = 0; i < wheelSpeeds.length; i++)
				wheelSpeeds[i] /= max;

		// Wheel speeds and angles set.
		sds.frTalon.setSpeed(wheelSpeeds[0]);
		sds.frTalon.startAdjustment(wheelAngles[0]);
		sds.brTalon.setSpeed(wheelSpeeds[1]);
		sds.brTalon.startAdjustment(wheelAngles[1]);
		sds.blTalon.setSpeed(wheelSpeeds[2]);
		sds.blTalon.startAdjustment(wheelAngles[2]);
		sds.blTalon.setSpeed(wheelSpeeds[3]);
		sds.flTalon.startAdjustment(wheelAngles[3]);
	}

	@Override
	protected boolean isFinished() {
		// As far as I know, this command should only be interrupted.

		return false;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void end() {
		sds.frTalon.disable();
		sds.frTalon.setSpeed(0);
		sds.brTalon.disable();
		sds.brTalon.setSpeed(0);
		sds.blTalon.disable();
		sds.blTalon.setSpeed(0);
		sds.flTalon.disable();
		sds.flTalon.setSpeed(0);
	}

	@Override
	protected void interrupted() {
		end();

	}

}
