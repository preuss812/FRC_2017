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
	 DoubleSolenoid shifterSolenoid = RobotMap.shifter;
	
	 public DoubleSolenoid.Value getShooterState() {
		 DoubleSolenoid.Value leftValue = shifterSolenoid.get();
			 
		 switch (leftValue) {
	      case kOff:
//	    	  System.out.println("robot is NOT MOVING!");
	        break;
	      case kForward: // kForward is high speed
//	   	  System.out.println("robot is going at high speed/low gear");
	        break;
	      case kReverse: // kReverse is low speed
//	      System.out.println("robot is going at low speed/high gear");
	        break;
	    }
		 return leftValue;
	 }
	 
	 public void shiftersOff() {
	    	shifterSolenoid.set(DoubleSolenoid.Value.kOff);
	 }
    
	 
	public void lowgear() {   // set gear to low 
		shifterSolenoid.set(DoubleSolenoid.Value.kReverse);
		
	}
	public void highgear() { 
		shifterSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	 
    public void toggle() {
    
    	DoubleSolenoid.Value leftValue = shifterSolenoid.get();
    	
    	switch (leftValue) {
	      case kOff:
	    	  System.out.println("shifter is OFF");
	    	  shifterSolenoid.set(DoubleSolenoid.Value.kForward);
	        break;
	      case kForward:
	    	  System.out.println("shifter is High Gear");
	    	  shifterSolenoid.set(DoubleSolenoid.Value.kReverse);
	        break;
	      case kReverse:
	    	  System.out.println("shifter is Low Gear");
	    	  shifterSolenoid.set(DoubleSolenoid.Value.kForward);
	        break;
	    }
    
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

