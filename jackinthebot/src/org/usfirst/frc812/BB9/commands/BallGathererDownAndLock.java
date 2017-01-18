package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class BallGathererDownAndLock extends Command {

	public BallGathererDownAndLock() {
		requires(Robot.ballGathererSubsystem);
		setTimeout(1.0);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		System.out.println("Putting the Ball Gatherer down");
		Robot.ballGathererSubsystem.down();
		Robot.ballGathererSubsystem.setMotionLock();
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
