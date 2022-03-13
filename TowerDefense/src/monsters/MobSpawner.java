package monsters;

import java.util.ArrayList;

import helper.CasePath;
import map.Case;

public class MobSpawner {
	
	int wave, caseSize;
	ArrayList<AbstractMob> mobs;
	
	public MobSpawner(int _caseSize, int _wave) {
		caseSize = _caseSize;
		wave = _wave;
		mobs = new ArrayList<AbstractMob>();
	}
	
	public MobSpawner(int _caseSize) {
		caseSize = _caseSize;
		wave = 1;
		mobs = new ArrayList<AbstractMob>();
	}
	
	public int getWaveNumber() { return wave; }
	public void nextWave() { wave++; };
	
	public ArrayList<AbstractMob> createMobWave(Case[][] c) {
		for(int i = 0; i < 1; i++) {
			mobs.add(new SmallGoblin(100, 1.0, 6.5*caseSize, 0*caseSize, caseSize/4, caseSize, caseSize/2, c));
		}
		return mobs;
	}
	
	public ArrayList<AbstractMob> getWave() { return mobs; }

}
