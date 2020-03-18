package swe425.project.MIUScheduler.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Transcript {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transcriptId;

	@OneToMany
	private List<Section> sections;

	@ElementCollection( targetClass = String.class )
	private List<String> gradeForSection;

	public Long getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(Long transcriptId) {
		this.transcriptId = transcriptId;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public List<String> getGradeForSection() {
		return gradeForSection;
	}

	public void setGradeForSection(List<String> gradeForSection) {
		this.gradeForSection = gradeForSection;
	}

	public Transcript(List<Section> sections, List<String> gradeForSection) {
		super();
		this.sections = sections;
		this.gradeForSection = gradeForSection;
	}

	public Transcript() {

	}

}
