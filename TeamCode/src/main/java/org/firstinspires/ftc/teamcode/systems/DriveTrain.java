/* Copyright (c) 2021 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.systems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain {


    private DcMotor FLD;
    private DcMotor BLD;
    private DcMotor FRD;
    private DcMotor BRD;
    private double max;
    private double frontLeftPower = 0;
    private double frontRightPower = 0;
    private double backLeftPower = 0;
    private double backRightPower = 0;
    public  DriveTrain(HardwareMap hardwareMap) {//maybye define a local hardware map with  this.hardwareMap = hardwareMap;  ?
        FLD = hardwareMap.get(DcMotor.class, "FL");
        BLD = hardwareMap.get(DcMotor.class, "RL");
        FRD = hardwareMap.get(DcMotor.class, "FR");
        BRD = hardwareMap.get(DcMotor.class, "RR");

        FLD.setDirection(DcMotor.Direction.FORWARD);
        BLD.setDirection(DcMotor.Direction.REVERSE);
        FRD.setDirection(DcMotor.Direction.REVERSE);
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
        max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
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
