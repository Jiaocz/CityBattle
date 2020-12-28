package edu.nwpu.citybattle.TankMap;

import UI.Choice;
import edu.nwpu.citybattle.TankMap.*;

public class Map {
	public static int[][] wall;
	public static int[][] ironwall;
	public static int[][] grass;
	public static int[][] water;
	public static void selectMap() {
		if(Choice.mapNumber == 1) {
			wall = Map1.wall;
			ironwall = Map1.ironwall;
			grass = Map1.grass;
			water = Map1.water;
		}else if(Choice.mapNumber == 2) {
			wall = Map2.wall;
			ironwall = Map2.ironwall;
			grass = Map2.grass;
			water = Map2.water;
		}else if(Choice.mapNumber == 3) {
			wall = Map3.wall;
			ironwall = Map3.ironwall;
			grass = Map3.grass;
			water = Map3.water;
		}else if(Choice.mapNumber == 4) {
			wall = Map4.wall;
			ironwall = Map4.ironwall;
			grass = Map4.grass;
			water = Map4.water;
		}
	}
	
}
