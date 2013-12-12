package eg.net.lanNansahom.datamodel;

// Generated Aug 19, 2011 8:10:22 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Lawyer generated by hbm2java
 */
public class Lawyer extends Person implements java.io.Serializable {

	private static final long serialVersionUID = -2561254078934067198L;
	private int id;
	private LawOrganization lawOrganization;
	private String licenceNumber;
	private Set<LawsuitLawyers> lawsuitLawyerses = new HashSet<LawsuitLawyers>(0);

	public Lawyer() {
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public LawOrganization getLawOrganization() {
		return this.lawOrganization;
	}

	public void setLawOrganization(LawOrganization lawOrganization) {
		this.lawOrganization = lawOrganization;
	}

	public String getLicenceNumber() {
		return this.licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public Set<LawsuitLawyers> getLawsuitLawyerses() {
		return this.lawsuitLawyerses;
	}

	public void setLawsuitLawyerses(Set<LawsuitLawyers> lawsuitLawyerses) {
		this.lawsuitLawyerses = lawsuitLawyerses;
	}

}