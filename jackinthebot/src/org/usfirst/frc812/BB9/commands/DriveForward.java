package org.usfirst.frc812.BB9.commands;
import org.usfirst.frc812.BB9.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {

	public DriveForward() {
		requires(Robot.driveTrain);
		setTimeout(0.1);
	}
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
 //   	Robot.driveTrain.
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
