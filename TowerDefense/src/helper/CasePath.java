package helper;

import enums.CaseStatus;
import map.Case;

public class CasePath {
	
	int[] towerPos;
	int[] lastPathFound;
	int[][] path;
	Case[][] map;
	

	public CasePath(Case[][] _map) {
		map = _map;
		towerPos = new int[2];
		lastPathFound = new int[2];
		int counter = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j].getStatus() == CaseStatus.PATH) {
					counter++;
				} else if(map[i][j].getStatus() == CaseStatus.TOWER) {
					towerPos[0] = i;
					towerPos[1] = j;
				}
			}
		}
		path = new int[counter+1][2];
		path[0][0] = towerPos[0];
		path[0][1] = towerPos[1];
		int c = 1;
		
		int[] r = getPathNeighbour(towerPos[0], towerPos[1]);
		
		while(r[0] != -1 && r[1] != -1 && c < path.length) {
			path[c][0] = r[0];
			path[c][1] = r[1];
			r = getPathNeighbour(path[c][0], path[c][1]);
			c++;
		}
		for(int i=0; i<path.length; i++) {
			System.out.println(path[i][0]+ " "+path[i][1]);
		}
	}
	
	public int[] getPathNeighbour(int currentX, int currentY) {
		int[] l = {currentX, currentY};
		int[] result = new int[2];
		if(currentX - 1 >= 0 && map[currentX - 1][currentY].getStatus() == CaseStatus.PATH && (lastPathFound[0] != currentX-1 || lastPathFound[1] != currentY)) {	//up
			result[0] = currentX - 1;
			result[1] = currentY;
			lastPathFound = l;
			return result;	
		}else if(currentX + 1 < map.length && map[currentX + 1][currentY].getStatus() == CaseStatus.PATH && (lastPathFound[0] != currentX+1 || lastPathFound[1] != currentY)) {	//down
			result[0] = currentX + 1;
			result[1] = currentY;
			lastPathFound = l;
			return result;
		} else if(currentY - 1 >= 0 && map[currentX][currentY - 1].getStatus() == CaseStatus.PATH && (lastPathFound[0] != currentX || lastPathFound[1] != currentY-1)) {	//left
			result[0] = currentX;
			result[1] = currentY - 1;
			lastPathFound = l;
			return result;
		}else if(currentY + 1 < map[0].length && map[currentX][currentY + 1].getStatus() == CaseStatus.PATH && (lastPathFound[0] != currentX || lastPathFound[1] != currentY+1)) {	//right
			result[0] = currentX;
			result[1] = currentY + 1;
			lastPathFound = l;
			return result;
		}
		result[0] = -1;
		result[1] = -1;
		return result;
	}
	
	public int[][] getPath() {
		return path;
	}
	
	public int[] getDirection(int x, int y) {
		return getPathNeighbour(x, y);
	}
	
}
