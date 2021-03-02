package frc.robot.subsystems;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class GyroE
{
  private static final ADXRS450_Gyro gyro = RobotContainer.gyro;

  public static int getAngle() {
    return (int) gyro.getAngle();

  }

  public void calibrating() {
    gyro.calibrate();
  }

}