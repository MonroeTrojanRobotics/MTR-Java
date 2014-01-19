/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    RobotDrive myDrive;
    Joystick moveStick;
    
    /**
	*This initializes the motors and controls.
	**/
    public void robotInit() {
        myDrive = new RobotDrive(1, 2, 3, 4);
        moveStick = new Joystick(1);
    }
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        myDrive.setSafetyEnabled(false);
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while (isOperatorControl() && isEnabled()) {
            myDrive.setSafetyEnabled(true);
            myDrive.mecanumDrive_Cartesian(bufferMove(1), bufferMove(2), bufferMove(4), 0.0);
            Timer.delay(0.01);
       
    }
    
}    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
    
    
	/**
	* This function buffers the moveStick.getRawAxis() input.
        * @param axisNum The ID for the axis in moveStick.
        * @return moveOut - The buffered axis data from moveStick.getRawAxis().
	**/
    public double bufferMove(int axisNum) {
        double moveIn = moveStick.getRawAxis(axisNum);
        double moveOut;
       
        if(moveIn >= -5.0 && moveIn <= 5.0) {
         moveOut = 0.0;
        }
        else{
         moveOut = moveStick.getRawAxis(axisNum);
        }
	
	return moveOut;
   }
    
    
} 
      




