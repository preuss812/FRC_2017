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
	private final int LIDAR_DEFAULT_SCAN_RATE_MS = 2000;
	private final int LIDAR_ACQ_COMMAND_DIST_W_BIAS = 0x04;
	private java.util.Timer updater;
	
	private long lastUpdateTime;
	
	public LIDAR(Port port)
	{
		System.out.println("LIDAR (port, addr): " + port.value + ", " + LIDAR_ADDR);
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
		byte[] reg1 = new byte[1];
		int count = 0;
		reg1[0] =  (byte) 0xff;
		
		i2c.write(0x02, 0x80);
		i2c.write(0x04, 0x08);
		i2c.write(0x1c, 0x00);

		i2c.write(0x00, 0x04);
		System.out.println("Reg value before: " + reg1[0]);
		while ((reg1[0] & 0x1) == 1) {
			i2c.read(0x01, 1, reg1);
			Timer.delay(0.01);
			count++;
		}
		System.out.println("Count exit: " + count + "reg1: " + Integer.toBinaryString((int) reg1[0]) + " " + Integer.toBinaryString((int) (reg1[0]&0x1)));
		i2c.read(0x8f, 2, distance);
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
			if( !i2c.read(0x16, 2, reg1) ) {
				System.out.println("LIDAR: serial number read failed");
			}
			System.out.println("LIDAR 0x16 value: " + reg1[0] + ", " + reg1[1]);
			Timer.delay(0.10);

			if( ! i2c.write(LIDAR_CONFIG_REGISTER, LIDAR_ACQ_COMMAND_DIST_W_BIAS) ) {
				System.out.println("LIDAR: write to " + LIDAR_CONFIG_REGISTER + " VALUE: " + LIDAR_ACQ_COMMAND_DIST_W_BIAS + " FAILED" );
			}
			Timer.delay(0.10); // usually 0.04
/*			i2c.read(0x01, 2, reg1);
			System.out.println("LIDAR 0x01 values: " + 
					Integer.toUnsignedLong(reg1[0] << 8) + 
					" " + Byte.toUnsignedInt(reg1[1]));
*/				
			
			if( ! i2c.read(LIDAR_DISTANCE_REGISTER, 2, distance) ) {
				System.out.println("LIDAR: Read Distance failed");
			}
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
