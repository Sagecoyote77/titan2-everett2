package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LightSwitcher extends SubsystemBase {
    
    public Servo servo2 = new Servo( Constants.PWDConstants.LIGHT_SERVO );

}
