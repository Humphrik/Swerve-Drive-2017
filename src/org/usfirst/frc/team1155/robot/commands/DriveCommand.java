package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.OI;
import org.usfirst.frc.team1155.robot.Robot;
import org.usfirst.frc.team1155.robot.subsystems.SwerveDriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {
	private SwerveDriveSubsystem sds;

	public DriveCommand() {
		requires(Robot.swerveDriveSubsystem);
		sds = Robot.swerveDriveSubsystem;
	}

	public void execute() {
		Robot.swerveDriveSubsystem.updateJoystickValues(-OI.joystick.getY(), OI.joystick.getX(), OI.joystick.getZ());
		double temp = sds.getFWD() * Math.cos(Math.toRadians(sds.getAngle() % 360))
				+ sds.getSTR() * Math.sin(Math.toRadians(sds.getAngle() % 360));
		sds.setSTR(-sds.getFWD() * Math.sin(Math.toRadians(sds.getAngle() % 360))
				+ sds.getSTR() * Math.cos(Math.toRadians(sds.getAngle() % 360)));
		sds.setFWD(temp);
		//Top Right >> Bot Right >> Bot Left >> Top Left
		
		double A, B, C, D;
		A = sds.getSTR() - sds.getRCW() * (sds.LENGTH/sds.DIAGONAL);
		B = sds.getSTR() + sds.getRCW() * (sds.LENGTH/sds.DIAGONAL);
		C = sds.getFWD() - sds.getRCW() * (sds.LENGTH/sds.DIAGONAL);
		D = sds.getFWD() + sds.getRCW() * (sds.LENGTH/sds.DIAGONAL);

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
