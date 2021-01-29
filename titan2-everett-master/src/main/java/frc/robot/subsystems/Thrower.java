/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Jaguar;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class Thrower extends SubsystemBase {
  
  private Jaguar throwLeft = new Jaguar(Constants.PWDConstants.LEFT_THROWER);
  private Jaguar throwRight = new Jaguar(Constants.PWDConstants.RIGHT_THROWER);
  public SpeedControllerGroup thowerGroup1;
  public SpeedControllerGroup thowerGroup2;

  /**
   * Open Smart Dashboard or Shuffleboard to see the color detected by the 
   * sensor.
   */
  public Thrower(){
    //armEncoder.reset(); // encoder starts at zero. Max is ~900?
    thowerGroup1 = new SpeedControllerGroup(throwRight);
    thowerGroup2= new SpeedControllerGroup(throwLeft);
  }

}