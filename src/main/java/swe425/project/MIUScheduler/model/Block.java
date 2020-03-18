package swe425.project.MIUScheduler.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Block {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer blockId;

	private String blockTitle;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(unique = true)
	private LocalDate start_date;

	@NotNull(message = "Please enter an end date for the block")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(unique = true)
	private LocalDate end_date;
	
	@Override
	public String toString() {
		return blockTitle;
	}

	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public String getBlockTittle() {
		return blockTitle;
	}

	public void setBlockTittle(String blockTittle) {
		this.blockTitle = blockTittle;
	}

	public Block(String blockTittle, @NotNull LocalDate start_date,
				 @NotNull(message = "Please enter an end date for the block") LocalDate end_date) {
		super();
		this.start_date = start_date;
		this.end_date = end_date;
		this.blockTitle = blockTittle;
	}

	public Block() {

	}

}
