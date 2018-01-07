package org.team6204.frc.components;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.DriverStation;

// Cypress Semiconductor PSoC5LP microcontroller implementation as a HID

public class PSoC5LP extends GenericHID {

    private DriverStation m_ds;

    public PSoC5LP(int port) {
        super(port);
        m_ds = DriverStation.getInstance();
    }

    @Override
    public double getX(Hand hand) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getY(Hand hand) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getRawAxis(int which) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean getRawButton(int button) {
        return m_ds.getStickButton(getPort(), (byte) button);
    }

    @Override
    public int getPOV(int pov) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getPOVCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public HIDType getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        return m_ds.getJoystickName(getPort());
    }

    @Override
    public void setOutput(int outputNumber, boolean value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setOutputs(int value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setRumble(RumbleType type, double value) {
        // TODO Auto-generated method stub

    }

}
