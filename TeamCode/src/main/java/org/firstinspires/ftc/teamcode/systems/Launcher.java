//Version 25-26 1.2.2
package org.firstinspires.ftc.teamcode.systems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Launcher {


    private DcMotor S1;
    private DcMotor S2;
    private double SP = 0;
    public Launcher(HardwareMap hardwareMap) {
        S1 = hardwareMap.get(DcMotor.class, "S1");
        S2 = hardwareMap.get(DcMotor.class, "S2");


        S1.setDirection(DcMotor.Direction.FORWARD);
        S2.setDirection(DcMotor.Direction.REVERSE);

    }


    public void speed(double s) {
        // Combine the joystick requests for each axis-motion to determine each wheel's power.
        // Set up a variable for each drive wheel to save the power level for telemetry.
        SP=s;
        S1.setPower(SP);
        S2.setPower(SP);

    }
    public String getTel() {
        return (" Launcher power: " + SP );
    }

    }
