package org.usfirst.frc812.BB9.sensors;

import java.util.TimerTask;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.Timer;

public class LIDAR {
	private I2C i2c;
	private byte[] distance;
	
	private final int LIDAR_ADDR = 0x62; // Default I2C device 0 address is 0x62
	private final int LIDAR_CONFIG_REGISTER = 0x00;
	private final int LIDAR_DISTANCE_REGISTER = 0x8f;
	private final int LIDAR_DEFAULT_SCAN_RATE_MS = 100;
	private final int LIDAR_ACQ_COMMAND_DIST_W_BIAS = 0x04;
	private java.util.Timer updater;
	
	private long lastUpdateTime;
	
	public LIDAR(Port port)
	{
		i2c = new I2C(port, LIDAR_ADDR);
		distance = new byte[2];
		lastUpdateTime = System.currentTimeMillis();
		updater = new java.util.Timer();
	}
	public void start()
	{
		start(LIDAR_DEFAULT_SCAN_RATE_MS);
	}
	
	public void start(int period) {
		updater.schedule(new LIDARUpdater(), 0, period);
	}
	
	public void stop() {
		updater.cancel();
		updater = new java.util.Timer();
	}
	
	public long updateTime()
	{
		return(System.currentTimeMillis() - lastUpdateTime);
	}
	
	public int getDistance()
	{
		return (int) Integer.toUnsignedLong(distance[0] << 8) + Byte.toUnsignedInt(distance[1]);
	}
	
	// Simple distance reading for the LIDAR Lite v3 (2017)
	// 1. Set the configuration register with the command to read distance with bias
	// 2. Wait a bit to insure the register setting is effective
	// 3. Read the value of the distance register, 2 bytes, into the distance byte array
	public boolean updateDistance()
	{
		byte[] reg1 = new byte[2];
		
		if(System.currentTimeMillis() - lastUpdateTime >= LIDAR_DEFAULT_SCAN_RATE_MS)
		{
			i2c.write(LIDAR_CONFIG_REGISTER, LIDAR_ACQ_COMMAND_DIST_W_BIAS);
			Timer.delay(0.10); // usually 0.04
			i2c.read(0x01, 2, reg1);
			System.out.println("LIDAR 0x01 values: " + 
					Integer.toUnsignedLong(reg1[0] << 8) + 
					" " + Byte.toUnsignedInt(reg1[1]));
			i2c.read(LIDAR_DISTANCE_REGISTER, 2, distance);
			Timer.delay(0.005);
			lastUpdateTime = System.currentTimeMillis();
			return true;
		}
		return false;
	}
	
	private class LIDARUpdater extends TimerTask
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
