package org.usfirst.frc812.BB9.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivelineSubsystem extends Subsystem {

	public static final double distancePerPulse = .01227;
	public static Encoder leftEnc;
	public static Encoder rightEnc;
	
	public static Counter leftCounter;
	public static Counter rightCounter;
	
	public DrivelineSubsystem() {
//		leftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k1X);
//		rightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k1X);
//		setDefaultValues(leftEnc);
//		setDefaultValues(rightEnc);
//		leftEnc.reset();
//		rightEnc.reset();
		
		leftCounter = new Counter();
		leftCounter.setUpSource(1);
		leftCounter.setDownSource(0);
		leftCounter.setDownSourceEdge(false, true);
		leftCounter.setUpDownCounterMode();
		setDefaultValues(leftCounter);
		
		rightCounter = new Counter();
		rightCounter.setUpSource(2);
		rightCounter.setDownSource(3);
		rightCounter.setDownSourceEdge(false, true);
		rightCounter.setUpDownCounterMode();
		setDefaultValues(rightCounter);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void setDefaultValues(Encoder encoder) {
		encoder.setMaxPeriod(1);
		//encoder.setMinRate(10);
		encoder.setDistancePerPulse(0.01227);
		// encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(4);
		
	}
	
	public void setDefaultValues(Counter counter) {
		counter.setMaxPeriod(1);
		//encoder.setMinRate(10);
		counter.setDistancePerPulse(0.01227);
		// encoder.setReverseDirection(true);
		counter.setSamplesToAverage(4);
		
	}

	public Encoder getLeftEncoder() {
		return leftEnc;
	}

	public Encoder getRightEncoder() {
		return rightEnc;
	}

}
