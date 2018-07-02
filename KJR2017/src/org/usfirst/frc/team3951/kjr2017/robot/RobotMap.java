/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3951.kjr2017.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	
	
	//define IDs for the drive subsystem
	public static final int DRIVE_LEFT_FRONT_MOTOR_CANID = 3; // Talon SRX
	public static final int DRIVE_LEFT_REAR_MOTOR_CANID = 4; //Talon SRX
	public static final int DRIVE_RIGHT_FRONT_MOTOR_CANID = 1;	//Talon SRX
	public static final int DRIVE_RIGHT_REAR_MOTOR_CANID = 2; //Talon  SRX
	
	public static final int BALL_PICKUP_MOTOR_ID = 1; //spark pwm	
	public static final int BALL_FEEDER_MOTOR_ID = 2; //spark pwm
	public static final int BALL_SHOOTER_MOTOR_CANID = 11; // Talon SRX
		
	public static final int GEAR_MOTOR_ID = 3; //spark pwm
	public static final int GEAR_OPENED_SENSOR_ID = 1;
	public static final int GEAR_CLOSED_SENSOR_ID = 2;
	
	public static final int WINCH_MOTOR1_ID = 4; //spark pwm
	public static final int WINCH_MOTOR2_ID = 5; //spark pwm
		
	
}



