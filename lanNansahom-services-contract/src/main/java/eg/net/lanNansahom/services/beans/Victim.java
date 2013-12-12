package eg.net.lanNansahom.services.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Victim.
 */
public class Victim extends Person {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2401493263380362641L;

	/** The description. */
	private String description;

	/** The birth date. */
	private Date birthDate;

	/** The age. */
	private Integer age;

	/** The place of birth. */
	private Lookup placeOfBirth;

	/** The address. */
	private String address;

	/** The residence area. */
	private Lookup residenceArea;

	/** The education. */
	private Lookup education;

	/** The job. */
	private Lookup job;

	/** The employer. */
	private String employer;

	/** The source. */
	private Lookup source;

	/** The injury area. */
	private Lookup injuryArea;

	/** The injury date. */
	private Date injuryDate;

	/** The medical description. */
	private String medicalDescription;

	/** The hospital. */
	private Lookup hospital;

	/** The martyr. */
	private boolean martyr;

	/** The death area. */
	private Lookup deathArea;

	/** The death date. */
	private Date deathDate;

	/** The corpse discovery area. */
	private Lookup corpseDiscoveryArea;

	/** The corpse discovery date. */
	private Date corpseDiscoveryDate;

	private Lookup recordStatus;

	/** The relatives. */
	private List<Relative> relatives = new ArrayList<Relative>();

	/** The images. */
	private List<Image> images = new ArrayList<Image>();

	/** The videos. */
	private List<Video> videos = new ArrayList<Video>();

	/** The articles. */
	private List<Article> articles = new ArrayList<Article>();

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the birth date.
	 * 
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the birth date.
	 * 
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
	 * Gets the place of birth.
	 * 
	 * @return the placeOfBirth
	 */
	public Lookup getPlaceOfBirth() {
		return placeOfBirth;
	}

