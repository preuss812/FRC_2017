package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DoubleShooterSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	 DoubleSolenoid shooterLeft = RobotMap.shootLeft;
	 DoubleSolenoid shooterRight = RobotMap.shootRight;

	
	 public DoubleSolenoid.Value getShooterState() {
		 DoubleSolenoid.Value leftValue = shooterLeft.get();
		 DoubleSolenoid.Value rightValue = shooterRight.get();
		 if ( leftValue != rightValue) {
			System.out.println("The left/right shooters dont match! " +
		                       "left: " + leftValue + " right: " + rightValue);
			throw new Error();
		 }
			 
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
	    	shooterLeft.set(DoubleSolenoid.Value.kOff);
	    	shooterRight.set(DoubleSolenoid.Value.kOff);
	 }
    public void releaseCatapult() {
    	shooterLeft.set(DoubleSolenoid.Value.kReverse);
    	shooterRight.set(DoubleSolenoid.Value.kReverse);
    	System.out.println("releaseCatapult");
    }

    public void retractCatapult() {
    	shooterLeft.set(DoubleSolenoid.Value.kForward);
    	shooterRight.set(DoubleSolenoid.Value.kForward);
    	System.out.println("retractCatapult");
    }
    
    public void toggle() {
    	DoubleSolenoid.Value leftValue = shooterLeft.get();
    	
    	switch (leftValue) {
	      case kOff:
	    	  System.out.println("shooter is OFF");
	    	  shooterLeft.set(DoubleSolenoid.Value.kForward);
	        break;
	      case kForward:
	    	  System.out.println("shooter is Forward");
	    	  shooterLeft.set(DoubleSolenoid.Value.kReverse);
	        break;
	      case kReverse:
	    	  System.out.println("shooter is Reverse");
	    	  shooterLeft.set(DoubleSolenoid.Value.kForward);
	        break;
	    }
    
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

