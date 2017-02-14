package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearBoxSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	 DoubleSolenoid shifterSolenoid = RobotMap.shootLeft;
	
	 public DoubleSolenoid.Value getShooterState() {
		 DoubleSolenoid.Value leftValue = shifterSolenoid.get();
			 
		 switch (leftValue) {
	      case kOff:
	    	  System.out.println("shooter is OFF");
	        break;
	      case kForward:
	    	  System.out.println("shooter is Forward");
	        break;
	      case kReverse:
	    	  System.out.println("shooter is Reverse");
	        break;
	    }
		 return leftValue;
	 }
	 
	 public void shootersOff() {
	    	shifterSolenoid.set(DoubleSolenoid.Value.kOff);
	 }
    
	 
	public void lowgear() {   // set gear to low 
		shifterSolenoid.set(DoubleSolenoid.Value.kReverse);
		
	}
	public void highgear() { 
		shifterSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	 
    public void toggle() {
    	Encoder leftEncoder = Robot.drivelineSubsystem.getLeftEncoder();
    	Encoder rightEncoder = Robot.drivelineSubsystem.getRightEncoder();
    	System.out.println("Left encoder rate =" +leftEncoder.getRate());
    	System.out.println("Right encoder rate =" +rightEncoder.getRate());
    	
    	DoubleSolenoid.Value leftValue = shifterSolenoid.get();
    	
    	switch (leftValue) {
	      case kOff:
	    	  System.out.println("shooter is OFF");
	    	  shifterSolenoid.set(DoubleSolenoid.Value.kForward);
	        break;
	      case kForward:
	    	  System.out.println("shooter is Forward");
	    	  shifterSolenoid.set(DoubleSolenoid.Value.kReverse);
	        break;
	      case kReverse:
	    	  System.out.println("shooter is Reverse");
	    	  shifterSolenoid.set(DoubleSolenoid.Value.kForward);
	        break;
	    }
    
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

