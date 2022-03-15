package map;

import enums.CaseStatus;
import enums.GenerationMode;
import helper.Reader;

public class Map {
	
	GenerationMode genrationMode;
	Case[][] world;
	
	public Map(GenerationMode _genrationMode) {
		genrationMode = _genrationMode;
		
		if(genrationMode == GenerationMode.READ_FILE) {
			world = Reader.getMap();
		} else {
			System.out.println("Not supported yet");
		}

	}
	
	public Case[][] getMap() {
		return world;
	}
	
	public void setStatus(int x, int y, CaseStatus s) {
		world[x][y].setStatus(s);
	}
			
}
