
package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Drive;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  private DriveTrain driveTrain = new DriveTrain();
  private Joystick controller = new Joystick(0);
  Shooter shooter = new Shooter();

  public RobotContainer() {
    configureBindings();
  }
  
  private void configureBindings() {
    driveTrain.setDefaultCommand(new Drive(controller, driveTrain));

    new JoystickButton(controller, 1).whileTrue(new Shoot(shooter));
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
