package org.usfirst.frc.team4627.robot.commands;
import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends Command {

    public TankDrive() {

    requires(Robot.driveTrain);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   double leftJoystick = (Robot.oi.driverAxisValue(RobotMap.LEFT_JOYSTICK_Y_AXIS))*RobotMap.TANK_DRIVE_CONTROLS_SCALING*(-1);
   double rightJoystick = (Robot.oi.driverAxisValue(RobotMap.RIGHT_JOYSTICK_Y_AXIS))*RobotMap.TANK_DRIVE_CONTROLS_SCALING;
   
   if (leftJoystick > RobotMap.TANK_DRIVE_MAX_SPEED) {
	   
	   leftJoystick = RobotMap.TANK_DRIVE_MAX_SPEED;
	   
   }
   
   if (leftJoystick < RobotMap.TANK_DRIVE_MIN_SPEED) {
	   
	   leftJoystick = RobotMap.TANK_DRIVE_MIN_SPEED;
	   
   }
   
   if (rightJoystick > RobotMap.TANK_DRIVE_MAX_SPEED) {
	   
	   rightJoystick = RobotMap.TANK_DRIVE_MAX_SPEED;
	   
   }
   
   if (rightJoystick < RobotMap.TANK_DRIVE_MIN_SPEED) {
	   
	   rightJoystick = RobotMap.TANK_DRIVE_MIN_SPEED;
	   
   }
   
   Robot.driveTrain.setLeftMotors(leftJoystick);
   Robot.driveTrain.setRightMotors(rightJoystick);
    
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
