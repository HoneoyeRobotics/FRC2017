/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3951.kjr2017.robot;


import org.usfirst.frc.team3951.kjr2017.robot.commands.ShootBalls;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	
	//driver controller
	public static final int DRIVER_JOYSTICK_PORT = 0;
	private Joystick driverJoystick = new Joystick(DRIVER_JOYSTICK_PORT);
	public static final int DRIVER_FORWARD_AXIS = 1;
	public static final int DRIVER_ROTATE_LEFT_AXIS = 2;
	public static final int DRIVER_ROTATE_RIGHT_AXIS = 3;	
	public static final int REVERSE_DRIVE_BUTTON = 5; //r bumper
	public static final int SLOW_SPEED_BUTTON = 2; //x button
	public static final int BALL_SHOOTER_BUTTON = 1; //b button
	
	//co-pilot joystick
	public static final int COPILOT_JOYSTICK_PORT = 1;	
	private Joystick coPilotJoystick = new Joystick(COPILOT_JOYSTICK_PORT);
		
	
	public Joystick getDriverJoystick() {
		return driverJoystick;
	}
	
	public Joystick getCoPilotJoystick() {
		return coPilotJoystick;
	}
	
	
	public OI() {			
		new JoystickButton(driverJoystick, BALL_SHOOTER_BUTTON).whileHeld(new ShootBalls());					
	}
	
}
