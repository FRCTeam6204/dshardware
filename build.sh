javac -cp .:$HOME/wpilib/java/current/lib/WPILib.jar org/team6204/frc/components/PSoC5LP.java
javac -cp .:$HOME/wpilib/java/current/lib/WPILib.jar org/team6204/frc/dshardware/DSHardware.java
jar cf dshardware.jar org/team6204/frc/components/PSoC5LP.java org/team6204/frc/dshardware/DSHardware.java
