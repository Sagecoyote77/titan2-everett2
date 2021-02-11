package frc.robot.commands;

import java.sql.Time;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.controller.*;

public class DriveTimeForward extends CommandBase{
    private int count = 0;
  private double time;
  double speed = 0.0;
  private Drive drive = RobotContainer.driveTrain;
  boolean working = false;

  public DriveTimeForward( double time ) {
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
      // while( speed < 0.9 ){
      //   drive.tankDrive.tankDrive( -speed, -speed );
      //   speed += 0.001;
      // }
      drive.tankDrive.tankDrive( -0.999, -0.999 );
      if( !working ){
        work();
      }
    }

    public void work(){
      working = true;
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
