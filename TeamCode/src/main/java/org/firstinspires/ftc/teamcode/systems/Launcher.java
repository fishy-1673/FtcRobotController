//Version 25-26 1.5.5
package org.firstinspires.ftc.teamcode.systems;


import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Launcher {


    private DcMotor S1;
    private DcMotor S2;

    private CRServo LF;
    private CRServo RF;
    private String FS = "";
    private double SP = 0;
    public Launcher(HardwareMap hardwareMap) {
        S1 = hardwareMap.get(DcMotor.class, "S1");
        S2 = hardwareMap.get(DcMotor.class, "S2");
        RF = hardwareMap.get(CRServo.class, "RF");
        LF = hardwareMap.get(CRServo.class, "LF");

        S1.setDirection(DcMotor.Direction.REVERSE);
        S2.setDirection(DcMotorSimple.Direction.FORWARD);
    }


    public void speed(double s) {
        // Combine the joystick requests for each axis-motion to determine each wheel's power.
        // Set up a variable for each drive wheel to save the power level for telemetry.
        SP=s;
        S1.setPower(SP);
        S2.setPower(SP*0.67);


    }
    public void Feed(double s){
        LF.setPower(s);
        RF.setPower(s);
        if (s>0){
            FS = "Feeding";
        } else if (s<0) {
            FS = "Antifeeding";
        } else{
            FS = "Standby";
        }
    }
    public String getTel() {
        return (" Launcher power: " + SP  + " Feeding state: " + FS);
    }

    }
