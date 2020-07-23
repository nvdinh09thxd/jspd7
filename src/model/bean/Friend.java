package model.bean;

import java.sql.Timestamp;

public class Friend {
	int id;
	String name;
	String preview;
	String detail;
	Timestamp dateCreate;
	int countNumber;
	String picture;
	Category fl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Timestamp getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}

	public int getCountNumber() {
		return countNumber;
	}

	public void setCountNumber(int countNumber) {
		this.countNumber = countNumber;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Category getFl() {
		return fl;
	}

	public void setFl(Category fl) {
		this.fl = fl;
	}

	public Friend(int id, String name, String preview, String detail, Timestamp dateCreate, int countNumber,
			String picture, Category fl) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.detail = detail;
		this.dateCreate = dateCreate;
		this.countNumber = countNumber;
		this.picture = picture;
		this.fl = fl;
	}

	public Friend() {
		super();
	}

}
