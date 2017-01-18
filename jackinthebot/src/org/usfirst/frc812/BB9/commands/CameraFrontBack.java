package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CameraFrontBack extends CommandGroup {
    public static boolean forward = false;
    
    public boolean isRunning() {
    	return forward;
    }

    public void cancel() {
   		Robot.cameraControl.right();
    	Robot.cameraControl.levelRightTrim();
    	Robot.gyroSubsystem.showPosition();
    	System.out.println("CameraFrontBack rightTrim");
       	forward = false;
    }
    public void start() {
   		Robot.cameraControl.left();
    	Robot.cameraControl.levelLeftTrim();
    	System.out.println("CameraFrontBack leftTrim");
   		forward = true;
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
