/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;

/**
 * Responding to motor control. Runs infinitely
 */
public class DriveCommand extends CommandBase {

  private Drive drive = RobotContainer.driveTrain;

  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    addRequirements(RobotContainer.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() { 
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    //MANUAL DEAD ZONE
    double dead = 0.10;

    double valuelefty = RobotContainer.joystickController.getY();
    double rightx = RobotContainer.joystickController.getX();
    double valuerightx = -rightx;

    if(Math.abs(valuelefty) < dead){
      valuelefty = 0;
    }
    if(Math.abs(valuerightx) < dead){
      valuerightx = 0;
    } 

    drive.tankDrive.arcadeDrive( valuelefty, valuerightx );

   }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
     drive.tankDrive.arcadeDrive(0, 0);
  }

}
