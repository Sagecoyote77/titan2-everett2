package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;

public class CameraCommand extends CommandBase{
    
    Joystick j0 = RobotContainer.joystickController;
    Servo s0 = RobotContainer.camServo.servo1;

    public CameraCommand() {
        addRequirements( RobotContainer.camServo );
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        int count = 0;
        while( count < 30 ){
            if( count % 5 == 0 ){
                while( j0.getPOV() != -1 ){
                    if( j0.getPOV() == 0 ) s0.setAngle( s0.getAngle() + 1 );
                    else if( j0.getPOV() == 180 ) s0.setAngle( s0.getAngle() - 1 );
                }
            }
            count++;
            if( count == 30 ) count = 0;
        }
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
