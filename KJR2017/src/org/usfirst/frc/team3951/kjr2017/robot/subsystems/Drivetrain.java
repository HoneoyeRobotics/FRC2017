package org.usfirst.frc.team3951.kjr2017.robot.subsystems;

import org.usfirst.frc.team3951.kjr2017.robot.Robot;
import org.usfirst.frc.team3951.kjr2017.robot.RobotMap;
import org.usfirst.frc.team3951.kjr2017.robot.commands.ArcadeDriveWithJoystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain extends Subsystem {

	
	private WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(RobotMap.DRIVE_LEFT_1_MOTOR_CANID);
	private WPI_TalonSRX rearLeftMotor = new WPI_TalonSRX(RobotMap.DRIVE_LEFT_2_MOTOR_CANID);
	private SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
	
	private WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(RobotMap.DRIVE_RIGHT_1_MOTOR_CANID);
	private WPI_TalonSRX rearRightMotor = new WPI_TalonSRX(RobotMap.DRIVE_RIGHT_2_MOTOR_CANID);
	private SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(frontRightMotor, rearRightMotor);
	
	private DifferentialDrive drivetrain;
	private ADXRS450_Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);	
	private boolean drivingReversed;
	private double drivingModifier;
	
	public Drivetrain() {
		super("Drivetrain");		
		addChild("Front Left Motor", frontLeftMotor);
		addChild("Rear Left Motor", rearLeftMotor);
		addChild("Front Right Motor", frontRightMotor);
		addChild("Rear Right Motor", rearRightMotor);
		addChild("Gyro", gyro);			
		frontRightMotor.setInverted(true);
		rearRightMotor.setInverted(true);
		drivetrain = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
		drivingReversed = false;
		drivetrain.setExpiration(0.1);
		drivetrain.setMaxOutput(1.0);
		drivetrain.setSafetyEnabled(false);
		drivetrain.setDeadband(0.02);
		drivingModifier = 1;

		SmartDashboard.putNumber("Speed Mod", drivingModifier);
	}
	
	public boolean isDriveReversed() {
		return drivingReversed;
	}
	public void reverseDrivingDirection() {
		drivingReversed = !drivingReversed;
	}
	public int getLeftMotorPosition()	{
		return frontLeftMotor.getSelectedSensorPosition(0);
	}
	public int getLeftMotorVelocity()	{
		return frontLeftMotor.getSelectedSensorVelocity(0);
	}

	public int getRightMotorPosition()	{
		return frontRightMotor.getSelectedSensorPosition(0);
	}
	public int getRightMotorVelocity()	{
		return frontRightMotor.getSelectedSensorVelocity(0);
	}

	public void setDrivingModifier(double modifier)
	{

		drivingModifier = modifier;

		SmartDashboard.putNumber("Speed Mod", drivingModifier);
	}
	
	public void setFullSpeed() {
		drivingModifier = 1;

		SmartDashboard.putNumber("Speed Mod", drivingModifier);
	}
	public double getGyroRate() {
		return gyro.getRate();
	}
	
	public double getGyroAngle() {
		return gyro.getAngle();
	}
	
	public void gyroReset() {
		gyro.reset();
	}
	

	public void arcadeDrive(double xSpeed,double zRotation) {		
		SmartDashboard.putNumber("xSpeed", xSpeed);
		SmartDashboard.putNumber("zRotation", zRotation);
		//not sure why this is working?
		
		zRotation *= drivingModifier;
		xSpeed = xSpeed * drivingModifier;
		//drivetrain.arcadeDrive( zRotation, xSpeed);
		drivetrain.arcadeDrive( xSpeed, zRotation);
	}	
	
	public void stop() {
		drivetrain.stopMotor();
	}
	
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDriveWithJoystick(Robot.oi.getDriverJoystick()));
		
	}
}
