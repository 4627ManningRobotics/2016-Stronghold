package org.usfirst.frc.team4627.robot;
import org.usfirst.frc.team4627.robot.commands.ShiftHigh;
import org.usfirst.frc.team4627.robot.commands.ShiftLow;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

//Declaring Joysticks
Joystick driver = new Joystick(RobotMap.DRIVER_JOYSTICK);
//Joystick operator = new Joystick(RobotMap.OPERATOR_JOYSTICK);
Button a = new JoystickButton(driver, RobotMap.BUTTON_A);
Button b = new JoystickButton(driver, RobotMap.BUTTON_B);

public OI () {

	a.whenPressed(new ShiftHigh());
	b.whenPressed(new ShiftLow());
	
}

//Getting axis values
public double driverAxisValue(int axis) {
	
	return driver.getRawAxis(axis);
	
}

/*public double operatorAxisValue(int axis) {
	
	return operator.getRawAxis(axis);
	
}
*/
	
}

