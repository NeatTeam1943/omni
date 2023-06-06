// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ChassisConstants;

public class Chassis extends SubsystemBase {
  private VictorSP m_top;
  private VictorSP m_bottom;
  private VictorSP m_left;
  private VictorSP m_right;

  public Chassis() {
    m_top = new VictorSP(ChassisConstants.kTopMotor);
    m_bottom = new VictorSP(ChassisConstants.kBottomMotor);
    m_left = new VictorSP(ChassisConstants.kLeftMotor);
    m_right = new VictorSP(ChassisConstants.kRightMotor);
  }

/* 
 * Get: CommandXboxController -> instant of the Xbox controller class
 * 
 * Outpot: Nothing | Calles the setXSpeed setYSpeed functions and updates the speed controllers
 */
 public void move(CommandXboxController joystick){
  double ySpeed = -joystick.getLeftY();
  double xSpeed = joystick.getRightX(); 
    
  setXSpeed(xSpeed);
  setYSpeed(ySpeed);
 }
 
/* 
 * Get: speed -> value from the X value of the joystick | ranges from -1 - 1
 * 
 * Outpot: Nothing | Set the speed of the top and bottom speed controllers
 */
 private void setXSpeed(double speed){
  m_top.set(speed);
  m_bottom.set(speed);
 }

 /* 
 * Get: speed -> value from the Y value of the joystick | ranges from -1 - 1
 * 
 * Outpot: Nothing | Set the speed of the top and bottom speed controllers
 */
 private void setYSpeed(double speed){
  m_right.set(speed);
  m_left.set(speed);
 }
}
