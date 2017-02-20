package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BallGatherer extends CommandGroup {
    private boolean started = false;
    
    public boolean isRunning() {
    	return started;
    }

    public void cancel() {
    	Robot.ballGathererSubsystem.down();
   		//Robot.grabberSensorSubsystem.print();
   		started = false;
    }
    public void start() {
   		Robot.ballGathererSubsystem.up();
   		//Robot.grabberSensorSubsystem.print();
       	started = true;
    }		
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
}
