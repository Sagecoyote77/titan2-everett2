package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.*;

public class GyroWrapper extends ADXRS450_Gyro{

    Gyro gyro = new ADXRS450_Gyro(SPI.Port.kMXP);
    double raw = 0;

    // public GyroWrapper(SPI.Port port) {
    //     super();
    // }

    public GyroWrapper(Port kmxp) {
        //kmxp = 4;
	}

	public double getAngle(){
        if( gyro.getRate() != 0 ){
            raw = gyro.getAngle();
        }
        if(raw < 0) { return Math.abs(raw % 360 + 360); }
        else { return Math.abs(raw % 360); }
    }
    public double getRawAngle(){
        return super.getAngle();
    }
}