package org.usfirst.frc812.BB9.subsystems;

import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;
import org.usfirst.frc812.BB9.commands.CameraFrontBack;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
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
    	/*System.out.println("ControlBox bits: " + Integer.toBinaryString(flagBits));
    	String prespace = "";
    	System.out.print("Switches: ");
    	for (int i = 1; i<=7; i++) {
    		System.out.print(prespace + i + "=" + (isSet(i) ? "on":"off"));
    		prespace = " ";
    	*/
    	//}
    	
    	System.out.println("");
    	//System.out.println("Intake position via switch sensor: " + (Robot.grabberSensorSubsystem.get() ? "In":"Out"));
//    	System.out.println("Gyro angle: " + RobotMap.gyro.getAngle() );
    	System.out.println("Camera position: "+ (CameraFrontBack.forward ? "Front":"Back"));
//    	double sonicmVolts = RobotMap.ultraSensor.getVoltage();
//    	double sonicValue = RobotMap.ultraSensor.getValue();
//    	System.out.println("Ultrasonic: mV=" + sonicmVolts + " d(cm)=" + sonicmVolts*4.9*1000.0 + " 12-bit value="+ sonicValue);
//    	System.out.println("avg bits=" + RobotMap.ultraSensor.getAverageBits() + " LSBWeight=" + RobotMap.ultraSensor.getLSBWeight());
//    	double potVolts = RobotMap.analogPot.getVoltage();
//    	System.out.println("Pot: mV=" + potVolts + " d(cm)=" + potVolts*4.9*1000.0);
    	System.out.println("IMU Pitch:" + Robot.imu.getPitch() + " Yaw: " + Robot.imu.getYaw() + " Roll: " + Robot.imu.getRoll());
    	System.out.println("IMU Temp: " + Robot.imu.getTemperature() + " Bar: " + Robot.imu.getBarometricPressure());
//    	System.out.println("LIDAR distance: " + Robot.slidar.getDistance());

    	
    	
    	//for ()
    	//System.out.println("Center X: " + Robot.centerX); // Determined by the GRIP pipeline
    	

    	Robot.imu.getRateX();
        System.out.println("Rate: " + Robot.imu.getRate());  
        System.out.println("Rate x: " + Robot.imu.getRateX()); 
        System.out.println("Rate y: " + Robot.imu.getRateY());
        System.out.println("Rate z: " + Robot.imu.getRateZ());
    	
        // Encoder readings
//        System.out.println("------------------------------------");
//        System.out.println("Left Wheel");
//    	Encoder leftWheelEncoder = Robot.drivelineSubsystem.getLeftEncoder();
//    	Encoder rightWheelEncoder = Robot.drivelineSubsystem.getRightEncoder();
//		System.out.println("  dir: "+leftWheelEncoder.getDirection()+", dist: " + leftWheelEncoder.getDistance()+ ", rate: "+leftWheelEncoder.getRate());
//    	System.out.println("Right Wheel");
//		System.out.println("  dir: "+rightWheelEncoder.getDirection()+", dist: " + rightWheelEncoder.getDistance()+ ", rate: "+rightWheelEncoder.getRate());
   

    	System.out.println("ControlBox pot 0:  " + getPotValue(0));
    	System.out.println("ControlBox pot 1:  " + getPotValue(1));

    	//System.out.println("control box 2:" + getPotValue(2));

		System.out.println("gear switch Button 4:" + cb.getRawButton(4));

        
    	/*System.out.println(x);
    	Robot.imu.getBarometricPressure();
    	System.out.println(x);
    	Robot.imu.getRoll();
    	System.out.println(x);
    	*/
		
//
//    	System.out.println("Right encoder:");
//    	System.out.println("  count =" +Robot.drivelineSubsystem.getRightEncoder().get());
//		System.out.println("  rate =" +Robot.drivelineSubsystem.getRightEncoder().getRate());
//    	System.out.println("  stopped =" +Robot.drivelineSubsystem.getRightEncoder().getStopped());
//    	System.out.println("  direction =" +Robot.drivelineSubsystem.getRightEncoder().getDirection());
//    	System.out.println("  distance =" +Robot.drivelineSubsystem.getRightEncoder().getDistance());
//    	
//    	
//		System.out.println("Left encoder:");	
//		System.out.println("  count =" +Robot.drivelineSubsystem.getLeftEncoder().get());
//		System.out.println("  rate =" +Robot.drivelineSubsystem.getLeftEncoder().getRate());
//    	System.out.println("  stopped =" +Robot.drivelineSubsystem.getLeftEncoder().getStopped());
//    	System.out.println("  direction =" +Robot.drivelineSubsystem.getLeftEncoder().getDirection());
//    	System.out.println("  distance =" +Robot.drivelineSubsystem.getLeftEncoder().getDistance());


    	System.out.println("  counter L =" +Robot.drivelineSubsystem.leftCounter.get());
    	System.out.println("  counter R =" +Robot.drivelineSubsystem.rightCounter.get());
		//System.out.println("  counter R =" +Robot.drivelineSubsystem.rightCounter.())
    	System.out.println("Distance per pulse: " + Robot.drivelineSubsystem.distancePerPulse);
    	System.out.println("  rate R =" +Robot.drivelineSubsystem.rightCounter.getRate());
    	System.out.println("  rate L =" +Robot.drivelineSubsystem.leftCounter.getRate());
    	//double distancePerPulse;
		//System.out.println("Distance per pulse: " + Robot.drivelineSubsystem.distancePerPulse);
    	
    	
    	// climbing limit switches
    	System.out.println("Climber limit switches: " + RobotMap.climberSensor.get());
    }
    
    public double getPotValue(int axis) {
    	return cb.getRawAxis(axis);
    }

}

