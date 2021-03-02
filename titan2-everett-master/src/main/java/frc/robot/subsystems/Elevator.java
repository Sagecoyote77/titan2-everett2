package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import frc.robot.Constants;

public class Elevator extends SubsystemBase{
    
    public Jaguar elevatorMotor, elevatorUpMotor;

    public SpeedControllerGroup elevation, elevating;

    public Elevator() {

        elevatorMotor = new Jaguar( Constants.PWDConstants.ELEVATOR );

        elevation = new SpeedControllerGroup( elevatorMotor );

        elevatorUpMotor = new Jaguar(Constants.PWDConstants.ELEVATORUP);

        elevating = new SpeedControllerGroup(elevatorUpMotor);

    }

}
