package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class ShootCommand extends Command {

	public ShootCommand() {
		System.out.println("ShootCommand");
		requires(Robot.doubleShooterSubsystem);
		setTimeout(1.0);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		System.out.println("---> ShootCommand.initialized");
		if ( !Robot.grabberSensorSubsystem.get() ){
			Robot.doubleShooterSubsystem.releaseCatapult();
		}
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.doubleShooterSubsystem.retractCatapult();
		System.out.println("----> ShootCommand.end");
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();

	}

}
