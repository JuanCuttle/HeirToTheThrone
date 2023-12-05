package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Targaryen extends Royal {

	private Boolean abdicated = false;
	

	public void setAbdicated(Boolean abdicated) {
		this.abdicated = abdicated;
	}

	public Targaryen(String name, LocalDate dob, Gender gender,
					 ArrayList<Royal> children) {

		super(name, dob, gender, null, children);
		//Collections.sort(this.children);
		this.sortChildrenMaleFirstDob();
		this.alive = false;
	}

	@Override
	public Boolean canBeHeir() {
		return this.isAlive() && !abdicated();
	}

	private Boolean abdicated() {
		return this.abdicated;
	}



}
