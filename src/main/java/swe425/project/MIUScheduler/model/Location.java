package swe425.project.MIUScheduler.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locationId;

	@NotNull
	private String building;

	@NotNull
	private String roomNumber;

	public Integer getLocationId() {
		return locationId;
	}

	@Override
	public String toString() {
		return building+" ,room:" + roomNumber;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Location(@NotNull String building, @NotNull String roomNumber) {
		super();
		this.building = building;
		this.roomNumber = roomNumber;
	}

	public Location() {

	}

}
