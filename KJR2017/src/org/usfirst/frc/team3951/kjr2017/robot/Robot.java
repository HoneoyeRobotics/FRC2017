/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3951.kjr2017.robot;
import org.usfirst.frc.team3951.kjr2017.robot.OI;
import org.usfirst.frc.team3951.kjr2017.robot.RobotMap;
import org.usfirst.frc.team3951.kjr2017.robot.commands.ShootBalls;
import org.usfirst.frc.team3951.kjr2017.robot.commands.PickUpBalls;
import org.usfirst.frc.team3951.kjr2017.robot.commands.GyroReset;
import org.usfirst.frc.team3951.kjr2017.robot.subsystems.BallPickup;
import org.usfirst.frc.team3951.kjr2017.robot.subsystems.BallShooter;
import org.usfirst.frc.team3951.kjr2017.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends TimedRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";

	public static int recordCounter = 0;
	public static boolean recordMode = false;
	public Command autonomousCommand;	
	private SendableChooser<String> chooser = new SendableChooser<>();

	//public static Camera camera;
	public static OI oi;
	public static Drivetrain drivetrain;
	public static BallShooter ballshooter;
	public static BallPickup ballpickup;
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		//initialize subsystems first!!
		drivetrain = new Drivetrain();		
		ballshooter = new BallShooter();
		ballpickup = new BallPickup();
		CameraServer.getInstance().startAutomaticCapture();
		//initialize interface second
		oi = new OI();	
		
		
		//camera = new Camera();
		//send data to dashboard
		chooser.addDefault("Default Auto", kDefaultAuto);
		chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData(Scheduler.getInstance());
		SmartDashboard.putData("Auto choices", chooser);
		SmartDashboard.putData(drivetrain);
		SmartDashboard.putData(ballshooter);
		SmartDashboard.putData(ballpickup);
		SmartDashboard.putNumber("Drive Forward Speed", 0);
		SmartDashboard.putNumber("Turn Speed", 0);
		SmartDashboard.putNumber("Gyro Angle", 0);
		SmartDashboard.putNumber("Left Encoder Value", 0);
		SmartDashboard.putNumber("Right Encoder Value", 0);
		SmartDashboard.putNumber("Ball Shooter Motor Speed", 0);
		
		SmartDashboard.putData("Feed Balls for 2 seconds", new PickUpBalls(2));
		SmartDashboard.putData("Shoot Balls 2 seconds", new ShootBalls(2));
		SmartDashboard.putData("Gyro Reset", new GyroReset());
		
	}

	@Override
	public void teleopPeriodic() {
		if(recordMode == true)
			recordCounter++;
		Scheduler.getInstance().run();
		
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
       // autonomousCommand = (Command)autoChooser.getSelected();
        //autonomousCommand.start();
    }
    
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

}
