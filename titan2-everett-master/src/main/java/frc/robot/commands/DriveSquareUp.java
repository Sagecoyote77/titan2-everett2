// package frc.robot.commands;

// import com.revrobotics.Rev2mDistanceSensor;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.RobotContainer;
// import frc.robot.subsystems.Drive;
// /**
//  * Responding to motor control. Runs infinitely
//  */

// public class DriveSquareUp extends CommandBase {

//   private Drive drive = RobotContainer.drivymcDriveDriverson;
//   private Rev2mDistanceSensor rightSensor = drive.rightDistanceSensor;
//   private Rev2mDistanceSensor leftSensor = drive.leftDistanceSensor;
//   private int check = 0;
//   private final double TOLERANCE = .2;

//   public DriveSquareUp() {
//     // Use requires() here to declare subsystem dependencies
//     addRequirements(drive);
//   }

//   // Called just before this Command runs the first time
//   @Override
//   public void initialize() {
//     check = 0;
    
//   }
//   private double notReallyPID() {
//     // NOTE: Negative return values will increase the gyro's value
//     double MAX_POWER = 0.35; // cap the power 
//     double MIN_POWER = 0.20; // lowest effective power
//     int ENOUGH_CHECKS = 30; // how many times do we pass our target until we're satisfied?
//     double right = rightSensor.getRange();
//     double left = leftSensor.getRange();
//     if(right == -1 || left == -1){
//       System.out.println("ERROR:MISSING READING FROM SENSOR");
//       return 0.0;
//     }
//     // determine the error
//     double error = Math.abs(right - left);

//     // determine the power output neutral of direction
//     double output = (error/20) * MAX_POWER;
//     if(output < MIN_POWER) output = MIN_POWER;
//     if(output > MAX_POWER) output = MAX_POWER;

//     // are we there yet? this is to avoid ping-ponging
//     // plus we never stop the method unless our output is zero
//     if(Math.abs(error) < TOLERANCE) check++;
//     if(check > ENOUGH_CHECKS) return 0.0;

//     // determine the direction
//     // if I was trying to go a positive angle change from the start
//     if(rightSensor.getRange() > leftSensor.getRange()){
//       if(error > 0) return output; // move in a positive direction
//       else return -output; // compensate for over-turning by going a negative direction
//     }
//     // if I was trying to go a negative angle from the start
//     else{
//       if(error > 0) return -output; // move in a negative direction as intended
//       else return output; // compensate for over-turning by moving a positive direction
//     }
//    }

//   // Called repeatedly when this Command is scheduled to run
//   @Override
//   public void execute() {
//    drive.dMecanumDrive.driveCartesian(0, 0, notReallyPID());
//   }

//   // Make this return true  when this Command no longer needs to run execute()
//   @Override
//   public boolean isFinished() {
//     return Math.abs(rightSensor.getRange() - leftSensor.getRange()) < TOLERANCE;
//   }

//   // Called once after isFinished returns true
//   @Override
//   public void end(boolean interrupted) {
//    drive.dMecanumDrive.driveCartesian(0, 0, 0);
//   }

// }
