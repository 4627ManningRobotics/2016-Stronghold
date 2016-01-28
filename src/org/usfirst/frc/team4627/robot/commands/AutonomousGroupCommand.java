package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class AutonomousGroupCommand extends Command {

    public AutonomousGroupCommand() {
        
    	requires(Robot.driveTrain);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		
    
    
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
  
    		switch (Robot.defenceValueInt) {

		case 1:
			Scheduler.getInstance().add(new AutoDoNothing());
			break;
		case 2:
			Scheduler.getInstance().add(new RampartsAuto());
			break;
		case 3:
			Scheduler.getInstance().add(new RockWallAuto());
			break;
		case 4:
			Scheduler.getInstance().add(new LowBar());
			break;
		case 5:
			Scheduler.getInstance().add(new RoughTerrainAuto());
		}

		switch (Robot.defencePlacementInt) {

		case 1:
			Scheduler.getInstance().add(new Placement1());
			break;
		case 2:
			Scheduler.getInstance().add(new Placement2());
			break;
		case 3:
			Scheduler.getInstance().add(new Placement3());
			break;
		case 4:
			Scheduler.getInstance().add(new Placement4());
			break;
		case 5:
			Scheduler.getInstance().add(new Placement5());
			break;
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
