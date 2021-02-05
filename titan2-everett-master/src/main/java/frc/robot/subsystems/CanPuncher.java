package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import frc.robot.Constants;

public class CanPuncher extends SubsystemBase {
    
    public Jaguar PuncherMotor;

    public SpeedControllerGroup puncherGroup;

    public CanPuncher() {

        PuncherMotor = new Jaguar( Constants.PWDConstants.PUNCHER );

        puncherGroup = new SpeedControllerGroup( PuncherMotor );

    }

}
