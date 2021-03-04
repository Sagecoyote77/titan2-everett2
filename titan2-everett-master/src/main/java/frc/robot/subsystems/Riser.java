package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import frc.robot.Constants;

public class Riser extends SubsystemBase{
    
    public Jaguar elevatorUpMotor;

    public SpeedControllerGroup elevating;

    public Riser() {

        elevatorUpMotor = new Jaguar(Constants.PWDConstants.ELEVATORUP);

        elevating = new SpeedControllerGroup(elevatorUpMotor);

    }

}
