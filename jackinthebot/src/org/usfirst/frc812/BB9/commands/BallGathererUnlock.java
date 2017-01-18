package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class BallGathererUnlock extends Command {

	public BallGathererUnlock() {
		requires(Robot.ballGathererSubsystem);
		setTimeout(0.1);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.ballGathererSubsystem.unsetMotionLock();
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
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();

	}

}
