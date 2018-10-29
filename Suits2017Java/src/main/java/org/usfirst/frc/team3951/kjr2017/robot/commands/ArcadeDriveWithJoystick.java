package org.usfirst.frc.team3951.kjr2017.robot.commands;

import org.usfirst.frc.team3951.kjr2017.robot.OI;
import org.usfirst.frc.team3951.kjr2017.robot.Robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArcadeDriveWithJoystick extends  Command {

	private Joystick joystick;
	public ArcadeDriveWithJoystick(Joystick joystick) {
		super("Arcade Drive With Joystick");
		requires(Robot.drivetrain);
		this.joystick = joystick;
		System.out.println("Starting Arcade Drive...");
	}
	
	@Override 
	protected void execute() {
		//Robot.drivetrain.tankDrive(Robot.oi.getDriverJoystick());
		double forwardSpeed = joystick.getRawAxis(OI.DRIVER_FORWARD_AXIS) * -1;
		//double leftButton = joystick.getRawAxis(OI.DRIVER_ROTATE_LEFT_AXIS);
		//double rightButton = joystick.getRawAxis(OI.DRIVER_ROTATE_RIGHT_AXIS);		
		//double turnSpeed = leftButton - rightButton;
		
		double turnSpeed = joystick.getRawAxis(OI.DRIVER_TURN_AXIS);

		if(Robot.drivetrain.isDriveReversed())
		{			
			forwardSpeed *= -1;
		}
			
			
		/*boolean SlowPressed = joystick.getRawButton(Robot.oi.SLOW_SPEED_BUTTON);
		if(SlowPressed) {
			forwardSpeed *= 0.5;
			turnSpeed *= 0.5;
		}*/
		//WRITE MOTOR VALUES TO NETWORK TABLES WITH ITERATION, Robot.recordCounter;
		SmartDashboard.putNumber("Drive Forward Speed", forwardSpeed);
		SmartDashboard.putNumber("Turn Speed", turnSpeed);
		SmartDashboard.putNumber("Gyro Angle", Robot.drivetrain.getGyroAngle());
		SmartDashboard.putNumber("Left Encoder Value", Robot.drivetrain.getLeftMotorPosition());
		SmartDashboard.putNumber("Right Encoder Value", Robot.drivetrain.getRightMotorPosition());
		SmartDashboard.putNumber("Turn Speed", turnSpeed);
		Robot.drivetrain.arcadeDrive(forwardSpeed, turnSpeed);
	}
	
	@Override
	protected boolean isFinished() {
		//this command is never finished so that it will always run.
		return false;
	}
	
	@Override
	protected void end() {
		Robot.drivetrain.stop();
	}

}
