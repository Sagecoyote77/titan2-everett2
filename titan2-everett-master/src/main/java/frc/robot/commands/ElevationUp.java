package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.SpeedController;

public class ElevationUp extends CommandBase {

    private SpeedController big = RobotContainer.raising.elevatorUpMotor;
    
    public ElevationUp() {
        addRequirements( RobotContainer.raising );
    }

    @Override
  public void initialize() { 
    
  }

  @Override
  public void execute(){
    big.set( 0.6 );
  }

  @Override
  public boolean isFinished(){
      return false;
  }

  @Override
  public void end( boolean interrupted ){
      big.stopMotor();
  }

}
