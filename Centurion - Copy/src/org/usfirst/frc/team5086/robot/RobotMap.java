package org.usfirst.frc.team5086.robot;
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
	
	
	//Solenoids
		public static int fireSolenoid = 1;
		public static int altitudeSolenoid = 0;
		public static int fatSolenoid = 2;
	
	//Pwm
		public static int rightMotorController = 4;
		public static int leftMotorController = 0;
		public static int ballIntakeMotorControllerA = 2; //Left
		public static int ballIntakeMotorControllerB = 3; //Right
		
		
	//Other Variables
		public static double maximumDrifting = .75;
		public static double turnReduction = .75;
		public static double controllerDeadZoneArea = .2;
		public static double triggerRequirement = .5;
		public static double loadSpeed = .35;
		public static boolean turning = false;
		public static double leftDecrease = 1;
		public static double rightDecrease = 1;
		
		public static int timesIveWantedToKillMySelfWhileCodeingThis = 8;
}
