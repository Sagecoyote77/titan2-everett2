package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Servo extends CommandBase{
    
    public Servo(){

    }

    @Override
    public void initialize(){

    }

    @Override public void execute(){
        RobotContainer.CameraServo.servo1.setAngle(90);
    }

    @Override
    public boolean isFinished(){

    }

    @Override
    public void end( boolean interrupted){

    }
}