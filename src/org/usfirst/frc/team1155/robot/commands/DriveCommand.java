package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.PortMap;
import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {
	Joystick joystick1 = new Joystick(PortMap.JOYSTICK_LEFT), joystick2 = new Joystick(PortMap.JOYSTICK_RIGHT);
	public DriveCommand() {
		requires(Robot.swerveDriveSubsystem);
	}

	public void execute() {
		Robot.swerveDriveSubsystem.updateJoystickValues(joystick1.getY(), joystick1.getX(), joystick2.getX());
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
