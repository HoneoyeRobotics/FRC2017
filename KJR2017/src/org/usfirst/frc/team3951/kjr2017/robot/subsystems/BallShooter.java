package org.usfirst.frc.team3951.kjr2017.robot.subsystems;

import org.usfirst.frc.team3951.kjr2017.robot.Robot;
import org.usfirst.frc.team3951.kjr2017.robot.RobotMap;
import org.usfirst.frc.team3951.kjr2017.robot.commands.ArcadeDriveWithJoystick;

import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class BallShooter extends Subsystem {

	
	private WPI_TalonSRX ballShooterMotor = new WPI_TalonSRX(RobotMap.BALL_SHOOTER_MOTOR_CANID);
	private Spark ballFeedMotor = new Spark(RobotMap.BALL_FEEDER_MOTOR_ID);
	
	public BallShooter() {
		super("BallShooter");		
	}
	
	public void FeedBalls() {
		ballFeedMotor.set(.5);
	}
	
	public void ShootBalls() {
		ballShooterMotor.set(1);
	}
	
	public int getBallShooterPosition()	{
		return ballShooterMotor.getSelectedSensorVelocity(0);
	}
	public int getBallShooterVelocity()	{
		return ballShooterMotor.getSelectedSensorVelocity(0);
	}

	
	public void stop() {
		ballShooterMotor.stopMotor();
		ballFeedMotor.stopMotor();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}	
}
