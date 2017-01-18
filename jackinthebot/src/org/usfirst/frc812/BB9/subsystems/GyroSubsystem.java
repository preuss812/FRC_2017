package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GyroSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private AnalogGyro gyro = RobotMap.gyro;
	private double kP = 0.07;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void showPosition() {
    	System.out.println("Gyro Angle: " + gyro.getAngle() +
		" Center: " + gyro.getCenter() + 
		" Rate: " + gyro.getRate());

    }
    public double get_kP() {
    	return kP;
    }
    public double calcCurve() {
    	double angle = gyro.getAngle();
    	double curve = angle * kP;
 //   	System.out.println("angle: " + angle + " curve: " + curve );
    	return curve;
    }
}

