
package org.usfirst.frc.team3008.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;

import org.usfirst.frc.team3008.robot.commands.ExampleCommand;
import org.usfirst.frc.team3008.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	RobotDrive Bot = new RobotDrive(0, 1, 2, 3); // numbers are channel numbers  
	// (frontLeft, backLeft, frontRight, backRight)
	Joystick stick = new Joystick(0);// number = usb port # on driver station
	final String CenterAuto = "CenterAuto";
	final String LeftAuto_red = "Left Auto [Red]";
	final String LeftAuto_blue = "Left Auto [Blue]";
	final String RightAuto_red = "Right Auto [Red]";
	final String RightAuto_blue = "Right Auto [Blue]";


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	/*	
		chooser.addDefault("Default Auto (Center Auto)", CenterAuto);
		chooser.addObject("Left Auto [Red]", LeftAuto_red );
		chooser.addObject("Left Auto [Blue]", LeftAuto_blue);
		chooser.addObject("Right Auto [Red]", RightAuto_red);
		chooser.addObject("Right Auto [Blue]", RightAuto_blue);
		SmartDashboard.putData("Auto modes", chooser); // move this into commands
	*/	
    	try{
    	CameraServer.getInstance().startAutomaticCapture();
    	System.out.println( "Cam0");
    	}catch
    		(Exception e) {
    		System.out.println();
    		}
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		return;
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		Bot.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			Timer.delay(0.005); // wait for a motor update time
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		while(isTest() && isEnabled()){
			LiveWindow.run();
			Timer.delay(0.1);
		}
	}
}
