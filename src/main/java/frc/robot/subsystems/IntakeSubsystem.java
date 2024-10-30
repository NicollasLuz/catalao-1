package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import frc.robot.Constants.Intake;
import frc.robot.Constants.MotorId;

public class IntakeSubsystem extends SubsystemBase {
    
  public static CANSparkMax intakemotor1, intakemotor2;
  public static boolean limitswitch;
  public final DigitalInput m_limitSwitch;
  public final PIDController pid;
  private final DutyCycleEncoder encoder;

  public IntakeSubsystem(){
    
    intakemotor1 =
      new CANSparkMax(MotorId.INTAKE_PORT,MotorType.kBrushless);

    intakemotor2 =
      new CANSparkMax(MotorId.INTAKE2_PORT,MotorType.kBrushless);

      m_limitSwitch = new DigitalInput(0);
      encoder = new DutyCycleEncoder(2);
      pid = new PIDController(2.5, 0.0, 0);
      pid.setSetpoint(Intake.INSIDE_POSITION);
  }

  @Override
  public void periodic(){
    limitswitch = m_limitSwitch.get();

    double output = pid.calculate(getMeasurement());
    output = MathUtil.clamp(output,-0.5,0.5);

    SmartDashboard.putNumber("Encoder", getMeasurement());
  }

  public void setIntakeSpeed(double speed) {
    intakemotor1.set(speed);
    intakemotor2.set(speed);
  }

  public void setIntakePosition(double setpoint) {
    pid.setSetpoint(setpoint);
  }

  public double getMeasurement(){
    return encoder.getAbsolutePosition();
  }
}

  