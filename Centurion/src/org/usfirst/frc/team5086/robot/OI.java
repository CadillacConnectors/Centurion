package org.usfirst.frc.team5086.robot;

import org.usfirst.frc.team5086.robot.commands.actions.ChangeTheFattie;
import org.usfirst.frc.team5086.robot.commands.actions.EveryBodiesBucketsGoUp;
import org.usfirst.frc.team5086.robot.commands.actions.ShootMe;
import org.usfirst.frc.team5086.robot.commands.actions.Turbo;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public Joystick JoyDrive = new Joystick (0);
	public Joystick JoySpecial = new Joystick (1);
    Button shooter = new JoystickButton(JoySpecial, 1);
    Button bucketMoveUpper = new JoystickButton(JoySpecial, 6);
    Button bucketBuster = new JoystickButton(JoySpecial, 5);
    Button fatOut = new JoystickButton(JoySpecial, 3);
    Button fatIn = new JoystickButton(JoySpecial, 2);
    Button superSanikSpedActivate = new JoystickButton(JoyDrive, 1);
    Button changeToMain = new JoystickButton(JoyDrive, 3);
    Button changeToAlt = new JoystickButton(JoyDrive, 4);
    
    public OI() {
        shooter.whenPressed(new ShootMe(true));
        shooter.whenReleased(new ShootMe(false));
        bucketMoveUpper.whenPressed(new EveryBodiesBucketsGoUp(true));
        bucketBuster.whenPressed(new EveryBodiesBucketsGoUp(false));
        fatOut.whenPressed(new ChangeTheFattie(true));
        fatIn.whenPressed(new ChangeTheFattie(false));
        superSanikSpedActivate.whenPressed(new Turbo());
    }
}

