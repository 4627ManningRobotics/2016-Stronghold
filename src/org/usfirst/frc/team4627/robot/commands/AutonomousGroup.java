package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGroup extends CommandGroup {
    
    public  AutonomousGroup() {
    	
    if (Robot.defenceValueInt == 1) {
    	
    addSequential(new AutoDoNothing());
    	
    }
    
    if (Robot.defenceValueInt == 2) {
    	
    addSequential(new RampartsAuto());
    	
    }
    
    if (Robot.defenceValueInt == 3) {
    	
    addSequential(new RockWallAuto());
    	
    }
    
    if (Robot.defenceValueInt == 4) {
    	
    addSequential(new LowBar());
    	
    }

    }
}
