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

    public static int xBUTTON_NUM = 3;
    public static int aBUTTON_NUM = 1;
    public static int bBUTTON_NUM = 2;
    public static int yBUTTON_NUM = 4;
    public static int LEFTSTICKCLICK_NUM = 9;
    public static final int XBOX_PORT = 0;
    public static final int JOYSTICK_PORT = 1;

  }

  public static final class PWDConstants {

    // DRIVE
    public static int FRONT_RIGHT = 7;
    public static int BACK_RIGHT = 4;
    public static int FRONT_LEFT = 3;
    public static int BACK_LEFT = 2;

    // DUMP
    public static int DUMPER_LEFT_SERVO = 0;
    public static int DUMPER_RIGHT_SERVO = 5;

    // CLIMB
    public static int WINCH = 6;
    public static int ELEVATOR = 1;
    
    // BUTT WHEEL
    public static int BUTT_WHEEL = 8;
  
  }

  public static final class MathConstants {

    public static double ANGLE_TOLERANCE = 2.0;

  }

  public static final class DIOConstants{
    public static int ELEVATOR_ENC_A = 1;
    public static int ELEVATOR_ENC_B = 2; 
    // public static int DIO_LIMITUP = 4;
    // public static int DIO_LIMITDOWN = 5;

  }

  
}
