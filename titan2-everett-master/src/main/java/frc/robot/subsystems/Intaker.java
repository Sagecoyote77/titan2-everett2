package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Jaguar;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Intaker extends SubsystemBase{
    
    private Jaguar intakeLeft = new Jaguar( Constants.PWDConstants.LEFT_THROWER );
    private Jaguar intakeRight = new Jaguar( Constants.PWDConstants.RIGHT_THROWER );
    public SpeedControllerGroup intakeGroup1;
    public SpeedControllerGroup intakeGroup2;

    public Intaker(){
        intakeGroup1 = new SpeedControllerGroup( intakeRight );
        intakeGroup2= new SpeedControllerGroup( intakeLeft );
    }
}
