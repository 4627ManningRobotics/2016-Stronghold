package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GTADrive extends Command {

    public GTADrive() {
    
    requires(Robot.driveTrain);
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   
    double rightTrigger = Robot.oi.driverAxisValue(RobotMap.RIGHT_TRIGGER);
    double leftTrigger = Robot.oi.driverAxisValue(RobotMap.LEFT_TRIGGER);
    double xAxis = Robot.oi.driverAxisValue(RobotMap.LEFT_JOYSTICK_X_AXIS);
    
    double leftMotorSpeed = (rightTrigger - leftTrigger + xAxis)*RobotMap.GTA_ROBOT_SPEED_SCALING;
    double rightMotorSpeed = (rightTrigger - leftTrigger - xAxis)*RobotMap.GTA_ROBOT_SPEED_SCALING*(-1);
    
    if (leftMotorSpeed < RobotMap.GTA_MIN_ROBOT_SPEED) {	
    leftMotorSpeed = RobotMap.GTA_MIN_ROBOT_SPEED;
    }
    if (leftMotorSpeed > RobotMap.GTA_MAX_ROBOT_SPEED) {
    leftMotorSpeed = RobotMap.GTA_MAX_ROBOT_SPEED;
    }
    if (rightMotorSpeed < RobotMap.GTA_MIN_ROBOT_SPEED) {
    rightMotorSpeed = RobotMap.GTA_MIN_ROBOT_SPEED;
    }
    if (rightMotorSpeed > RobotMap.GTA_MAX_ROBOT_SPEED) {
    rightMotorSpeed = RobotMap.GTA_MAX_ROBOT_SPEED;
    }

    Robot.driveTrain.setLeftMotors(leftMotorSpeed);
    Robot.driveTrain.setRightMotors(rightMotorSpeed);
    
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
