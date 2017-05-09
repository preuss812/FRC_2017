// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;
import org.usfirst.frc812.BB9.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {

	public double lastX, lastY;
	public boolean motionlock = false;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
   private final RobotDrive robotDrive = RobotMap.dtProductionRobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void takeJoystickInputs(Joystick left, Joystick right) {
    	//robotDrive41.tankDrive(left, right);
    //	robotDrive41.tankDrive(-left.getY(), -right.getY());
    	// 2016-01-21 - experimented and found that Arcade drive works better.
    	// The third parameter, squaredInputs, was not tried as true, so we should 
    	// drive test is next time.
    	
    	lastX = right.getX();
    	lastY = right.getY();
    	
    	robotDrive.arcadeDrive(-right.getY(), -right.getX(), true);
        if(Robot.controlBoxSubsystem.isSet(7)) {
      	  RobotMap.compressor.start();
        } else {
      	  RobotMap.compressor.stop();
        }
    }
    
    public void stop() {
    	//robotDrive.drive(0,0);
    	
    	System.out.println(">>>>>> Stop");
    	robotDrive.arcadeDrive(0,0,false);
//    	motionlock = true;
    }
    
    public void start() {
    	
    	System.out.println("<<<<<<< Start");
//    	if(motionlock == false){
        	robotDrive.arcadeDrive(0, 0, true);
//    	}
//    	else{
//    		motionlock = false;
//    	}
    }
    

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoysticks());
    }

	public void drive(double accel, int i) {
		// TODO Auto-generated method stub
		
	}
}

