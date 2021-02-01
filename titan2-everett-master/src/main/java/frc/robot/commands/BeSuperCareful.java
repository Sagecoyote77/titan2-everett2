/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class BeSuperCareful extends CommandBase{

    public boolean superCareful = false;

    public BeSuperCareful(){
    }

    public void beCareful(){
        this.superCareful = !this.superCareful;
    }

}