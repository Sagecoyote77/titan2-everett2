package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.OIConstants;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class PunchCan extends CommandBase {
    
    public static Joystick joystickController = new Joystick(OIConstants.JOYSTICK_PORT);

    private SpeedController punch = RobotContainer.canPuncher.puncherGroup;
    
    public PunchCan() {
        addRequirements( RobotContainer.canPuncher );
    }

    @Override
  public void initialize() { 
    
  }

  @Override
  public void execute(){
    punch.set( -0.08 );
  }

  @Override
  public boolean isFinished(){
      return false;
  }

  @Override
  public void end( boolean interrupted ){
      punch.stopMotor();
  }

}
