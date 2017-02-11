package org.usfirst.frc812.BB9.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivelineSubsystem extends Subsystem {

	public static Encoder leftEnc;
	public static Encoder rightEnc;
	
	public DrivelineSubsystem() {
		leftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		rightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		setDefaultValues(leftEnc);
		setDefaultValues(rightEnc);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	private void setDefaultValues(Encoder encoder) {
		encoder.setMaxPeriod(1);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(5);
		// encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(7);
		
	}

	public Encoder getLeftEncoder() {
		return leftEnc;
	}

	public Encoder getRightEncoder() {
		return rightEnc;
	}

}
