package monsters;

import java.util.ArrayList;
import java.util.Random;

import helper.CasePath;
import map.Case;

public class MobSpawner {
	int constDelay = 20;
	int wave, caseSize;
	ArrayList<AbstractMob> mobs;
	Random random;
	
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
		random = new Random();
		for(int i = 0; i < 10; i++) {
			mobs.add(new SmallGoblin(100, 1, 6.5*caseSize, 0*caseSize, caseSize/4, caseSize, caseSize/4, c, i*constDelay+random.nextInt(50)));
		}
		return mobs;
	}
	
	public ArrayList<AbstractMob> getWave() { return mobs; }

}
