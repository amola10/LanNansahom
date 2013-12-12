package eg.net.lanNansahom.services.requests;

import java.util.Date;

import eg.net.services.ServiceRequest;

/**
 * The Class SearchVictimsRequest.
 */
public class SearchVictimsRequest extends ServiceRequest {

	/** The alive. */
	private boolean martyr;

	/** The is published. */
	private Boolean isPublished;

	/** The name. */
	private String name;

	/** The area. */
	private Integer areaId;

	/** The age. */
	private Integer age;

	/** The education id. */
	private Integer educationId;

	private Integer id;

	/** The job. */
	private Integer jobId;

	/** The record status. */
	private Integer recordStatusId;

	/** The date. */
	private Date date;

	/**
	 * Checks if is martyr.
	 * 
	 * @return the martyr
	 */
	public boolean isMartyr() {
		return martyr;
	}

	/**
	 * Sets the martyr.
	 * 
	 * @param martyr
	 *            the martyr to set
	 */
	public void setMartyr(boolean martyr) {
		this.martyr = martyr;
	}

	/**
	 * Gets the age.
	 * 
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 * 
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the area id.
	 * 
	 * @return the areaId
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * Sets the area id.
	 * 
	 * @param areaId
	 *            the areaId to set
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * Gets the education id.
	 * 
	 * @return the educationId
	 */
	public Integer getEducationId() {
		return educationId;
	}

	/**
	 * Sets the education id.
	 * 
	 * @param educationId
	 *            the educationId to set
	 */
	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}

	/**
	 * Gets the job id.
	 * 
	 * @return the jobId
	 */
	public Integer getJobId() {
		return jobId;
	}

	/**
	 * Sets the job id.
	 * 
	 * @param jobId
	 *            the jobId to set
	 */
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * Gets the checks if is published.
	 * 
	 * @return the isPublished
	 */
	public Boolean getIsPublished() {
		return isPublished;
	}

	/**
	 * Sets the checks if is published.
	 * 
	 * @param isPublished
	 *            the isPublished to set
	 */
	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
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
