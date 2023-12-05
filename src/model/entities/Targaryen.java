package model.entities;
import model.enums.GenderEnum;

import java.time.LocalDate;
import java.util.ArrayList;

public class Targaryen extends Royal {

	private Boolean abdicated = false;

	private Boolean hasAbdicated() {
		return this.abdicated;
	}

	public void setAbdicated(Boolean abdicated) {
		this.abdicated = abdicated;
	}

	public Targaryen(String name, LocalDate dob, GenderEnum gender,
					 ArrayList<Royal> children) {

		super(name, dob, gender, null, children);
		this.sortChildrenMaleFirstDob();
		this.alive = false;
	}

	@Override
	public Boolean canBeHeir() {
		return this.isAlive() && !hasAbdicated();
	}
}
