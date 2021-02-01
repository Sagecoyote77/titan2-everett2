package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CameraDown extends CommandBase{

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        RobotContainer.camServo.servo1.setAngle( 0 );
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted){
        RobotContainer.camServo.servo1.stopMotor();
    }

}
