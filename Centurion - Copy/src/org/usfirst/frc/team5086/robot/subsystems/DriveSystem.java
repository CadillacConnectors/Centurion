package org.usfirst.frc.team5086.robot.subsystems;

import org.usfirst.frc.team5086.robot.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSystem extends Subsystem {
	
	public static Victor LeftDrive = new Victor(RobotMap.leftMotorController);
	public static Victor RightDrive = new Victor(RobotMap.rightMotorController);
	public static double driftReduction = RobotMap.maximumDrifting;
	public static double turnReduction = RobotMap.turnReduction;
	public double currentSpeed;
	
    public void initDefaultCommand() {
    
    }
    
    public void turn(double Yaxis, double Xaxis) {
    	if (Xaxis < 0) {
        	LeftDrive.set(-Yaxis*driftReduction);
        	RightDrive.set(-Yaxis);
    	}
    	if (Xaxis > 0) {
    		LeftDrive.set(-Yaxis);
        	RightDrive.set(-Yaxis*driftReduction);
    	}
    }
    
    public void mainDrive(double Yaxis, double Xaxis) {
    	double endMovementLeft = Yaxis;
    	double endMovementRight = Yaxis;
    	if (Xaxis > 0) {
    		endMovementRight = (Yaxis*(1-(Xaxis*driftReduction)));
    	}
    	if (Xaxis < 0) {
    		endMovementLeft = (Yaxis*(1+(Xaxis*driftReduction)));
    	}
    	if (endMovementLeft > 0) {
    		LeftDrive.set(-endMovementLeft);
    		RightDrive.set(endMovementRight);
    	}
    	else {
    		LeftDrive.set(-endMovementLeft*.75);
    		RightDrive.set(endMovementRight*.75);
    	}
    }
    
    public void hardTurn(double Xaxis) {
    	LeftDrive.set(Xaxis*turnReduction);
    	RightDrive.set(Xaxis*turnReduction);
    }
    
    public void forward(double speed) {
        LeftDrive.set(-speed);
        RightDrive.set(speed);
    }
        
    public void stop() {
        LeftDrive.set(0);
        RightDrive.set(0);
    }
    
    public void turbo() {
    	currentSpeed = RightDrive.get();
    	if (currentSpeed < -.3) {
    		LeftDrive.set(1);
    		RightDrive.set(-1);
    	}
    }
}

