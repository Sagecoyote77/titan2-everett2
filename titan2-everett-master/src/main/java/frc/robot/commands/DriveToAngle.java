// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Constants;
// import frc.robot.RobotContainer;
// import frc.robot.subsystems.Drive;

// /**
//  * Drive to an angle command
//  * 
//  * @author Moonshots Software Team
//  */

// public class DriveToAngle extends CommandBase {

//   private double target;
//   private int check;
//   private int requestedRotation;
//   private int ENOUGH_CHECKS = 15;

//   private Drive drive = RobotContainer.drivymcDriveDriverson;

//   public DriveToAngle(int requestedRotation) {
//     // Use requires() here to declare subsystem dependencies
//     addRequirements(RobotContainer.drivymcDriveDriverson);
//     this.requestedRotation = requestedRotation;

//   }

//   // Called just before this Command runs the first time
//   @Override
//   public void initialize() {
//     target = drive.gyro.getRawAngle() + requestedRotation;
//     check = 0;
//   }

//   private double notReallyPID() {
//     // NOTE: Negative return values will increase the gyro's value
//     double MAX_POWER = 0.55; // cap the power 
//     double MIN_POWER = 0.15; // lowest effective power

//     // determine the error
//     double error = target - drive.gyro.getRawAngle();
//     //double error = drive.gyro.getRawAngle() - target;

//     // determine the power output neutral of direction
//     double output = Math.abs(error / requestedRotation) * MAX_POWER;
//     if(output < MIN_POWER) output = MIN_POWER;
//     if(output > MAX_POWER) output = MAX_POWER;

//     // are we there yet? this is to avoid ping-ponging
//     // plus we never stop the method unless our output is zero
//     if(Math.abs(error) < Constants.MathConstants.ANGLE_TOLERANCE) check++;
//     if(check > ENOUGH_CHECKS) return 0.0;

//     // determine the direction
//     // if I was trying to go a positive angle change from the start
//     if(requestedRotation > 0){
//       if(error > 0) return output; // move in a positive direction
//       else return -output; // compensate for over-turning by going a negative direction
//     }
//     // if I was trying to go a negative angle from the start
//     else{
//       if(error < 0) return -output; // move in a negative direction as intended
//       else return output; // compensate for over-turning by moving a positive direction
//     }
//   }

//   // Called repeatedly when this Command is scheduled to run.
//   @Override
//   public void execute() {
//     // if we triggered a setPoint
//     //SmartDashboard.putNumber("Checks", check);
//    RobotContainer.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0, 0, notReallyPID());
//   }

//   // Make this return true when this Command no longer needs to run execute()
//   @Override
//   public boolean isFinished() {
//     //return true; // disable this command since our gyro broke
//     //
//     return check >= ENOUGH_CHECKS && Math.abs(drive.gyro.getRawAngle() - target) < Constants.MathConstants.ANGLE_TOLERANCE;

//     //
//   }

//   // Called once after isFinished returns true
//   @Override
//   public void end(boolean interrupted) {
//     RobotContainer.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0, 0, 0);    
//   }

// }