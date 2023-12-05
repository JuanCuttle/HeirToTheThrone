package model.entities;

import model.enums.GenderEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Royal implements Comparable<Royal> {

	protected String name;
	protected LocalDate dob;
	protected GenderEnum gender;
	protected Boolean protestant;
	protected List<Royal> children;
	protected List<Royal> heirs;
	protected Royal royalParent;
	protected Boolean alive = true;
	private Boolean visited = false;
	private Boolean isInvalid; // Has left or been disinherited from the Royal Family

	public Royal(String name, LocalDate dob, GenderEnum gender, Boolean protestant,
				 List<Royal> children) {
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.protestant = protestant;
		this.isInvalid = false;

		Collections.sort(children);
		this.setChildren(children);
	}

	public void addChild(Royal newChild) {
		this.children.add(newChild);
		this.heirs.add(newChild);
		newChild.setRoyalParent(this);
	}

	@Override
	public int compareTo(Royal arg0) {
		return this.dob.compareTo(arg0.getDoB());
	}

	public String getName() {
		return name;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public List<Royal> getChildren() {
		return children;
	}

	public void setChildren(List<Royal> children) {
		this.children = children;
		this.heirs = new ArrayList<>();
		for (Royal r : this.children) {
			if (r.canBeHeir()) {
				heirs.add(r);
			}
		}
	}

	public boolean isAlive() {
		return this.alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

	public LocalDate getDoB() {
		return dob;
	}

	public Boolean isProtestant() {
		return protestant;
	}

	public Royal getRoyalParent() {
		return royalParent;
	}

	public void setRoyalParent(Royal royalParent) {
		this.royalParent = royalParent;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public Boolean canBeHeir() {
		return this.isProtestant() && this.isAlive()
				&& !this.isInvalid;
	}

	public ArrayList<Royal> getMaleChildren() {
		ArrayList<Royal> maleChildren = new ArrayList<>();
		for (Royal r : this.children) {
			if (r.getGender() == GenderEnum.MALE) {
				maleChildren.add(r);
			}
		}
		return maleChildren;
	}

	public ArrayList<Royal> getFemaleChildren() {
		ArrayList<Royal> femaleChildren = new ArrayList<>();
		for (Royal r : this.children) {
			if (r.getGender() == GenderEnum.FEMALE) {
				femaleChildren.add(r);
			}
		}
		return femaleChildren;
	}

	public void sortChildrenMaleFirstDob() {
		ArrayList<Royal> maleChildren = this.getMaleChildren();
		ArrayList<Royal> femaleChildren = this.getFemaleChildren();
		Collections.sort(maleChildren);
		Collections.sort(femaleChildren);
		maleChildren.addAll(femaleChildren);
		this.children = maleChildren;
	}

	public ArrayList<Royal> getKin() {
		ArrayList<Royal> kin = new ArrayList<>();
		if (this.getRoyalParent() != null) {
			ArrayList<Royal> youngerBrothers = this.getRoyalParent()
					.getHeirsDMP();
			int successionIndex = youngerBrothers.indexOf(this);
			for (int i = successionIndex + 1; i < youngerBrothers.size(); i++) {
					kin.add(youngerBrothers.get(i));
			}
		}
		return kin;
	}

	public ArrayList<Royal> getHeirsDMP() {
		ArrayList<Royal> heirs = new ArrayList<>();
		for (Royal r : this.children) {
			heirs.add(r);
		}
		return heirs;
	}
	
	public Boolean getVisited() {
		return visited;
	}

	public void setVisited(Boolean visited) {
		this.visited = visited;
	}

	public void setInvalid(boolean b) {
		this.isInvalid = b;
		for (Royal r : this.children) {
			r.setInvalid(b);
		}
	}

	public boolean isInvalid() {
		return this.isInvalid;
	}

}
