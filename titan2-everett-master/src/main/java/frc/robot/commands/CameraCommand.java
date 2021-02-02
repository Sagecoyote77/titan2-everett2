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
        while( j0.getPOV() != -1 ){
            //moves servo based on POV value
             if( j0.getPOV() < 90 || j0.getPOV() > 270 ){
                s0.setAngle( Math.abs( s0.getAngle() - 0.001 ) );
             }
             else if( j0.getPOV() > 90 || j0.getPOV() < 270 ) {
                s0.setAngle( Math.abs( s0.getAngle() + 0.001 ) );
             }
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
