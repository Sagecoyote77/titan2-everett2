package frc.robot.commands;

import java.sql.Time;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;

public class TurnRight extends CommandBase{
    private int count = 0;
  private double time;
  private Drive drive = RobotContainer.driveTrain;

  public TurnRight( double time ) {
    // Use requires() here to declare subsystem dependencies
    addRequirements(drive);
    this.time = time;
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    count = 0;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
      count ++;
      drive.tankDrive.arcadeDrive( -0.6, -0.9 );
    }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return count >= time*30;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    drive.tankDrive.arcadeDrive( 0, 0 );
  }

}
