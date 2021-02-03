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
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants.OIConstants;
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
  public static Drive driveTrain = new Drive();
  public static Thrower thrower = new Thrower();
  public static CameraNetwork camServo = new CameraNetwork();
  public static Elevator extendor = new Elevator();
  //public static Intaker scoop = new Intaker();
  
  public static Joystick joystickController = new Joystick(OIConstants.JOYSTICK_PORT);

  public static Timer timer = new Timer();
  
  SendableChooser<CommandBase> m_chooser = new SendableChooser<>();
  SendableChooser<CommandBase> winch_chooser = new SendableChooser<>();


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
    // BUILD AUTONOMOUS OPTIONS
    SmartDashboard.putData("Auto mode", m_chooser);

    //SmartDashboard.putData("Pull winch back", new ClimbDown());

    // SET DEFAULT COMMANDS
    driveTrain.setDefaultCommand(new DriveCommand());
    camServo.setDefaultCommand( new CameraCommand() );
  }
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {


    ///////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////*** JOYSTICK BINDINGS ***/////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    new JoystickButton( joystickController, 1 )
    .whileHeld(new Throw());

    // new JoystickButton( joystickController, 2 )
    // .whileHeld( new Intake() );

    new JoystickButton( joystickController, 3 )
    .whileHeld( new Elevation() );

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
