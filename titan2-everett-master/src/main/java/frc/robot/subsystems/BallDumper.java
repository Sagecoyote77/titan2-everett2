/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;
import frc.robot.Constants;

/**
 * * Instantiates the drive system with a gyro
 */
public class BallDumper extends SubsystemBase {

  public boolean isDumpOpen; 

  // Servos must be plugged into the Roborio itself, not the extention board, as it does not provide enough power.
  public Servo servo1 = new Servo(Constants.PWDConstants.DUMPER_LEFT_SERVO);
  public Servo servo2 = new Servo(Constants.PWDConstants.DUMPER_RIGHT_SERVO);

  public BallDumper(){
    
  }
  
}
