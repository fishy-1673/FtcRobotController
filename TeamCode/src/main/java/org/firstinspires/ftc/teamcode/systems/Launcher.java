//Version 25-26 2.0.1
package org.firstinspires.ftc.teamcode.systems;


import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Launcher {


    private DcMotor S1;
    private DcMotor S2;

    private CRServo LF;
    private CRServo RF;
    private int FS;
    private double SP = 0;
    private String[] FeedStates = {"Antifeeding","Standby", "Feeding"};
    public Launcher(HardwareMap hardwareMap) {
        //initialize the motors and servos so they can actually be used
        S1 = hardwareMap.get(DcMotor.class, "S1");
        S2 = hardwareMap.get(DcMotor.class, "S2");


        S1.setDirection(DcMotor.Direction.REVERSE);
        S2.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    //takes a value and gives it to the flywheels
    public void speed(double s) {

        SP=s;
        S1.setPower(SP);
        //adjusted value here because this motor is much faster and we want some backspin
        S2.setPower(SP*0.67);


    }
    //carryover class from V1: originally used to feed balls from hopper into flywheel, now is a redundant spaggeti used for servo testing and auxillary servos we may need

    public String getTel() {
        return (" Launcher power: " + SP );
    }

    }
