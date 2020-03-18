package swe425.project.MIUScheduler.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long scheduleId;

	@OneToMany
	private List<Section> sections = new ArrayList<>();

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public Schedule(List<Section> sections) {
		super();
		this.sections = sections;
	}

	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	public void addSectionToSchedule(Section s) {

		sections.add(s);
	}

	public void removeSection(Section s) {

		sections.remove(s);
	}

}
