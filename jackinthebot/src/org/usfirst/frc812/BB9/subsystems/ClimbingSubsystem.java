package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;
import org.usfirst.frc812.BB9.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;



	
	 
public class ClimbingSubsystem extends Subsystem {
	public RobotDrive robotDrive = RobotMap.dtProductionRobotDrive;
	
	public void initDefaultCommand(){
//	 limit switches default at false, becomes true when limit switch is pushed -- stops driving robot 
//	 when limit switch = true,  delay so it does not stop immediately otherwise keep driving 
//	 if (RobotMap.climberSensor.get() == true){
//		 stop();
//	 	}
		

	}
	
    public void stop() {
    	robotDrive.drive(0,0);
    }
}
