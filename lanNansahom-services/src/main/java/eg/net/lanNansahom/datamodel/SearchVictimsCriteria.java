package eg.net.lanNansahom.datamodel;

import java.util.Date;

/**
 * The Class SearchVictimsBean.
 */
public class SearchVictimsCriteria {

	private Integer id;
	/** The alive. */
	private boolean martyr;

	/** The name. */
	private String name;

	/** The area. */
	private Integer areaId;

	/** The age. */
	private Integer age;

	/** The education id. */
	private Integer educationId;

	/** The job. */
	private Integer jobId;

	/** The record status. */
	private Integer recordStatusId;

	/** The date. */
	private Date date;

	private Boolean isPublished;

	/**
	 * @return the martyr
	 */
	public boolean isMartyr() {
		return martyr;
	}

	/**
	 * @param martyr
	 *            the martyr to set
	 */
	public void setMartyr(boolean martyr) {
		this.martyr = martyr;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the areaId
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @param areaId
	 *            the areaId to set
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the educationId
	 */
	public Integer getEducationId() {
		return educationId;
	}

	/**
	 * @param educationId
	 *            the educationId to set
	 */
	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}

	/**
	 * @return the jobId
	 */
	public Integer getJobId() {
		return jobId;
	}

	/**
	 * @param jobId
	 *            the jobId to set
	 */
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the isPublished
	 */
	public Boolean isPublished() {
		return isPublished;
	}

	/**
	 * @param isPublished
	 *            the isPublished to set
	 */
	public void setPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the recordStatusId
	 */
	public Integer getRecordStatusId() {
		return recordStatusId;
	}

	/**
	 * @param recordStatusId
	 *            the recordStatusId to set
	 */
	public void setRecordStatusId(Integer recordStatusId) {
		this.recordStatusId = recordStatusId;
	}

}
