package robotnameMaksymK;
import robocode.*;
import java.awt.Color;
import java.awt.geom.Point2D;


// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * MaxRobot - a robot by (your name here)
 */
public class MaxRobot extends AdvancedRobot
{
	private byte radarDirection = 1;
	/**
	 * run: MaxRobot's default behavior
	 */
	public void run() {
		setBodyColor(new Color(0, 139, 139));
		setGunColor(new Color(240, 230, 140));
		setRadarColor(new Color(255, 255, 224));
		setBulletColor(new Color(128, 0, 0));
		
		setTurnRadarRight(360);

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			setTurnRight(10000);
			setMaxVelocity(6);
			ahead(20000);
			
		
		}
	}
	
	




	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		if(e.getEnergy()>16){
			if (e.getDistance()<200){
				fire(3);
			}
			else{
				fire(2);
			}
			
		}
		else if(e.getEnergy() >10){
			if (e.getDistance()<200){
				fire(2.5);
			}
			else{
				fire(2);
			}
		}
		else if(e.getEnergy() > 2) {
			if (e.getDistance()<200){
				fire(.7);
			}
			else{
				fire(.5);
			}
		}
		else if(e.getEnergy() > .4){
			
			fire(.1);
		}
		ahead(100);
		
	}

		public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() > -25 && e.getBearing() < 25) {
			fire(3);
			
		}
		if (e.isMyFault()) {
			turnRight(10);
		}
	}
	
	
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(150);
		turnGunLeft(180);
		turnLeft(180);
		
	}	
	public void onHitByBulletEvent(HitBulletEvent e){
			setTurnRight(1000);
			setMaxVelocity(10);
			ahead(200);
	}
}
