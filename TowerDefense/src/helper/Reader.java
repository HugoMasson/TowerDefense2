package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import enums.CaseStatus;
import map.Case;
import weapons.ArcherDefense;
import weapons.MainTowerDefense;
import weapons.TeslaDefense;

public class Reader {

	static InputStream is = Reader.class.getClassLoader().getResourceAsStream("assets2/map.data");
	
	
	public static Case[][] getMap() {
		Case[][] world = null;
		try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
		     BufferedReader reader = new BufferedReader(streamReader)) {
			ArrayList<String> aaa= new ArrayList<String>();
			
			String line;
			int counter = 0;
			while ((line = reader.readLine()) != null) {
				aaa.add(line);
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
							world[i][j] = new Case(0, CaseStatus.TOWER, new MainTowerDefense(j, i, 0f));
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
		} catch (IOException e) {
			
		}
		return world;
		
	} 
	
}
