package eg.net.lanNansahom.shared.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VictimBean extends PersonBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2401493263380362641L;

	public static final String BINDING_DESCRIPTION = "BINDING_DESCRIPTION";
	public static final String BINDING_BIRTHDATE = "BINDING_BIRTHDATE";
	public static final String BINDING_AGE = "BINDING_AGE";
	public static final String BINDING_PLACE_OF_BIRTH = "BINDING_PLACE_OF_BIRTH";
	public static final String BINDING_ADDRESS = "BINDING_ADDRESS";
	public static final String BINDING_RESIDENCE_AREA = "BINDING_RESIDENCE_AREA";

	public static final String BINDING_EDUCATION = "BINDING_EDUCATION";
	public static final String BINDING_JOB = "BINDING_JOB";
	public static final String BINDING_EMPLOYER = "BINDING_EMPLOYER";

	public static final String BINDING_SOURCE = "BINDING_SOURCE";

	public static final String BINDING_INJURY_AREA = "BINDING_INJURY_AREA";
	public static final String BINDING_INJURY_DATE = "BINDING_INJURY_DATE";
	public static final String BINDING_MEDICAL_DESCRIPTION = "BINDING_MEDICAL_DESCRIPTION";
	public static final String BINDING_HOSPITAL = "BINDING_HOSPITAL";
	public static final String BINDING_RECORD_STATUS = "BINDING_RECORD_STATUS";

	public static final String BINDING_MARTYR = "BINDING_MARTYR";
	public static final String BINDING_RELATIVES = "BINDING_RELATIVES";
	public static final String BINDING_IMAGES = "BINDING_IMAGES";
	public static final String BINDING_VIDEOS = "BINDING_VIDEOS";
	public static final String BINDING_ARTICLES = "BINDING_ARTICLES";

	/**
	 * Amal :Unused field added to avoid serializationException bug in GXT &
	 * GWT.Please don't Remove.
	 */
	@SuppressWarnings("unused")
	private List<RelativeBean> unsed;
	@SuppressWarnings("unused")
	private List<ImageBean> unsed1;
	@SuppressWarnings("unused")
	private List<VideoBean> unsed2;
	@SuppressWarnings("unused")
	private List<ArticleBean> unsed3;

	public VictimBean() {
		super();
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return get(BINDING_DESCRIPTION);
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		set(BINDING_DESCRIPTION, description);
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return get(BINDING_BIRTHDATE);
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		set(BINDING_BIRTHDATE, birthDate);
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
	 * @return the placeOfBirth
	 */
	public LookupBean getPlaceOfBirth() {
		return get(BINDING_PLACE_OF_BIRTH);
	}

	/**
	 * @param placeOfBirth
	 *            the placeOfBirth to set
	 */
	public void setPlaceOfBirth(LookupBean placeOfBirth) {
		set(BINDING_PLACE_OF_BIRTH, placeOfBirth);
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return get(BINDING_ADDRESS);
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		set(BINDING_ADDRESS, address);
	}

	/**
	 * @return the residenceArea
	 */
	public LookupBean getResidenceArea() {
		return get(BINDING_RESIDENCE_AREA);
	}

	/**
	 * @param residenceArea
	 *            the residenceArea to set
	 */
	public void setResidenceArea(LookupBean residenceArea) {
		set(BINDING_RESIDENCE_AREA, residenceArea);
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
	 * @return the employer
	 */
	public String getEmployer() {
		return get(BINDING_EMPLOYER);
	}

	/**
	 * @param employer
	 *            the employer to set
	 */
	public void setEmployer(String employer) {
		set(BINDING_EMPLOYER, employer);
	}

	/**
	 * @return the source
	 */
	public LookupBean getSource() {
		return get(BINDING_SOURCE);
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(LookupBean source) {
		set(BINDING_SOURCE, source);
	}

	/**
	 * @return the injuryArea
	 */
	public LookupBean getInjuryArea() {
		return get(BINDING_INJURY_AREA);
	}

	/**
	 * @param injuryArea
	 *            the injuryArea to set
	 */
	public void setInjuryArea(LookupBean injuryArea) {
		set(BINDING_INJURY_AREA, injuryArea);
	}

	/**
	 * @return the injuryDate
	 */
	public Date getInjuryDate() {
		return get(BINDING_INJURY_DATE);
	}

	/**
	 * @param injuryDate
	 *            the injuryDate to set
	 */
	public void setInjuryDate(Date injuryDate) {
		set(BINDING_INJURY_DATE, injuryDate);
	}

	/**
	 * @return the medicalDescription
	 */
	public String getMedicalDescription() {
		return get(BINDING_MEDICAL_DESCRIPTION);
	}

	/**
	 * @param medicalDescription
	 *            the medicalDescription to set
	 */
	public void setMedicalDescription(String medicalDescription) {
		set(BINDING_MEDICAL_DESCRIPTION, medicalDescription);
	}

	/**
	 * @return the hospital
	 */
	public LookupBean getHospital() {
		return get(BINDING_HOSPITAL);
	}

	/**
	 * @param hospital
	 *            the hospital to set
	 */
	public void setHospital(LookupBean hospital) {
		set(BINDING_HOSPITAL, hospital);
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
	 * @return the relatives
	 */
	public List<RelativeBean> getRelatives() {
		return get(BINDING_RELATIVES, new ArrayList<RelativeBean>());
	}

	/**
	 * @param relatives
	 *            the relatives to set
	 */
	public void setRelatives(List<RelativeBean> relatives) {
		set(BINDING_RELATIVES, relatives);
	}

	/**
	 * @return the images
	 */
	public List<ImageBean> getImages() {
		return get(BINDING_IMAGES, new ArrayList<ImageBean>());
	}

	/**
	 * @param images
	 *            the images to set
	 */
	public void setImages(List<ImageBean> images) {
		set(BINDING_IMAGES, images);
	}

	/**
	 * @return the videos
	 */
	public List<VideoBean> getVideos() {
		return get(BINDING_VIDEOS, new ArrayList<VideoBean>());
	}

	/**
	 * @param videos
	 *            the videos to set
	 */
	public void setVideos(List<VideoBean> videos) {
		set(BINDING_VIDEOS, videos);
	}

	/**
	 * @return the articles
	 */
	public List<ArticleBean> getArticles() {
		return get(BINDING_ARTICLES, new ArrayList<ArticleBean>());
	}

	/**
	 * @param articles
	 *            the articles to set
	 */
	public void setArticles(List<ArticleBean> articles) {
		set(BINDING_ARTICLES, articles);
	}

	public List<ImageBean> getImagesByType(ImageCategry categry) {
		List<ImageBean> result = new ArrayList<ImageBean>();
		for (ImageBean imageBean : getImages()) {
			if (imageBean.getCategory().getId() == categry.getId()) {
				result.add(imageBean);
			}
		}
		return result;
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
