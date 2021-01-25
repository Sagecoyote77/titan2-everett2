// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.RobotContainer;
// import frc.robot.subsystems.Drive;


// public class DriveToWall extends CommandBase {

//   private Drive drive = RobotContainer.drivymcDriveDriverson;
//   private int count = 0;

//   public DriveToWall() {
//     // Use requires() here to declare subsystem dependencies
//     addRequirements(drive);
//   }

//   // Called just before this Command runs the first time
//   @Override
//   public void initialize() {
//     count = 0;
    
//   }

//   // Called repeatedly when this Command is scheduled to run
//   @Override
//   public void execute() {
//     if ((drive.rightDistanceSensor.isRangeValid() && drive.rightDistanceSensor.getRange() < 10) || (drive.leftDistanceSensor.isRangeValid() && drive.leftDistanceSensor.getRange() < 10)){
//       count++;
//       System.out.println("I see a wall...?");
//     } 
//     drive.dMecanumDrive.driveCartesian(0, -0.2, 0);
//      }

//   // Make this return true when this Command no longer needs to run execute()
//   @Override
//   public boolean isFinished() {
//     return count > 3;
//   }

//   // Called once after isFinished returns true
//   @Override
//   public void end(boolean interrupted) {
//     drive.dMecanumDrive.driveCartesian(0, 0, 0);
//   }

// }
