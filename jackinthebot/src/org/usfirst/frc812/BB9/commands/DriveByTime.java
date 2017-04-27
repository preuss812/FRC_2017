package org.usfirst.frc812.BB9.commands;
import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.Command;



public class DriveByTime extends Command {
	private double Speed;
	private double Direction;
	private double Seconds;
	/*
	 * 
	 */
	public DriveByTime(double speed, double direction, double seconds) {
		requires(Robot.driveTrain);
		Speed = speed;
		Direction = direction;
		Seconds = seconds;
		setTimeout(Seconds);
		System.out.println("DriveByTime " + speed + " " + direction + " " + seconds );
	}
    protected void initialize() {
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("DriveByTime:execute " + Speed + " " + Direction);
    	RobotMap.dtProductionRobotDrive.drive(Speed, Direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
