package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DrivingChoiceActivating extends CommandGroup {
    
    public  DrivingChoiceActivating() {
       
    switch (Robot.driveTypeInt) {
    
    case 1:
    	addSequential(new GTADrive());
    case 2:
    	addSequential(new TankDrive());
    case 3:
    	addSequential(new ArcadeDrive());
    
    }
    	
    }
}