	/**
	 * Sets the place of birth.
	 * 
	 * @param placeOfBirth
	 *            the placeOfBirth to set
	 */
	public void setPlaceOfBirth(Lookup placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	/**
	 * Gets the address.
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 * 
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the residence area.
	 * 
	 * @return the residenceArea
	 */
	public Lookup getResidenceArea() {
		return residenceArea;
	}

	/**
	 * Sets the residence area.
	 * 
	 * @param residenceArea
	 *            the residenceArea to set
	 */
	public void setResidenceArea(Lookup residenceArea) {
		this.residenceArea = residenceArea;
	}

	/**
	 * Gets the education.
	 * 
	 * @return the education
	 */
	public Lookup getEducation() {
		return education;
	}

	/**
	 * Sets the education.
	 * 
	 * @param education
	 *            the education to set
	 */
	public void setEducation(Lookup education) {
		this.education = education;
	}

	/**
	 * Gets the job.
	 * 
	 * @return the job
	 */
	public Lookup getJob() {
		return job;
	}

	/**
	 * Sets the job.
	 * 
	 * @param job
	 *            the job to set
	 */
	public void setJob(Lookup job) {
		this.job = job;
	}

	/**
	 * Gets the employer.
	 * 
	 * @return the employer
	 */
	public String getEmployer() {
		return employer;
	}

	/**
	 * Sets the employer.
	 * 
	 * @param employer
	 *            the employer to set
	 */
	public void setEmployer(String employer) {
		this.employer = employer;
	}

	/**
	 * Gets the source.
	 * 
	 * @return the source
	 */
	public Lookup getSource() {
		return source;
	}

	/**
	 * Sets the source.
	 * 
	 * @param source
	 *            the source to set
	 */
	public void setSource(Lookup source) {
		this.source = source;
	}

	/**
	 * Gets the injury area.
	 * 
	 * @return the injuryArea
	 */
	public Lookup getInjuryArea() {
		return injuryArea;
	}

	/**
	 * Sets the injury area.
	 * 
	 * @param injuryArea
	 *            the injuryArea to set
	 */
	public void setInjuryArea(Lookup injuryArea) {
		this.injuryArea = injuryArea;
	}

	/**
	 * Gets the injury date.
	 * 
	 * @return the injuryDate
	 */
	public Date getInjuryDate() {
		return injuryDate;
	}

	/**
	 * Sets the injury date.
	 * 
	 * @param injuryDate
	 *            the injuryDate to set
	 */
	public void setInjuryDate(Date injuryDate) {
		this.injuryDate = injuryDate;
	}

	/**
	 * Gets the medical description.
	 * 
	 * @return the medicalDescription
	 */
	public String getMedicalDescription() {
		return medicalDescription;
	}

	/**
	 * Sets the medical description.
	 * 
	 * @param medicalDescription
	 *            the medicalDescription to set
	 */
	public void setMedicalDescription(String medicalDescription) {
		this.medicalDescription = medicalDescription;
	}

	/**
	 * Gets the hospital.
	 * 
	 * @return the hospital
	 */
	public Lookup getHospital() {
		return hospital;
	}

	/**
	 * Sets the hospital.
	 * 
	 * @param hospital
	 *            the hospital to set
	 */
	public void setHospital(Lookup hospital) {
		this.hospital = hospital;
	}

	/**
	 * Gets the death area.
	 * 
	 * @return the deathArea
	 */
	public Lookup getDeathArea() {
		return deathArea;
	}

	/**
	 * Sets the death area.
	 * 
	 * @param deathArea
	 *            the deathArea to set
	 */
	public void setDeathArea(Lookup deathArea) {
		this.deathArea = deathArea;
	}

	/**
	 * Gets the death date.
	 * 
	 * @return the deathDate
	 */
	public Date getDeathDate() {
		return deathDate;
	}

	/**
	 * Sets the death date.
	 * 
	 * @param deathDate
	 *            the deathDate to set
	 */
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	/**
	 * Gets the corpse discovery area.
	 * 
	 * @return the corpseDiscoveryArea
	 */
	public Lookup getCorpseDiscoveryArea() {
		return corpseDiscoveryArea;
	}

	/**
	 * Sets the corpse discovery area.
	 * 
	 * @param corpseDiscoveryArea
	 *            the corpseDiscoveryArea to set
	 */
	public void setCorpseDiscoveryArea(Lookup corpseDiscoveryArea) {
		this.corpseDiscoveryArea = corpseDiscoveryArea;
	}

	/**
	 * Gets the corpse discovery date.
	 * 
	 * @return the corpseDiscoveryDate
	 */
	public Date getCorpseDiscoveryDate() {
		return corpseDiscoveryDate;
	}

	/**
	 * @return the recordStatus
	 */
	public Lookup getRecordStatus() {
		return recordStatus;
	}

	/**
	 * @param recordStatus
	 *            the recordStatus to set
	 */
	public void setRecordStatus(Lookup recordStatus) {
		this.recordStatus = recordStatus;
	}

	/**
	 * Sets the corpse discovery date.
	 * 
	 * @param corpseDiscoveryDate
	 *            the corpseDiscoveryDate to set
	 */
	public void setCorpseDiscoveryDate(Date corpseDiscoveryDate) {
		this.corpseDiscoveryDate = corpseDiscoveryDate;
	}

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
	 * Gets the relatives.
	 * 
	 * @return the relatives
	 */
	public List<Relative> getRelatives() {
		return relatives;
	}

	/**
	 * Sets the relatives.
	 * 
	 * @param relatives
	 *            the relatives to set
	 */
	public void setRelatives(List<Relative> relatives) {
		this.relatives = relatives;
	}

	/**
	 * Gets the images.
	 * 
	 * @return the images
	 */
	public List<Image> getImages() {
		return images;
	}

	/**
	 * Sets the images.
	 * 
	 * @param images
	 *            the images to set
	 */
	public void setImages(List<Image> images) {
		this.images = images;
	}

	/**
	 * Gets the videos.
	 * 
	 * @return the videos
	 */
	public List<Video> getVideos() {
		return videos;
	}

	/**
	 * Sets the videos.
	 * 
	 * @param videos
	 *            the videos to set
	 */
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	/**
	 * Gets the articles.
	 * 
	 * @return the articles
	 */
	public List<Article> getArticles() {
		return articles;
	}

	/**
	 * Sets the articles.
	 * 
	 * @param articles
	 *            the articles to set
	 */
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	/**
	 * Gets the images by type.
	 * 
	 * @param categry
	 *            the categry
	 * @return the images by type
	 */
	public List<Image> getImagesByType(ImageCategry categry) {
		List<Image> result = new ArrayList<Image>();
		for (Image image : getImages()) {
			if (image.getCategory().getId() == categry.getId()) {
				result.add(image);
			}
		}
		return result;
	}

}
