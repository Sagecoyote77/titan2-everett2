package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CameraNetwork extends SubsystemBase {
    
    public Servo servo1 = new Servo( Constants.PWDConstants.CAMSERVO );

}
