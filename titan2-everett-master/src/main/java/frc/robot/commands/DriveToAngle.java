/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.GyroE;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.*;

/**
 * Drive to an angle command
 * 
 * @author Moonshots Software Team
 */

public class DriveToAngle extends CommandBase {

  //Gyro gyro = new ADXRS450_Gyro(SPI.Port.kMXP);

  private double target;
  private int check;
  private int requestedRotation;
  private int ENOUGH_CHECKS = 15;

  private Drive drive = RobotContainer.driveTrain;

  public DriveToAngle(int requestedRotation) {
    // Use requires() here to declare subsystem dependencies
    addRequirements(RobotContainer.driveTrain);
    this.requestedRotation = requestedRotation;

  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    target = GyroE.getAngle() + requestedRotation;
    check = 0;
  }

  // private double notReallyPID() {
  //   // NOTE: Negative return values will increase the gyro's value
  //   double MAX_POWER = 0.55; // cap the power 
  //   double MIN_POWER = 0.15; // lowest effective power

  //   // determine the error
  //   double error = target - drive.gyro.getRawAngle();
  //   //double error = drive.gyro.getRawAngle() - target;

  //   // determine the power output proportinal to how far we have to go
  //   double output = Math.abs(error / requestedRotation) * MAX_POWER;
  //   if(output < MIN_POWER) output = MIN_POWER;
  //   if(output > MAX_POWER) output = MAX_POWER;

  //   // are we there yet? this is to avoid ping-ponging
  //   // plus we never stop the method unless our output is zero
  //   if(Math.abs(error) < Constants.MathConstants.ANGLE_TOLERANCE) check++;
  //   if(check > ENOUGH_CHECKS) return 0.0;

  //   // determine the direction
  //   // if I was trying to go a positive angle change from the start
  //   if(requestedRotation > 0){
  //     if(error > 0) return output; // move in a positive direction
  //     else return -output; // compensate for over-turning by going a negative direction
  //   }
  //   // if I was trying to go a negative angle from the start
  //   else{
  //     if(error < 0) return -output; // move in a negative direction as intended
  //     else return output; // compensate for over-turning by moving a positive direction
  //   }
  // }

  public double turn90(){
    double MAX_POWER = 0.55;
    double MIN_POWER = 0.15;
    // double toGo = 90 - drive.gyro.getRawAngle();
    // double output = Math.abs( toGo / requestedRotation ) * MAX_POWER;
    // if(output < MIN_POWER) output = MIN_POWER;
    // if(output > MAX_POWER) output = MAX_POWER;

    if( target < 90 ) return 0.6;
    else if( target > 90 ) return -0.6;
    else return 0.0;
  }

  public double turn180(){
    double MAX_POWER = 0.55;
    double MIN_POWER = 0.15;
    double toGo = 180 - drive.gyro.getAngle();
    double output = Math.abs( toGo / requestedRotation ) * MAX_POWER;
    if(output < MIN_POWER) output = MIN_POWER;
    if(output > MAX_POWER) output = MAX_POWER;

    if( drive.gyro.getAngle() < 180 ) return output;
    else if( drive.gyro.getAngle() > 180 ) return -output;
    else return 0.0;
  }

  public double turn270(){
    double MAX_POWER = 0.55;
    double MIN_POWER = 0.15;
    double toGo = 270 - drive.gyro.getAngle();
    double output = Math.abs( toGo / requestedRotation ) * MAX_POWER;
    if(output < MIN_POWER) output = MIN_POWER;
    if(output > MAX_POWER) output = MAX_POWER;

    if( drive.gyro.getAngle() < 270 ) return output;
    else if( drive.gyro.getAngle() > 270 ) return -output;
    else return 0.0;
  }

  // Called repeatedly when this Command is scheduled to run.
  @Override
  public void execute() {
    double error = 90 - drive.gyro.getAngle();
    drive.tankDrive.arcadeDrive( 0, turn90() );
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    //return true; // disable this command since our gyro broke
    //
    return ((check >= ENOUGH_CHECKS) && (Math.abs(drive.gyro.getRawAngle() - target) < Constants.MathConstants.ANGLE_TOLERANCE));
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    drive.tankDrive.arcadeDrive( 0, 0 );    
  }

}