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
    
    /*public void turn(double Yaxis, double Xaxis) {
    	RobotMap.turning = true;
    	if (Xaxis < 0) {
        	LeftDrive.set(-Yaxis*driftReduction);
        	RightDrive.set(-Yaxis);
    	}
    	if (Xaxis > 0) {
    		LeftDrive.set(-Yaxis);
        	RightDrive.set(-Yaxis*driftReduction);
    	}
    }*/
    
    public void mainDrive(double Yaxis, double Xaxis) {
    	double endMovementLeft = Yaxis;
    	double endMovementRight = Yaxis;
    	if (Xaxis > 0) {
    		endMovementRight = (Yaxis*(1-(Xaxis*driftReduction))*RobotMap.rightDecrease);
    	}
    	if (Xaxis < 0) {
    		endMovementLeft = (Yaxis*(1+(Xaxis*driftReduction))*RobotMap.leftDecrease);
    	}
    	if (endMovementLeft < 0) {
    		LeftDrive.set(-endMovementLeft);
    		RightDrive.set(endMovementRight);
    	}
    	else {
    		LeftDrive.set(-endMovementLeft*.75);
    		RightDrive.set(endMovementRight*.75);
    	}
    	
    	if (Math.abs(Xaxis) < RobotMap.controllerDeadZoneArea) {
    		RobotMap.turning = false;
    	}
    	else {
    		RobotMap.turning = true;
    	}
    }
    
    public void hardTurn(double Xaxis) {
    	LeftDrive.set(Xaxis*turnReduction);
    	RightDrive.set(Xaxis*turnReduction);
    	RobotMap.turning = true;
    }
    
    public void forward(double speed) {
        LeftDrive.set(-speed*RobotMap.leftDecrease);
        RightDrive.set(speed*RobotMap.rightDecrease);
        RobotMap.turning = false;
    }
    
    public void turbo() {
    	currentSpeed = RightDrive.get();
    	if (currentSpeed < -.3) {
    		LeftDrive.set(1*RobotMap.leftDecrease);
    		RightDrive.set(-1*RobotMap.rightDecrease);
    	}
    	RobotMap.turning = false;
    }
    
    public double getLeft() {
    	return -LeftDrive.get();
    }
    
    public double getRight() {
    	return RightDrive.get();
    }
    
    public void calculateReduction() {
    	if (RobotMap.turning = false) {
    		double leftSpeed = this.getLeft();
    		double rightSpeed = this.getRight();
    		
    		if ((leftSpeed < .99) && (rightSpeed < .99)) {
    			RobotMap.leftDecrease=RobotMap.leftDecrease+.01;
    			RobotMap.rightDecrease=RobotMap.rightDecrease+.01;
    		}
    		
    		if ((leftSpeed - rightSpeed) > .01) {
    			
    			if (RobotMap.rightDecrease <= .09) {
        			RobotMap.leftDecrease = RobotMap.leftDecrease-.01;
    			}
    			else {
        			RobotMap.rightDecrease = RobotMap.rightDecrease+.01;
    			}
    		}
    		
    		if ((rightSpeed - leftSpeed) > .01) {
    			
    			if (RobotMap.leftDecrease <= .09) {
        			RobotMap.rightDecrease = RobotMap.rightDecrease-.01;
    			}
    			else {
        			RobotMap.leftDecrease = RobotMap.leftDecrease+.01;
    			}
    		}
    		
    		if ((leftSpeed - rightSpeed) > .001) {
    			
    			if (RobotMap.rightDecrease == 1) {
        			RobotMap.leftDecrease = RobotMap.leftDecrease-.001;
    			}
    			else {
        			RobotMap.rightDecrease = RobotMap.rightDecrease+.001;
    			}
    		}
    		
    		if ((rightSpeed - leftSpeed) > .001) {
    			
    			if (RobotMap.leftDecrease == 1) {
        			RobotMap.rightDecrease = RobotMap.rightDecrease-.001;
    			}
    			else {
        			RobotMap.leftDecrease = RobotMap.leftDecrease+.001;
    			}
    		}
    	}
    }
}

