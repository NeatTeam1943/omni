// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ChassisConstants;

/**
 * The Chassis subsystem represents the robot's chassis or drivetrain.
 * It controls the movement of the robot based on input from an Xbox controller.
 */
public class Chassis extends SubsystemBase {

  private VictorSP m_top;
  private VictorSP m_bottom;
  private VictorSP m_left;
  private VictorSP m_right;

  /**
   * Constructs a new Chassis object.
   * Initializes the speed controllers for the top, bottom, left, and right motors.
   */
  public Chassis() {
    m_top = new VictorSP(ChassisConstants.kTopMotor);
    m_bottom = new VictorSP(ChassisConstants.kBottomMotor);
    m_left = new VictorSP(ChassisConstants.kLeftMotor);
    m_right = new VictorSP(ChassisConstants.kRightMotor);
  }
  
  /**
   * Moves the chassis based on input from the Xbox controller.
   * If the right joystick is pressed, it drives with both spin and movement.
   * Otherwise, it drives normally with the Y and X speeds.
   *
   * @param joystick the Xbox controller instance to get input from
   */
  public void move(CommandXboxController joystick) {
    double ySpeed = -joystick.getLeftY();
    double xSpeed = joystick.getLeftX();
    double spinSpeed = joystick.getRightX();

    // Adjust the spin speed if the Y or X speeds are not zero
    if (Math.abs(ySpeed) > 0.1 || Math.abs(xSpeed) > 0.1) {
      spinSpeed *= 0.5; // Reduce the spin speed when moving in a direction
    }

    setYSpeed(ySpeed + spinSpeed);
    setXSpeed(xSpeed + spinSpeed);
  }


  /**
   * Sets the speed of the top and bottom speed controllers.
   *
   * @param speed the value from the X value of the joystick (-1 to 1)
   */
  private void setXSpeed(double speed) {
    m_top.set(-speed);
    m_bottom.set(speed);
  }

  /**
   * Sets the speed of the left and right speed controllers.
   *
   * @param speed the value from the Y value of the joystick (-1 to 1)
   */
  private void setYSpeed(double speed) {
    m_right.set(-speed);
    m_left.set(speed);
  }
}

