//Version 25-26 1.4.0
package org.firstinspires.ftc.teamcode.systems;


import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain {


    private DcMotor FLD;
    private DcMotor BLD;
    private DcMotor FRD;
    private DcMotor BRD;
    private double frontLeftPower = 0;
    private double frontRightPower = 0;
    private double backLeftPower = 0;
    private double backRightPower = 0;
    public  DriveTrain(@NonNull HardwareMap hardwareMap) {//maybye define a local hardware map with  this.hardwareMap = hardwareMap;  ?
        FLD = hardwareMap.get(DcMotor.class, "FL");
        BLD = hardwareMap.get(DcMotor.class, "RL");
        FRD = hardwareMap.get(DcMotor.class, "FR");
        BRD = hardwareMap.get(DcMotor.class, "RR");

        FLD.setDirection(DcMotor.Direction.REVERSE);
        BLD.setDirection(DcMotor.Direction.REVERSE);
        FRD.setDirection(DcMotor.Direction.FORWARD);
        BRD.setDirection(DcMotor.Direction.FORWARD);
    }


    public void Drive(double drive, double strafe, double yaw) {
        // Combine the joystick requests for each axis-motion to determine each wheel's power.
        // Set up a variable for each drive wheel to save the power level for telemetry.
        frontLeftPower = drive + strafe + yaw;
        frontRightPower = drive - strafe - yaw;
        backLeftPower = drive - strafe + yaw;
        backRightPower = drive + strafe - yaw;

        // find maximum value
        double max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
        max = Math.max(max, Math.abs(backLeftPower));
        max = Math.max(max, Math.abs(backRightPower));

        if (max > 1.0) {
            frontLeftPower /= max;
            frontRightPower /= max;
            backLeftPower /= max;
            backRightPower /= max;
        }


        FLD.setPower(frontLeftPower);
        FRD.setPower(frontRightPower);
        BLD.setPower(backLeftPower);
        BRD.setPower(backRightPower);
    }
    public String getTel() {
        return ("Front left: " + frontLeftPower + " right: " + frontRightPower + "Back  left: " +  backLeftPower+"right: "+ backRightPower);
    }

    }
