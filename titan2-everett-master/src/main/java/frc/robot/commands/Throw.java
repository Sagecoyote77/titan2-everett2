/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Thrower;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class Throw extends CommandBase {

  private SpeedController shoot = RobotContainer.thrower.thowerGroup;

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
      
  }
 
  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    shoot.set(0.8);

    }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interupted) {
    shoot.set(0);
  }

}
