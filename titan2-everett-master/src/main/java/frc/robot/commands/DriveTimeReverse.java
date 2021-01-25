// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.RobotContainer;

// /**
//  * Responding to motor control. Runs infinitely
//  */

// public class DriveTimeReverse extends CommandBase {

//   private int count = 0;
//   private double time;

//   public DriveTimeReverse(double time) {
//     // Use requires() here to declare subsystem dependencies
//     addRequirements(RobotContainer.drivymcDriveDriverson);
//     this.time = time;
//   }

//   // Called just before this Command runs the first time
//   @Override
//   public void initialize() {
//     count = 0;
//   }

//   // Called repeatedly when this Command is scheduled to run
//   @Override
//   public void execute() {
//       count ++;
//       RobotContainer.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0, 0, 0.15);
//     }


//   // Make this return true when this Command no longer needs to run execute()
//   @Override
//   public boolean isFinished() {
//     return count >= time*30;
//   }

//   // Called once after isFinished returns true
//   @Override
//   public void end(boolean interrupted) {
//     RobotContainer.drivymcDriveDriverson.dMecanumDrive.driveCartesian(0, 0, 0);
//   }

// }