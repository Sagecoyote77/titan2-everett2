/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants.OIConstants;
//import frc.robot.commands.groups.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
*/
public class RobotContainer {
  // The robot's subsystems and commands are defined here...\

  // STATIC SUBSYSTEMS
  public static Drive drivymcDriveDriverson = new Drive();
  public static ButtWheel spinnymcSpinSpinnerson = new ButtWheel();
  public static Thrower thrower = new Thrower();
  public static CameraNetwork camServo = new CameraNetwork();
  public static BallDumper dumpymcDumpDumperson = new BallDumper();
  public static Climb climbymcClimbClimberson = new Climb();
  //public static CamPan cameraServo = new Servo();

  public static XboxController XboxController = new XboxController(OIConstants.XBOX_PORT);
  public static Joystick JoystickController = new Joystick(OIConstants.JOYSTICK_PORT);

  public static Timer timer = new Timer();
  
  SendableChooser<CommandBase> m_chooser = new SendableChooser<>();
  SendableChooser<CommandBase> winch_chooser = new SendableChooser<>();

  public boolean superCareful = false;


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
    // BUILD AUTONOMOUS OPTIONS
    SmartDashboard.putData("Auto mode", m_chooser);

    SmartDashboard.putData("Pull winch back", new ClimbDown());

    // SET DEFAULT COMMANDS
    drivymcDriveDriverson.setDefaultCommand(new DriveCommand());
  }
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////*** XBOX BINDINGS ***///////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    // X button
    // new JoystickButton(XboxController, Button.kX.value)
    // .whenPressed(new DriveSquareUp());
    
    // // B button
    // new JoystickButton(XboxController, Button.kB.value)
    // .whenPressed(new DriveToAngle(180));

    // // A button
    // new JoystickButton(XboxController, Button.kA.value)
    // .whenPressed(new DriveToAngle(90));

    // // Y button
    // new JoystickButton(XboxController, Button.kY.value)
    // .whenPressed(new DriveToAngle(270));

    // Right bumper
    new JoystickButton(XboxController, Button.kBumperRight.value)
    .whenPressed(() -> {
    }); 

    // Left bumper
    // new JoystickButton(XboxController, Button.kBumperLeft.value)
    // .whenPressed(() -> {
    //   drivymcDriveDriverson.superCareful = !drivymcDriveDriverson.superCareful;
    //   SmartDashboard.putBoolean("superCareful", drivymcDriveDriverson.superCareful);
    // });

    // Left Stick
    new JoystickButton(XboxController, Button.kStickLeft.value)
    .whenPressed(() -> {
      CommandScheduler.getInstance().cancelAll();
    });

    // Right Stick
    new JoystickButton(XboxController, Button.kStickRight.value)
    .whenPressed(() -> {
      CommandScheduler.getInstance().cancelAll();
    });

    ///////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////*** JOYSTICK BINDINGS ***/////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    new JoystickButton(JoystickController, 1)
    .whileHeld(new Throw());

    new JoystickButton(JoystickController, 3)
    .whenPressed( new CameraUp() ); 

    new JoystickButton( JoystickController, 4 )
    .whenPressed( new CameraDown() );

    // new JoystickButton(JoystickController, 3)
    // .whenPressed( new BeSuperCareful() );

    // new JoystickButton(JoystickController, 4)
    // .whenHeld(new ClimbElevatorDown(false));

    // new JoystickButton(JoystickController, 5)
    // .whileHeld(new ButtBackwardSpin());

    // new JoystickButton(JoystickController, 6)
    // .whenHeld(new ButtForwardSpin());

    // new JoystickButton(JoystickController, 7)
    // .whenHeld(new ClimbElevatorDown(true));

    // new JoystickButton(JoystickController, 11)
    // .whenHeld(new ClimbUp());
  }

  public void beSuperCareful(){

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {

    return m_chooser.getSelected();

  }
}
