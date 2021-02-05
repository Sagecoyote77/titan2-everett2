package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.SpeedController;

public class PunchCan extends CommandBase {
    
    private SpeedController punch = RobotContainer.punched.puncherGroup;
    
    public PunchCan() {
        addRequirements( RobotContainer.extendor );
    }

    @Override
  public void initialize() { 
    
  }

  @Override
  public void execute(){
    punch.set( 0.2 );
  }

  @Override
  public boolean isFinished(){
      return false;
  }

  @Override
  public void end( boolean interrupted ){
      punch.stopMotor();
  }

}
