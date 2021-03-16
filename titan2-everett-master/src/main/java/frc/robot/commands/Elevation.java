package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.SpeedController;

public class Elevation extends CommandBase {

    private SpeedController extend = RobotContainer.extendor.elevatorMotor;
    
    public Elevation() {
        addRequirements( RobotContainer.extendor );
    }

    @Override
  public void initialize() { 
    
  }

  @Override
  public void execute(){
    extend.set( 0.99 );
  }

  @Override
  public boolean isFinished(){
      return false;
  }

  @Override
  public void end( boolean interrupted ){
      extend.stopMotor();
  }

}
