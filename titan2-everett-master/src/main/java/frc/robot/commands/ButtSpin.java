/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ButtWheel;

public class ButtSpin extends CommandBase {

  private boolean spinToColor;
  private String gameData;
  private int count = 0;
  private ButtWheel buttWheel = RobotContainer.spinnymcSpinSpinnerson;
  private String lastReading;

  public ButtSpin(boolean spinToColor) {
    // Use requires() here to declare subsystem dependencies
    addRequirements(RobotContainer.spinnymcSpinSpinnerson);
    this.spinToColor = spinToColor;

  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    count = 0;
    gameData = DriverStation.getInstance().getGameSpecificMessage();  
  }
 
  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    String reading = buttWheel.getColor();
    if(spinToColor){
      if(!gameData.equals(reading)){
        RobotContainer.spinnymcSpinSpinnerson.buttMotorGroup.set(.15);
      }

    }
    else{
      RobotContainer.spinnymcSpinSpinnerson.buttMotorGroup.set(.15);
      if(count == 0 || !reading.equals(lastReading)){
        count++;
        lastReading = reading;
      }
    }
    SmartDashboard.putNumber("butt count", count);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    if(spinToColor) 
      return buttWheel.getOffsetColor(buttWheel.getColor()).equals(gameData);
    return count >= 28;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interupted) {
    buttWheel.buttMotorGroup.set(0);
  }

}

