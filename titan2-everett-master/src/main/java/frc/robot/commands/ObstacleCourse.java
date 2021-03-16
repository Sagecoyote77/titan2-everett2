package frc.robot.commands;

import java.sql.Time;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;

public class ObstacleCourse extends SequentialCommandGroup{
    private int count = 0;
  private Drive drive = RobotContainer.driveTrain;

  public ObstacleCourse() {
    // Use requires() here to declare subsystem dependencies
    addRequirements(drive);

    //Auto sequence
    // SequentialCommandGroup( new DriveTimeForward( 1 ) );
    // addCommand( new TurnRight( 1.3 ) );

    addCommands(
      new DriveTimeForward( 1 ),
      new TurnRight( 1.3 )
      // new DriveTimeForward( 1 ),
      // new TurnLeft(1.5),
      // new DriveTimeForward(1),
      // new TurnLeft(1.5),
      // new DriveTimeForward(1),
      // new TurnRight(1.3),
      // new DriveTimeForward(1),
      // new TurnRight(1.3),
      // new DriveTimeForward(1),
      // new TurnRight(1.3),
      // new DriveTimeForward(1),
      // new TurnRight(1.3),
      // new DriveTimeForward(1),
      // new TurnLeft(1.5),
      // new DriveTimeForward(1)

    );


  }

    // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    addCommands(
      new DriveTimeForward( 1 ),
      new TurnRight( 1.3 )
      // new DriveTimeForward( 1 ),
      // new TurnLeft(1.5),
      // new DriveTimeForward(1),
      // new TurnLeft(1.5),
      // new DriveTimeForward(1),
      // new TurnRight(1.3),
      // new DriveTimeForward(1),
      // new TurnRight(1.3),
      // new DriveTimeForward(1),
      // new TurnRight(1.3),
      // new DriveTimeForward(1),
      // new TurnRight(1.3),
      // new DriveTimeForward(1),
      // new TurnLeft(1.5),
      // new DriveTimeForward(1)

    );
    }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    drive.tankDrive.arcadeDrive( 0, 0 );
  }

}
