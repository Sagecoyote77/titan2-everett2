package frc.robot.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Intake extends CommandBase{



  private SpeedController intakeRight = RobotContainer.scoop.intakeGroup1;
  private SpeedController intakeLeft = RobotContainer.scoop.intakeGroup2;

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
      
  }
 
  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    intakeRight.set( -0.8 );
    intakeLeft.set( 0.8 );
    }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interupted) {
    intakeRight.set(0);
    intakeLeft.set(0);
  }

}