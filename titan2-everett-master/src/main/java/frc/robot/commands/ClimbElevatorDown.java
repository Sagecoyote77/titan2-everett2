/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ClimbElevatorDown extends CommandBase {
  boolean liveDangerously;

  public ClimbElevatorDown(boolean liveDangerously) {
    this.liveDangerously = liveDangerously;
    // Use requires() here to declare subsystem dependencies

  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    
  }

  
  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    RobotContainer.climbymcClimbClimberson.elevatorMotorGroup.set(0.35);
    
        
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    if(!liveDangerously){
      return RobotContainer.climbymcClimbClimberson.encoder.getRaw() >= 0;
    }
    else{
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interupted) {
    RobotContainer.climbymcClimbClimberson.elevatorMotorGroup.set(0);
 }

}

