package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AccelByCounters extends Command {

	public AccelByCounters() {}
		/// class is made to drive straight at a given power level

	private double Direction =0;
	private double StopCount =0;
	int CountAvg = (Robot.drivelineSubsystem.leftCounter.get() + Robot.drivelineSubsystem.rightCounter.get())/2;
	double CounterConstant = StopCount / .4;
	double Accel = .1 + (CountAvg / CounterConstant);

	
//	//Constructor Method for accelerating by counter
	
	public AccelByCounters(double stopCount) {
		
		requires(Robot.driveTrain);
		StopCount = stopCount;
		setTimeout(15);
		
		System.out.println("DriveByCounters, speed= " + Accel + " stop at  " + stopCount   );
		
	}

	 /**
	   * Drive the motors at "outputMagnitude" and "curve". Both outputMagnitude and curve are -1.0 to
	   * +1.0 values, where 0.0 represents stopped and not turning. {@literal curve < 0 will turn left
	   * and curve > 0} will turn right.
	   *
	   * <p>The algorithm for steering provides a constant turn radius for any normal speed range, both
	   * forward and backward. Increasing sensitivity causes sharper turns for fixed values of curve.
	   *
	   * <p>This function will most likely be used in an autonomous routine.
	   *
	   * @param outputMagnitude The speed setting for the outside wheel in a turn, forward or backwards,
	   *                        +1 to -1.
	   * @param curve           The rate of turn, constant for different forward speeds. Set {@literal
	   *                        curve < 0 for left turn or curve > 0 for right turn.} Set curve =
	   *                        e^(-r/w) to get a turn radius r for wheelbase w of your robot.
	   *                        Conversely, turn radius r = -ln(curve)*w for a given value of curve and
	   *                        wheelbase w.
	   */	
	
    protected void initialize() {

		Robot.drivelineSubsystem.leftCounter.reset();
		Robot.drivelineSubsystem.rightCounter.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    	double righty = Robot.drivelineSubsystem.rightCounter.get() * (-1);
    	double lefty = Robot.drivelineSubsystem.leftCounter.get();
    	double CountAvg = ((lefty + righty)/2);
    	double CounterConstant = StopCount/ .4;
    	double Accel = .1 + ( CountAvg / CounterConstant);
    	System.out.println("Speed =" + Accel );
//    	System.out.println("Average =" + CountAvg );
    	System.out.println("Left =" + lefty );
    	System.out.println("Right =" + righty );
//    	double delta = java.lang.Math.abs(lefty-righty);
//    	double percentError = delta/(lefty + righty);
//    	double constant = .000001;
//    	double factor = 10;
//    	System.out.println("made it to counter gets");
    	if(lefty <= StopCount && righty<=StopCount)
//    	{
//    		System.out.println("inside while loop, L&R counter are: " + lefty +"    " + righty  );
//     	//Robot.driveTrain.
//    		System.out.println("Direction value is" + Direction   );
//    		System.out.println("Delta value is" + delta   );
//    		System.out.println("percentError is" + percentError   );
    	RobotMap.dtProductionRobotDrive.drive(Accel,Direction);
    	//Speed & Direction are between +1 and -1
    	//positive direction =right turn, negative=left turn
    	
    	
//    	if(delta>=Threshold)  
//    		{
//    		System.out.println("inside threshold check");
//    		System.out.println(" L&R counter are: " + lefty +"    " + righty  );
//    	
//	    		if(lefty>=righty)  //left counter ahead, turn towards left 
//	    			{
//	    		System.out.println("turning left");
//	    		System.out.println(" L&R counter are: " + lefty +"    " + righty  );
//	    		Direction=(Direction-(factor * percentError * (Direction + constant)));
//	    		System.out.println("Direction value is" + Direction   );
//	    			}
//	    		if(righty>=lefty) //right counter ahead, turn towards right
//	    			{
//	    		System.out.println("turning right");
//	    		System.out.println(" L&R counter are: " + lefty +"    " + righty  );
//	    		Direction=(Direction+(factor * percentError * (Direction + constant)));
//	    		System.out.println("Direction value is" + Direction);
//	    			} 
    	counterReached();
    	
//    		}
//    	}
    	
  }

    public Boolean counterReached() {
    	double righty = Robot.drivelineSubsystem.rightCounter.get() * (-1);
    	double lefty = Robot.drivelineSubsystem.leftCounter.get();
    	Boolean reached=false;
    	if(lefty>=StopCount && righty>=StopCount)
    	{
    		System.out.println("inside reached limit check");
    		System.out.println(" L&R counter are: " + lefty +"    " + righty  );
    		Boolean result=true;
    		reached=result;
    		}
    	return reached;
    }
    
//    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    
    	return counterReached();
		//return isTimedOut();
    }

  //   Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
