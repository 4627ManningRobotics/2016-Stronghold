package org.usfirst.frc.team4627.robot.subsystems;
import org.usfirst.frc.team4627.robot.RobotMap;
import org.usfirst.frc.team4627.robot.commands.ActivateDriving;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

//Declaring Motors
CANJaguar topLeftMotor = new CANJaguar(RobotMap.TOP_LEFT_MOTOR);
CANJaguar topRightMotor = new CANJaguar(RobotMap.TOP_RIGHT_MOTOR);
CANJaguar bottomLeftMotor = new CANJaguar(RobotMap.BOTTOM_LEFT_MOTOR);
CANJaguar bottomRightMotor = new CANJaguar(RobotMap.BOTTOM_RIGHT_MOTOR);
Solenoid gearShifter = new Solenoid(RobotMap.GEAR_SHIFTER);

public void shiftGear(boolean gear) {
	
	gearShifter.set(gear);
	
}

//Setting the speed of motors
public void setLeftMotors(double speed) {
	
	topLeftMotor.set(speed);
	bottomLeftMotor.set(speed);
	
}

public void setRightMotors(double speed) {
	
	topRightMotor.set(speed);
	bottomRightMotor.set(speed);
}
	

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
    	setDefaultCommand(new ActivateDriving());
    
    }
}

