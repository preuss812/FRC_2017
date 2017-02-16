package org.usfirst.frc812.BB9.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivelineSubsystem extends Subsystem {

	public static Encoder leftEnc;
	public static Encoder rightEnc;
	
	public static Counter leftCounter;
	
	public DrivelineSubsystem() {
//		leftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k1X);
//		rightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k1X);
//		setDefaultValues(leftEnc);
//		setDefaultValues(rightEnc);
//		leftEnc.reset();
//		rightEnc.reset();
		
		leftCounter = new Counter();
//		leftCounter = new Counter(2);
		leftCounter.setUpSource(0);
		leftCounter.setDownSource(1);
		leftCounter.setDownSourceEdge(true, false);
//		leftCounter.setUpDownCounterMode();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	private void setDefaultValues(Encoder encoder) {
		encoder.setMaxPeriod(1);
		//encoder.setMinRate(10);
		encoder.setDistancePerPulse(5);
		// encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(4);
		
	}

	public Encoder getLeftEncoder() {
		return leftEnc;
	}

	public Encoder getRightEncoder() {
		return rightEnc;
	}

}
