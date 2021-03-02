package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.SpeedController;

public class ElevationUp extends CommandBase {

    private SpeedController extend = RobotContainer.riser.elevatorUpMotor;
    
    public ElevationUp() {
        addRequirements( RobotContainer.riser );
    }

    @Override
  public void initialize() { 
    
  }

  @Override
  public void execute(){
    extend.set( 0.6 );
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
