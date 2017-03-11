package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommandGroup extends CommandGroup {
    
public AutonomousCommandGroup() {
	
	System.out.println("I am in AutonomousCommandGroup");
	
    if( Robot.controlBoxSubsystem.isSwitchCenter() ) {
    	System.out.println("switch is left, speed 0.5, curve 0, time 3 sec");
    	addSequential(new DriveByTime(0.5, 0, 4.0) );
							
    } else if ( Robot.controlBoxSubsystem.isSwitchRight() ) {
    	System.out.println("switch is center, speed 0.5, curve 1, time 1 sec");
    	addSequential(new DriveByTime(0.5, 0, 3.0) );
    	addSequential(new DriveByTime(0.5, 1, 1.0) );
			
    } else if( Robot.controlBoxSubsystem.isSwitchLeft() ){
    	System.out.println("switch is right, speed 0.5, curve -1, time 1 sec");
    	addSequential(new DriveByTime(0.5,  0, 3.0) );
    	addSequential(new DriveByTime(0.5, -1, 1.0) );
    }
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
