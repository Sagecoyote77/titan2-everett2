/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.Rev2mDistanceSensor;
import com.revrobotics.Rev2mDistanceSensor.Port;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// LOCAL IMPORTS
import frc.robot.Constants;


/**
 * * Instantiates the drive system with a gyro
 */
public class Drive extends SubsystemBase {
  
  // here's a gyro
  public GyroWrapper gyro = new GyroWrapper();

  public Rev2mDistanceSensor leftDistanceSensor = new Rev2mDistanceSensor(Port.kMXP);
  public Rev2mDistanceSensor rightDistanceSensor = new Rev2mDistanceSensor(Port.kOnboard);
  
  // here's some motors
  public Jaguar frontLeftMotor;
  public Jaguar backLeftMotor;
  public Jaguar frontRightMotor;
  public Jaguar backRightMotor;

  public DifferentialDrive tankDrive;

  // grouping the motors
  // public SpeedControllerGroup frontRight;
  // public SpeedControllerGroup frontLeft;
  // public SpeedControllerGroup backRight;
  // public SpeedControllerGroup backLeft;
  public SpeedControllerGroup rightSide;
  public SpeedControllerGroup leftSide;

  //gyro drive toggle
  public double driveStraightAt;
  public boolean gyroAssist = false;

  //super careful extra precise mode
  public boolean superCareful = false;

  public Drive(){    

    gyro.reset();
    // linking motors to ports
    frontLeftMotor = new Jaguar(Constants.PWDConstants.FRONT_LEFT);
    backLeftMotor = new Jaguar(Constants.PWDConstants.BACK_LEFT);
    frontRightMotor = new Jaguar(Constants.PWDConstants.FRONT_RIGHT);
    backRightMotor = new Jaguar(Constants.PWDConstants.BACK_RIGHT);
    
    // setting up the motor groups
    // frontRight = new SpeedControllerGroup(frontRightMotor);
    // frontRight.setInverted(true);
    // frontLeft = new SpeedControllerGroup(frontLeftMotor);
    // frontLeft.setInverted(true);
    // backRight = new SpeedControllerGroup(backRightMotor);
    // backLeft = new SpeedControllerGroup(backLeftMotor);
    rightSide = new SpeedControllerGroup(frontRightMotor, backRightMotor);
    leftSide = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);

    // making a mecanum drive
    //dMecanumDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
    //dMecanumDrive.setRightSideInverted(false);

    //making tank drive
    tankDrive = new DifferentialDrive(leftSide, rightSide);
    
    /**
     * Before measurements can be read from the sensor, setAutomaticMode(true)
     * must be called. This starts a background thread which will periodically
     * poll all enabled sensors and store their measured range.
    */
    rightDistanceSensor.setAutomaticMode(true);
    leftDistanceSensor.setAutomaticMode(true);
    
    
  }
  public boolean isMoving(){
    return this.rightSide.get() != 0 || this.leftSide.get() != 0;
  }

  public void engageDriveAssist(){
    this.gyroAssist = true;
    this.driveStraightAt = this.gyro.getRawAngle();
  }

  public void disengageDriveAssist(){
    this.gyroAssist = false;
    }

}