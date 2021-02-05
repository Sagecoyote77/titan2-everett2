package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Servo;

public class SwitchLight extends CommandBase{
    
    Servo s1 = RobotContainer.switched.servo2;
    double seconds = RobotContainer.timer.get();

    public SwitchLight() {
        addRequirements( RobotContainer.camServo );
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        for( int i = 0; i < seconds + 1; i++ ){
            s1.setAngle( 90 );
            s1.setAngle( 95 );
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
