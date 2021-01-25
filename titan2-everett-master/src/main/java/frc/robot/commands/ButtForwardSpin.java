package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ButtWheel;

public class ButtForwardSpin extends CommandBase {

  private ButtWheel buttWheel = RobotContainer.spinnymcSpinSpinnerson;

  public ButtForwardSpin() {
    // Use requires() here to declare subsystem dependencies

  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {

  }
 
  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    RobotContainer.spinnymcSpinSpinnerson.buttMotorGroup.set(.25);
  }

  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    buttWheel.buttMotorGroup.set(0);
  }

}

