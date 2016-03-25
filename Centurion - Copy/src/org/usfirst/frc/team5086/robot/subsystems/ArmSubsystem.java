package org.usfirst.frc.team5086.robot.subsystems;

import org.usfirst.frc.team5086.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
    
	public static Talon BallShotA = new Talon(RobotMap.ballIntakeMotorControllerA);
	public static Talon BallShotB = new Talon(RobotMap.ballIntakeMotorControllerB);
	public static Solenoid Shooter = new Solenoid(1, RobotMap.fireSolenoid);
	public static Solenoid Altitude = new Solenoid(1, RobotMap.altitudeSolenoid);
	public static Solenoid fattie = new Solenoid(1, RobotMap.fatSolenoid);
    USBCamera main = new USBCamera("cam0");
    USBCamera secondary = new USBCamera("cam0");
	
    public void initDefaultCommand() {
    	
    }
    
    /**
     * Set The Speeds of the miniSims on the end of the Arms.
     * 
     * @param speed The speed you would like them to Rotate at. 1 = 100%
     * 
     * @author Josh
    **/
    public void setArmSpeeds(double speed) {
    	BallShotA.set(speed);
    	BallShotB.set(-speed);
    }
    
    public void shootBall(boolean state) {
    	Shooter.set(state);
    }
    
    public void armAltitudeChange(boolean state) {
    	Altitude.set(state);
    }
    
    public void fattieChanger(boolean state) {
    	fattie.set(state);
    }
    
}

