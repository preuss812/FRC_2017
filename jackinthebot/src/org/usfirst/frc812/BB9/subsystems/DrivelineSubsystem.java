package org.usfirst.frc812.BB9.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivelineSubsystem extends Subsystem {

	public static final double distancePerPulse = .01227;
	//public Encoder leftEnc;
	//public Encoder rightEnc;
	
	public  Counter leftCounter;
	public  Counter rightCounter;
	
	
	//constructor method to instantiate counters
	
	public DrivelineSubsystem() {
//		couldn't get encoders to work...try again!
//		leftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k1X);
//		rightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k1X);
//		setDefaultValues(leftEnc);
//		setDefaultValues(rightEnc);
//		leftEnc.reset();
//		rightEnc.reset();

		
		//setup counters. not currently working correctly, one pin on left sensor removed to compensate
		leftCounter = new Counter();
		leftCounter.setUpSource(2);
		leftCounter.setDownSource(3);
		leftCounter.setDownSourceEdge(false,true);
		leftCounter.setUpDownCounterMode();
		setDefaultValues(leftCounter);
		leftCounter.reset();

		rightCounter = new Counter();
		rightCounter.setUpSource(4);
		rightCounter.setDownSource(5);
		rightCounter.setDownSourceEdge(false, true);
		rightCounter.setUpDownCounterMode();
		setDefaultValues(rightCounter);
		rightCounter.reset();
	}
	
	@Override
	protected void initDefaultCommand() {

	}
	
//	public void setDefaultValues(Encoder encoder) {
//		encoder.setMaxPeriod(1);
//		//encoder.setMinRate(10);
//		encoder.setDistancePerPulse(distancePerPulse);
//		// encoder.setReverseDirection(true);
//		encoder.setSamplesToAverage(4);
//		
//	}
	
	public void setDefaultValues(Counter counter) {
		counter.setMaxPeriod(1);
		//encoder.setMinRate(10);
		counter.setDistancePerPulse(distancePerPulse);
		// encoder.setReverseDirection(true);
		counter.setSamplesToAverage(4);
		
	}
	
	
	public Counter getLeftCounter(){
		return leftCounter;
	}

	public Counter getRightCounter(){
		return rightCounter;
	}

//	public Encoder getLeftEncoder() {
//		return leftEnc;
//	}
//
//	public Encoder getRightEncoder() {
//		return rightEnc;
//	}

}
