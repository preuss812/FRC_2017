package org.usfirst.frc812.BB9.sensors;

import java.util.TimerTask;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.Timer;

public class SerialLidar {
	private SerialPort serial;
	private java.util.Timer updater;
	private long lastUpdateTime;
	private Long distance;
	
	public SerialLidar(final int baudrate, Port port)
	{
		serial = new SerialPort(baudrate, port);
		distance = (long)-1;
		lastUpdateTime = System.currentTimeMillis();
		updater = new java.util.Timer();
	}
	public void start()
	{
		start(75);
	}
	
	public void start(int period) {
		serial.reset();
		serial.enableTermination(); // '\n'
		updater.schedule(new SerialLidarUpdater(), 0, period);
	}
	
	public void stop() {
		updater.cancel();
		updater = new java.util.Timer();
	}
	
	public long updateTime()
	{
		return(System.currentTimeMillis() - lastUpdateTime);
	}
	
	public long getDistance()
	{
		return distance;
	}
	
	public boolean updateDistance()
	{	
		int count = 0;
		String newDistance = "";

		while( newDistance.isEmpty() && count++ < 100) {
			newDistance = serial.readString().replaceAll("[^0-9]", "");
			
//			System.out.println("New distance: >" + newDistance + "<");
			try {
				distance = Long.valueOf(newDistance);
			} catch(NumberFormatException e){
			}
			Timer.delay(0.01);
		}

//		System.out.println("int New distance: " + intDistance);
		
		serial.disableTermination(); // Disable line termination, empty the Rx buffer
		String junk = serial.readString();
//		System.out.println("junk: >" + junk + "<");
		serial.enableTermination(); // Re-enable line termination for the next go around
		
		return true;
	}
	
	private class SerialLidarUpdater extends TimerTask
	{
		@Override
		public void run()
		{
			while(true)
			{
				updateDistance();
				try
				{
					Thread.sleep(10);
				} catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
