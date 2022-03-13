package map;

import java.awt.Color;

import enums.CaseStatus;
import weapons.AbstractDefense;
import weapons.ArcherDefense;

public class Case {
	
	AbstractDefense def = null;
	boolean isSelected = false;
	int height;
	Color col;
	CaseStatus status;
	
	public Case() {
		
	}
	
	public Case(int h, CaseStatus s) {
		height = h;
		if(s == CaseStatus.CLEAR) {
			col = Color.green;
		} else if(s == CaseStatus.PATH) {
			col = Color.orange;
		} else if(s == CaseStatus.TOWER) {
			col = Color.blue;
		} else if(s == CaseStatus.DEFENSE) {
			col = Color.BLACK;
		}
		status = s;
	}
	
	public Case(int h, CaseStatus s, AbstractDefense _def) {
		height = h;
		def = _def;
		if(s == CaseStatus.CLEAR) {
			col = Color.green;
		} else if(s == CaseStatus.PATH) {
			col = Color.orange;
		} else if(s == CaseStatus.TOWER) {
			col = Color.blue;
		} else if(s == CaseStatus.DEFENSE) {
			col = Color.BLACK;
		}
		status = s;
	}
	
	public AbstractDefense getDefense() {
		if(status == CaseStatus.DEFENSE) {
			return def;
		} else {
			return null;
		}
	}
	public void setDefense(AbstractDefense d) { def = d; }
	
	public int getHeight() { return height; }
	public CaseStatus getStatus() { return status; }
	
	public void setHeight(int h) { height = h; }
	public void setStatus(CaseStatus s) { status = s; }
	
	public void setColor(Color c) { col = c; }
	public Color getColor() { return col; }
	
	public boolean isSelected() { return isSelected; }
	public void setSelected(boolean s) {isSelected = s; }
}
