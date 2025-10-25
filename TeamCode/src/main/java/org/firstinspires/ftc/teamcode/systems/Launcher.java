//Version 25-26 1.4.5
package org.firstinspires.ftc.teamcode.systems;


import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Launcher {


    private DcMotor S1;

    private CRServo LF;
    private CRServo RF;
    private String SS = "";
    private double SP = 0;
    public Launcher(HardwareMap hardwareMap) {
        S1 = hardwareMap.get(DcMotor.class, "S1");

        RF = hardwareMap.get(CRServo.class, "RF");
        LF = hardwareMap.get(CRServo.class, "LF");

        S1.setDirection(DcMotor.Direction.REVERSE);

    }


    public void speed(double s) {
        // Combine the joystick requests for each axis-motion to determine each wheel's power.
        // Set up a variable for each drive wheel to save the power level for telemetry.
        SP=s;
        S1.setPower(SP);


    }
    public void shoot(boolean t){
        if (t){
            LF.setPower(-1);
            RF.setPower(1);
            SS = "Feeding";
        }
        else{
            LF.setPower(0);
            RF.setPower(0);
            SS = "Standby";
        }
    }
    public String getTel() {
        return (" Launcher power: " + SP  + " Shoot state: " + SS);
    }

    }
