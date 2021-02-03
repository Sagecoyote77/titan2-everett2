/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class Constants {
  
  public static final class OIConstants {

    public static final int JOYSTICK_PORT = 1;

  }

  public static final class PWDConstants {

    // DRIVE
    public static int FRONT_RIGHT = 7;
    public static int BACK_RIGHT = 4;
    public static int FRONT_LEFT = 3;
    public static int BACK_LEFT = 2;

    //THROWER
    public static int LEFT_THROWER = 5;
    public static int RIGHT_THROWER = 6;

    //CAMERA SERVO
    public static int CAMSERVO = 8;

    //ELEVATOR
    public static int ELEVATOR = 1;
  
  }

  public static final class MathConstants {

    public static double ANGLE_TOLERANCE = 2.0;

  }
  
}
