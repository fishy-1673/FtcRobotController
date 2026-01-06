//Version 25-26 2.1.2
package org.firstinspires.ftc.teamcode.systems;


import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {


    private DcMotor Intake;
    private CRServo IW;
    private double IntakeSpeed = 0;
    public Intake(HardwareMap hardwareMap) {
        Intake = hardwareMap.get(DcMotor.class, "Intake");
        IW = hardwareMap.get(CRServo.class,"CROS");
    }


    public void intakeSpeed(double speed) {
        IntakeSpeed = speed;

        Intake.setPower(IntakeSpeed);
    }
    public void OSS(boolean b){
        if (b){
            IW.setPower(-1);
        }
        else{
            IW.setPower(0);
        }
    }
    public String getTel() {
        return ("Intake Speed: " + IntakeSpeed + "");
    }

    }
