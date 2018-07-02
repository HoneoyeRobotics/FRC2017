/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3951.kjr2017.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

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
	public static final int BALL_FEEDER_MOTOR_ID = 2;
	public static final int BALL_SHOOTER_MOTOR_CANID = 11; // Talon SRX
		
	public static final double GYRO_ROTATE_MAX_SPEED = 0.7;
	public static final double GYRO_ROTATE_MIN_SPEED = 0.6;
	public static final double GYRO_ROTATE_SLOW_FACTOR = 60;
	
	public static final double WHEEL_DIAMETER = 6;
	public static final int ENCODER_UNITS_PER_REVOLUTION = 4096;
	public static final double DRIVE_DISTANCE_Y_FACTOR = 0;
	public static final double DRIVE_DISTANCE_SPEED = 0.6; 
	public static final double ROTATE_DEGREES_DEADBAND = 8;
		
	public enum Direction {
		 LEFT,
		 RIGHT
		}
	
	
	
	public static void init() {
		//constructors for motors/sensors
		
		
		
	}
	
}



