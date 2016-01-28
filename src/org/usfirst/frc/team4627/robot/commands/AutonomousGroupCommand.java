package org.usfirst.frc.team4627.robot.commands;
import org.usfirst.frc.team4627.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousGroupCommand extends Command {
	
	Command autonomousPlacementCommand;
	Command autonomousDefenceCommand;

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
			autonomousDefenceCommand = new AutoDoNothing();
			break;
		case 2:
			autonomousDefenceCommand = new RampartsAuto();
			break;
		case 3:
			autonomousDefenceCommand = new RockWallAuto();
			break;
		case 4:
			autonomousDefenceCommand = new LowBar();
			break;
		case 5:
			autonomousDefenceCommand = new RoughTerrainAuto();
		}
    		autonomousDefenceCommand.start();

		switch (Robot.defencePlacementInt) {

		case 1:
			autonomousPlacementCommand = new Placement1();
			break;
		case 2:
			autonomousPlacementCommand = new Placement2();
			break;
		case 3:
			autonomousPlacementCommand = new Placement3();
			break;
		case 4:
			autonomousPlacementCommand = new Placement4();
			break;
		case 5:
			autonomousPlacementCommand = new Placement5();
			break;
		}
		
		autonomousPlacementCommand.start();
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
