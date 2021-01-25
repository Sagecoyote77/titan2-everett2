package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class GyroWrapper extends ADXRS450_Gyro{
    public GyroWrapper(){
        super();
    }
    public double getAngle(){
        double raw = super.getAngle();
        if(raw < 0) { return Math.abs(raw % 360 + 360); }
        else { return Math.abs(raw % 360); }
    }
    public double getRawAngle(){
        return super.getAngle();
    }
}