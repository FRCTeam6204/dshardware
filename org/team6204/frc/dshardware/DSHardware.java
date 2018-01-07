package org.team6204.frc.dshardware;

import org.team6204.frc.components.PSoC5LP;

// DSHardware is an interface to our driver station hardware

// Mapped like so:
/*
 * Diagram:                                    Key:
 * -----------------------------------------
 * |                        |       [|]       |       [|]   :    Master Switch
 * |                        |     H     H     |        H    :    Switch
 * |          LAPTOP        |     H        #  |        #    :    Red Square Button
 * |           SPACE        |     R R R R     |        R    :    Red LED Buttons
 * |                        |     G G G G     |        G    :    Green LED Buttons
 * |                        |     B B B B     |        B    :    Blue LED Buttons
 * |                        |     W W W W     |        W    :    White LED Buttons
 * -----------------------------------------
 *
 * Input IDs:
 * -----------------------------------------
 * |                        |       21        |
 * |                        |    19     20    |
 * |          LAPTOP        |    18     17    |
 * |           SPACE        |     4 3 2 1     |
 * |                        |     8 7 6 5     |
 * |                        |    12 11 10 9   |
 * |                        |    16 15 14 13  |
 * -----------------------------------------
 */


public class DSHardware extends PSoC5LP {

    private final int[][] LED_BUTTON_MAP =
        {
            {  4,  3,  2,  1 },
            {  8,  7,  6,  5 },
            { 12, 11, 10,  9 },
            { 16, 15, 14, 13 }
        };

    // Switch IDs
    public enum Switch {
        Master(21),
        Right(20),
        Left(19),
        Red(18);

        public final int id;
        private boolean state;

        private Switch(int _id) {
            id = _id;
        }

        protected void setState(boolean on) {
            state = on;
        }

        public boolean getState() {
            return state;
        }

    }

    // Button IDs
    public enum Button {
        RedSquare(17),

        /*
         * Button mappings by colour/row
         *
         * Button colours are addressed from right to left
         * e.g.    R1 R2 R3 R4
         *        G1 G2 G3 G4
         *        B1 B2 B3 B4
         *        W1 W2 W3 W4
         *
         */

        R1(4),
        R2(3),
        R3(2),
        R4(1),

        G1(8),
        G2(7),
        G3(6),
        G4(5),

        B1(12),
        B2(11),
        B3(10),
        B4(9),

        W1(16),
        W2(15),
        W3(14),
        W4(13);

        public final int id;
        private Button(int _id) {
            id = _id;
        }
    }

    public DSHardware(int port) {
        super(port);
        for (Switch s : Switch.values()) {
            getSwitch(s);
        }
    }

    // Get the value of the master switch
    public boolean getMaster() {
        return getSwitch(Switch.Master);
    }

    // Get the value of the square red button
    public boolean getRedButton() {
        return getButton(Button.RedSquare);
    }

    public boolean getSwitch(Switch sw) {
        boolean state = getRawButton(sw.id);
        sw.setState(state);
        return state;
    }

    public boolean getButton(Button button) {
        return getRawButton(button.id);
    }

    // Get an LED button from a matrix coordinate
    //   0 1 2 3
    // 0 R R R R
    // 1 G G G G
    // 2 B B B B
    // 3 W W W W
    public boolean getButtonMatrix(final int i, final int j) {
        return getRawButton(LED_BUTTON_MAP[i][j]);
    }
}
