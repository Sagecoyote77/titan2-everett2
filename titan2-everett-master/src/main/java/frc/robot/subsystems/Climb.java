/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import frc.robot.Constants;

/**
 * * Instantiates the drive system with a gyro
 */
public class Climb extends SubsystemBase {

  // here's some motors
  private Jaguar winchMotor = new Jaguar(Constants.PWDConstants.WINCH);
  private Talon elevatorMotor = new Talon(Constants.PWDConstants.ELEVATOR);  

  public SpeedControllerGroup winchMotors;
  public SpeedControllerGroup elevatorMotorGroup;
    
  public Encoder encoder = new Encoder(Constants.DIOConstants.ELEVATOR_ENC_A, Constants.DIOConstants.ELEVATOR_ENC_B);

  
  public Climb(){    
    // PID STUFF: https://frc-pdr.readthedocs.io/en/latest/control/using_WPILIB's_pid_controller.html#implementing-a-basic-pid-control
    // linking motors to ports
    //leftMotor.setInverted(true);  
    winchMotors = new SpeedControllerGroup(winchMotor);
    elevatorMotorGroup = new SpeedControllerGroup(elevatorMotor);
    
    }
  }
