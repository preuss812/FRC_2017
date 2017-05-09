package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommandGroup extends CommandGroup {
	private double LeftCount= Robot.drivelineSubsystem.leftCounter.get() * (-1); // initialize current counter value
	private double RightCount= Robot.drivelineSubsystem.rightCounter.get() * (-1); AutonomousCommandGroup() {

		System.out.println("I am in AutonomousCommandGroup");

//		if (Robot.controlBoxSubsystem.isSwitchCenter()) {
//			double mspeed = 0.5;
//			int mdirection = 0;
//			double mseconds = 4; //1.6 before
//			System.out.println("switch is left, speed " + mspeed + ", curve " + mdirection + ", time " + mseconds);
//			addSequential(new DriveByTime(mspeed, mdirection, mseconds));
		
		

		if (Robot.controlBoxSubsystem.isSwitchCenter()) {
			System.out.println("switch is center, speed 0.4, curve 0, counterstop 10000");
			addSequential(new AccelByCounters(5000));
//			addSequential(new DriveByCounters(.25, 0, 4000));
//			addSequential(new DecelByCounters(.5, 0, 4000));
//			addSequential(new DriveByCounters(.5, 0, 4000));

			//turn to the side in order to get straight ahead of the peg
//			addSequential(new DriveByCounters(0.2, 0.2, 10000));
				//drive forward into the peg
//			addSequential(new DriveByCounters(0.2, 0, 10000));
		} else if (Robot.controlBoxSubsystem.isSwitchRight()) {
			System.out.println("switch is right, speed 0.5, curve 1, time 1 sec");
			addSequential(new DriveByTime(0.5, 0, 3.0));
			addSequential(new DriveByTime(0.5, 0.20, 1.5));
			addSequential(new DriveByTime(0.5, 0, 1.0));

		} else if (Robot.controlBoxSubsystem.isSwitchLeft()) {
			System.out.println("switch is left, speed 0.5, curve -1, time 1 sec");
			addSequential(new DriveByTime(0.5, 0, 3.0));
			addSequential(new DriveByTime(0.5, -0.20, 1.5));
			addSequential(new DriveByTime(0.5, 0, 1.0));
		}
	}
	// To run multiple commands at the same time,
	// use addParallel()
	// e.g. addParallel(new Command1());
	// addSequential(new Command2());
	// Command1 and Command2 will run in parallel.

	// A command group will require all of the subsystems that each member
	// would require.
	// e.g. if Command1 requires chassis, and Command2 requires arm,
	// a CommandGroup containing them would require both the chassis and the
	// arm.
}
