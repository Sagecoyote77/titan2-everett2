package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;

public class SwitchLight extends CommandBase{
    
    Servo s1 = RobotContainer.switched.servo2;
    public static Timer timer = new Timer();
    double seconds = 1;

    public SwitchLight() {
        addRequirements( RobotContainer.camServo );
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
            s1.setAngle( 90 );
            s1.setAngle( 130 );
            // s1.setAngle( 90 );
            // s1.setAngle( 130 );
            // s1.setAngle( 90 );
            // s1.setAngle( 130 );
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted){
        RobotContainer.switched.servo2.stopMotor();
    }

}
