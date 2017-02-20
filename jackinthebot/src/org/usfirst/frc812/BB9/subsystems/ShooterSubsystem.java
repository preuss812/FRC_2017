package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	 DoubleSolenoid shooter = RobotMap.shifter;
	
	 public DoubleSolenoid.Value getShooterState() {
		 DoubleSolenoid.Value value = shooter.get();
		 switch (value) {
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
		 return value;
	 }
	 
    public void releaseCatapult() {
    	shooter.set(DoubleSolenoid.Value.kReverse);
    	System.out.println("releaseCatapult");
    }

    public void retractCatapult() {
    	shooter.set(DoubleSolenoid.Value.kForward);
    	System.out.println("retractCatapult");
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

