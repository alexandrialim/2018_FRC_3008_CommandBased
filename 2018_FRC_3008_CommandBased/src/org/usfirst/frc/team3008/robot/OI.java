package org.usfirst.frc.team3008.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.buttons.Button;

//AKA JoyStick 

import org.usfirst.frc.team3008.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	
	Joystick joy1;
	double x;
	double y;
	
	//setting sparks for motors:
	

 //   static Spark h = new Spark(claw); 				// Spark for Claw Motor
    
  /*  static TalonSRX FRT = new TalonSRX(frontRightDrive); // Talon SRX for Front Right Motor
    static TalonSRX BRT = new TalonSRX(backRightDrive); // Talon SRX for Back Right Motor
    static TalonSRX BLT = new TalonSRX(backLeftDrive); // Talon SRX for Back Left Motor 
    static TalonSRX FLT = new TalonSRX(frontLeftDrive); // Talon SRX for Front Left Motor
    static TalonSRX LT = new TalonSRX(lift); //TAlonSRX for lift
*/  
    
  
    // Set all motors to start at 0:
    double FR2=0;
    double FL2=0;
    double BR2=0;
    double BL2=0;
    double h2 = 0;
    
    //Run Teleop Code:
    public void run(){
    	joy1 = new Joystick(0);
    	x = joy1.getX();
    	y = joy1.getY();
    	
    	boolean buttonValue;
    	buttonValue = joy1.getTrigger();
    	
    	if(joy1.getRawButton(1) == true){
    		//s1.set(true);
    	}
    	while (true){
    		x = joy1.getRawAxis(0);
    		y = joy1.getRawAxis(1);
    		
		//	if (joy1.getRawButton(6))FRT.set(1); // FR motor (change later)
		//	else FRT.set(0);
    		    	//(look in RobotDrive.class)			
    	}
    }
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
