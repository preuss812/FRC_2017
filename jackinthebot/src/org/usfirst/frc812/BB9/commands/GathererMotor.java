package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc812.BB9.subsystems.ControlBoxSubsystem;

/**
 *
 */
public class GathererMotor extends Command {

    public GathererMotor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gathererMotorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gathererMotorSubsystem.runMotors();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gathererMotorSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
