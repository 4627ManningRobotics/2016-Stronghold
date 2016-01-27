package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGroup extends CommandGroup {

	public AutonomousGroup() {

		switch (Robot.defenceValueInt) {

		case 1:
			addSequential(new AutoDoNothing());
			break;
		case 2:
			addSequential(new RampartsAuto());
			break;
		case 3:
			addSequential(new RockWallAuto());
			break;
		case 4:
			addSequential(new LowBar());
			break;
		}

		switch (Robot.defencePlacementInt) {

		case 1:
			addSequential(new Placement1());
			break;
		case 2:
			addSequential(new Placement2());
			break;
		case 3:
			addSequential(new Placement3());
			break;
		case 4:
			addSequential(new Placement4());
			break;
		case 5:
			addSequential(new Placement5());
			break;
		}
	}
}
