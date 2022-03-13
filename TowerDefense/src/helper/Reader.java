package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import enums.CaseStatus;
import map.Case;
import weapons.ArcherDefense;
import weapons.TeslaDefense;

public class Reader {

	static String mapPath = "assets/map.data";
	
	public static Case[][] getMap() {
		Case[][] world = null;
		try {
			
			File myObj = new File(mapPath);
			Scanner myReader = new Scanner(myObj);
			ArrayList<String> aaa= new ArrayList<String>();
			
			int counter = 0;
			while (myReader.hasNextLine()) {
				aaa.add(myReader.nextLine());
				counter++;
			}
			for(int i=0; i<aaa.size(); i++) {
				String[] r = aaa.get(i).split(" ");
				if(i == 0) {
					world = new Case[counter][r.length];
				}
				for(int j=0; j<r.length; j++) {
					switch(r[j]) {
						case "c":
							world[i][j] = new Case(0, CaseStatus.CLEAR);
							break;
						case "p":
							world[i][j] = new Case(0, CaseStatus.PATH);
							break;
						case "t":
							world[i][j] = new Case(0, CaseStatus.TOWER);
							break;
						case "A":
							world[i][j] = new Case(0, CaseStatus.DEFENSE, new ArcherDefense(j, i, 0f));
							break;
						case "T":
							world[i][j] = new Case(0, CaseStatus.DEFENSE, new TeslaDefense(j, i));
							break;
					}
				}
			}
		    myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return world;
		
	} 
	
}
