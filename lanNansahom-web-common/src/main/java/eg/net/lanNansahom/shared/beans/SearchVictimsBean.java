package eg.net.lanNansahom.shared.beans;

import java.util.Date;

import eg.net.gxt.client.BaseBean;
import eg.net.gxt.client.widget.ComboBoxBean;

public class SearchVictimsBean extends BaseBean {

	private static final long serialVersionUID = -7460847636151476067L;
	public static final String BINDING_NAME = "BINDING_NAME";
	public static final String BINDING_AREA = "BINDING_AREA";
	public static final String BINDING_AGE = "BINDING_AGE";
	public static final String BINDING_MARTYR = "BINDING_MARTYR";
	public static final String BINDING_EDUCATION = "BINDING_EDUCATION";
	public static final String BINDING_JOB = "BINDING_JOB";
	public static final String BINDING_DATE = "BINDING_DATE";
	public static final String BINDING_ID = "BINDING_ID";
	public static final String BINDING_PUBLISHED = "BINDING_PUBLISHED";
	public static final String BINDING_RECORD_STATUS = "BINDING_RECORD_STATUS";

	/**
	 * Amal :Unused field added to avoid serializationException bug in GXT &
	 * GWT.Please don't Remove.
	 */
	@SuppressWarnings("unused")
	private LookupBean unsed;
	@SuppressWarnings("unysed1")
	private ComboBoxBean unysed1;

	public SearchVictimsBean() {
		super();
	}

	public SearchVictimsBean(boolean martyrs) {
		super();
		setMartyr(martyrs);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return get(BINDING_NAME);
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		set(BINDING_NAME, name);
	}

	/**
	 * @return the residenceArea
	 */
	public LookupBean getArea() {
		return get(BINDING_AREA);
	}

	/**
	 * @param residenceArea
	 *            the residenceArea to set
	 */
	public void setArea(LookupBean residenceArea) {
		set(BINDING_AREA, residenceArea);
	}

	/**
	 * @return the martyr
	 */
	public boolean isMartyr() {
		return get(BINDING_MARTYR, false);
	}

	/**
	 * @param martyr
	 *            the martyr to set
	 */
	public void setMartyr(boolean martyr) {
		set(BINDING_MARTYR, martyr);
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return get(BINDING_AGE);
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		set(BINDING_AGE, age);
	}

	/**
	 * @return the education
	 */
	public LookupBean getEducation() {
		return get(BINDING_EDUCATION);
	}

	/**
	 * @param education
	 *            the education to set
	 */
	public void setEducation(LookupBean education) {
		set(BINDING_EDUCATION, education);
	}

	/**
	 * @return the job
	 */
	public LookupBean getJob() {
		return get(BINDING_JOB);
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(LookupBean job) {
		set(BINDING_JOB, job);
	}

	/**
	 * @return the Date
	 */
	public Date getDate() {
		return get(BINDING_DATE);
	}

	/**
	 * @param birthDate
	 *            the date to set
	 */
	public void setDate(Date date) {
		set(BINDING_DATE, date);
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return get(BINDING_ID);
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		set(BINDING_ID, id);
	}

	/**
	 * Gets the checks if is published.
	 * 
	 * @return the isPublished
	 */
	public ComboBoxBean getPublished() {
		return get(BINDING_PUBLISHED);
	}

	/**
	 * Sets the checks if is published.
	 * 
	 * @param isPublished
	 *            the isPublished to set
	 */
	public void setPublished(ComboBoxBean isPublished) {
		set(BINDING_PUBLISHED, isPublished);
	}

	/**
	 * @return the recordStatus
	 */
	public LookupBean getRecordStatus() {
		return get(BINDING_RECORD_STATUS);
	}

	/**
	 * @param recordStatus
	 *            the recordStatus to set
	 */
	public void setRecordStatus(LookupBean recordStatus) {
		set(BINDING_RECORD_STATUS, recordStatus);
	}
}
