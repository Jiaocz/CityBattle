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
			wall = Transpose.tfunction(Map1.wall);
			ironwall = Transpose.tfunction(Map1.ironwall);
			grass = Transpose.tfunction(Map1.grass);
			water = Transpose.tfunction(Map1.water);
		}else if(Choice.mapNumber == 2) {
			wall = Transpose.tfunction(Map2.wall);
			ironwall = Transpose.tfunction(Map2.ironwall);
			grass = Transpose.tfunction(Map2.grass);
			water = Transpose.tfunction(Map2.water);
		}else if(Choice.mapNumber == 3) {
			wall = Transpose.tfunction(Map3.wall);
			ironwall = Transpose.tfunction(Map3.ironwall);
			grass = Transpose.tfunction(Map3.grass);
			water = Transpose.tfunction(Map3.water);
		}else if(Choice.mapNumber == 4) {
			wall = Transpose.tfunction(Map4.wall);
			ironwall = Transpose.tfunction(Map4.ironwall);
			grass = Transpose.tfunction(Map4.grass);
			water = Transpose.tfunction(Map4.water);
		}else if(Choice.mapNumber == 5) {
			wall = Transpose.tfunction(MapSelf.wall);
			ironwall = Transpose.tfunction(MapSelf.ironwall);
			grass = Transpose.tfunction(MapSelf.grass);
			water = Transpose.tfunction(MapSelf.water);
		}
	}
	
}
