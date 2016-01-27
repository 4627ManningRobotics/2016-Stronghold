package org.usfirst.frc.team4627.robot.commands;
import org.usfirst.frc.team4627.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGroup extends CommandGroup {
    
    public  AutonomousGroup() {
    	
    switch (Robot.defenceValueInt) {
   
    case 1:
        addSequential(new AutoDoNothing());
    case 2:
        addSequential(new RampartsAuto());
    case 3:
        addSequential(new RockWallAuto());
    case 4:
        addSequential(new LowBar());
    }

    switch (Robot.defencePlacementInt) {
    
    case 1:
    	addSequential(new Placement1());
    case 2:
    	addSequential(new Placement2());
    case 3:
    	addSequential(new Placement3());
    case 4:
    	addSequential(new Placement4());
    case 5:
    	addSequential(new Placement5());
    }
    }
    }
