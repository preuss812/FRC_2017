package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */


public class GrabberSensorSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
			
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public boolean get() {
    	return RobotMap.grabberSensor.get();
    }
    
    public void print() {
    	System.out.println("Grabber sensor status = " + get());
    }

}

