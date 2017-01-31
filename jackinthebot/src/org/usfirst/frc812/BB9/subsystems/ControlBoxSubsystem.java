package org.usfirst.frc812.BB9.subsystems;

import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;
import org.usfirst.frc812.BB9.commands.CameraFrontBack;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */


public class ControlBoxSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static final int CB1 = 2;
	public static final int CB2 = 4;
	public static final int CB3 = 8;
	public static final int CB4 = 16;
	public static final int CB5 = 32;
	public static final int CB6 = 64;
	public static final int CB7 = 128;

	public int flagBits = 0;
	
	Joystick cb = RobotMap.controlBox;
			
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void readBits() {
    	flagBits = 0;
    	for (int i = 1; i<=7; i++) {
    		if(cb.getRawButton(i)) {
    			flagBits |= 1 << i;
    		}
    	}
    }
    public boolean isSet(int flag) {
    	int flagMask = 1 << flag;
    	if( (flagBits & flagMask) == flagMask ) {
    		return true;
    	} else {
    		return false;
    	}
    }
    public void printBits() {
    	readBits();
    	System.out.println("ControlBox bits: " + Integer.toBinaryString(flagBits));
    	String prespace = "";
    	System.out.print("Switches: ");
    	for (int i = 1; i<=7; i++) {
    		System.out.print(prespace + i + "=" + (isSet(i) ? "on":"off"));
    		prespace = " ";
    	}
    	System.out.println("");
    	System.out.println("ControlBox pot 0:  " + getPotValue(0));
    	System.out.println("ControlBox pot 1:  " + getPotValue(1));
    	System.out.println("Intake position via switch sensor: " + (Robot.grabberSensorSubsystem.get() ? "In":"Out"));
    	System.out.println("Gyro angle: " + RobotMap.gyro.getAngle() );
    	System.out.println("Camera position: "+ (CameraFrontBack.forward ? "Front":"Back"));
    	double sonicmVolts = RobotMap.ultraSensor.getVoltage();
    	double sonicValue = RobotMap.ultraSensor.getValue();
    	System.out.println("Ultrasonic: mV=" + sonicmVolts + " d(cm)=" + sonicmVolts*4.9*1000.0 + " 12-bit value="+ sonicValue);
    	System.out.println("avg bits=" + RobotMap.ultraSensor.getAverageBits() + " LSBWeight=" + RobotMap.ultraSensor.getLSBWeight());
    	double potVolts = RobotMap.analogPot.getVoltage();
    	System.out.println("Pot: mV=" + potVolts + " d(cm)=" + potVolts*4.9*1000.0);
    	System.out.println("IMU Pitch:" + Robot.imu.getPitch() + " Yaw: " + Robot.imu.getYaw() + " Roll: " + Robot.imu.getRoll());
    	System.out.println("IMU Temp: " + Robot.imu.getTemperature() + " Bar: " + Robot.imu.getBarometricPressure());
    	System.out.println("LIDAR distance: " + Robot.lidar.getDistance());
    	//for ()
    	//System.out.println("Center X: " + Robot.centerX); // Determined by the GRIP pipeline
    }
    
    public double getPotValue(int axis) {
    	return cb.getRawAxis(axis);
    }

}

