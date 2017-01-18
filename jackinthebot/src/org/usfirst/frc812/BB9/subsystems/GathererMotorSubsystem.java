package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;
import org.usfirst.frc812.BB9.commands.GathererMotor;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GathererMotorSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new GathererMotor());
    }
    public void runMotors() {
    	Robot.controlBoxSubsystem.readBits();
    	if( ! Robot.controlBoxSubsystem.isSet(1) && Robot.controlBoxSubsystem.isSet(2)) {
    		stop();
    	}
    	if( Robot.controlBoxSubsystem.isSet(1) && Robot.controlBoxSubsystem.isSet(2) ) {
    		forward();
    	}
    	if( ! Robot.controlBoxSubsystem.isSet(1) && ! Robot.controlBoxSubsystem.isSet(2) ) {
    		reverse();
    	}

    }

    public void forward() {
    	RobotMap.gathererMotor.set((Robot.controlBoxSubsystem.getPotValue(0)+1)*0.4);
    }
    public void reverse() {
    	RobotMap.gathererMotor.set(-(Robot.controlBoxSubsystem.getPotValue(0)+1)*0.4);
    }
    public void stop() {
    	RobotMap.gathererMotor.set(0.0);
    }
    
}