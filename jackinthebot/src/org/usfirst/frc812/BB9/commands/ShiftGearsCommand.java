package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class ShiftGearsCommand extends Command {

	private String className = this.getClass().getName();

	public ShiftGearsCommand() {
		System.out.println(className);
		
		requires(Robot.gearBoxSubsystem);
		//setTimeout(0.4);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		System.out.println("---> "+className+ ".initialized");
		//if ( !Robot.grabberSensorSubsystem.get() ){
		//Robot.doubleShooterSubsystem.releaseCatapult();
		//}
	}

	@Override
	protected void execute() {
		//if(isTimedOut()) {
		Robot.gearBoxSubsystem.toggle();
		//}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		//Robot.doubleShooterSubsystem.retractCatapult();
		System.out.println("----> "+className+".end");
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		//end();

	}

}
