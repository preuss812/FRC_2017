package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class CatapultDownCommand extends Command {

	public CatapultDownCommand() {
		requires(Robot.doubleShooterSubsystem);
		setTimeout(3.0);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		if ( !Robot.grabberSensorSubsystem.get() ){
			Robot.doubleShooterSubsystem.retractCatapult();
			end();		
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();

	}

}
