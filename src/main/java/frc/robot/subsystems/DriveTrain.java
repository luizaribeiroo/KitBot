// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private WPI_TalonSRX rightMaster = new WPI_TalonSRX(1);
  private WPI_TalonSRX rightSlave = new WPI_TalonSRX(2);
  private WPI_TalonSRX leftMaster = new WPI_TalonSRX(3);
  private WPI_TalonSRX leftSlave = new WPI_TalonSRX(4);
  
  private DifferentialDrive diffDrive = new DifferentialDrive(leftMaster, rightMaster);

  public DriveTrain() {
      rightSlave.follow(rightMaster);
      leftSlave.follow(leftMaster);

      leftMaster.setInverted(false);
      leftSlave.setInverted(true);
      rightMaster.setInverted(false);
      rightSlave.setInverted(false);

      SmartDashboard.putNumber("Speed:", 0);
      SmartDashboard.putNumber("Rotation:", 0);
  }

  public void drive(double speed, double rotation){
    diffDrive.arcadeDrive(speed, rotation);

    SmartDashboard.putNumber("Speed:", speed);
    SmartDashboard.putNumber("Rotation:", rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
