package org.usfirst.frc.team4627.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4627.robot.commands.AutonomousGroupCommand;
import org.usfirst.frc.team4627.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Compressor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static int defenceValueInt;
	
	public static final DriveTrain driveTrain = new DriveTrain();
	public static OI oi;
	
	public static int driveMode;
	
	public static int autoPlacementInt;
	
	public static Command runAutoDefense;
	
	public static Command runAutoPlace;
	
	
	public static Command autonomousPlacement;
	
	SendableChooser autoPlace;
	
	public static Command runAuto;
   public static Command autonomousDefence;
    
    public static SendableChooser autoType;
    
    
    public static Command drivingType;

	public static int defencePlacementInt;
	
	public static int driveTypeInt;
    
    SendableChooser driveType;

    
    Compressor com = new Compressor(RobotMap.COMPRESSOR_VALUE);
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		System.out.println("OI initialized");
		
		autoPlace = new SendableChooser();
		
		autoPlace.addDefault("1", 1);
		autoPlace.addObject("2", 2);
		autoPlace.addObject("3", 3);
		autoPlace.addObject("4", 4);
		autoPlace.addObject("5", 5);
		
		autoType = new SendableChooser();
		
		autoType.addDefault("Do Nothing", 1);
	    autoType.addObject("Ramparts", 2);
	    autoType.addObject("RockWall", 3);
	    autoType.addObject("Low Bar", 4);
	    autoType.addObject("Rough Terrain", 5);
	    
	    driveType = new SendableChooser();
	    
	    driveType.addDefault("GTA Drive", 1);
	    driveType.addObject("Tank Drive", 2);
	    driveType.addObject("Arcade Drive", 3);
	 
   
	    // autoValues = new SendableChooser();
      //  chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Choose Defence", autoType);
        SmartDashboard.putData("Choose Placement", autoPlace);
        SmartDashboard.putData("Choose Driving", driveType);
        
        com.setClosedLoopControl(true);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	
    	driveTypeInt = (int) driveType.getSelected() ;
    	defencePlacementInt = (int) autoPlace.getSelected();
    	defenceValueInt = (int) autoType.getSelected();
    	runAuto = new AutonomousGroupCommand();
/*
        
		 String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
 
	if (runAuto != null) runAuto.start();
 
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (runAuto != null) runAuto.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
