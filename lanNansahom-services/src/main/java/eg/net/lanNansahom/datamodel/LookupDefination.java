package eg.net.lanNansahom.datamodel;

import eg.net.lanNansahom.shared.LookupType;

/**
 * The Enum LookupDefination.
 */
public enum LookupDefination {

	/** The AREA. */
	AREA(LookupType.AREA.name(), Area.class), /** The COURT. */
	COURT(LookupType.COURT.name(), Court.class), /** The EDUCATION. */
	EDUCATION(LookupType.EDUCATION.name(), Education.class),
	/** The GOVERNRATE. */
	GOVERNRATE(LookupType.GOVERNRATE.name(), Governrate.class),
	/** The HOSPITAL. */
	HOSPITAL(LookupType.HOSPITAL.name(), Hospital.class),
	/** The JOB. */
	JOB(LookupType.JOB.name(), Job.class),
	/** The LA w_ organization. */
	LAW_ORGANIZATION(LookupType.LAW_ORGANIZATION.name(), LawOrganization.class),
	/** The RELEATIONSHIP. */
	RELEATIONSHIP(LookupType.RELEATIONSHIP.name(), Relationship.class),
	/** The SOURCE. */
	SOURCE(LookupType.SOURCE.name(), Source.class),

	IMAGE_CATEGORY(LookupType.IMAGE_CATEGORY.name(), ImageCategory.class), VIDEO_CATEGORY(LookupType.VIDEO_CATEGORY
			.name(), VideoCategory.class), RECORD_STATUS(LookupType.RECORD_STATUS.name(), RecordStatus.class);

	/** The name. */
	private final String name;

	/** The clazz. */
	private final Class<? extends Lookup> clazz;

	/**
	 * Instantiates a new lookup defination.
	 * 
	 * @param name
	 *            the name
	 * @param clazz
	 *            the clazz
	 */
	LookupDefination(String name, Class<? extends Lookup> clazz) {
		this.name = name;
		this.clazz = clazz;
	}

	/**
	 * Gets the clazz.
	 * 
	 * @return the clazz
	 */
	public Class<? extends Lookup> getClazz() {
		return clazz;
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
	 * Gets the value of.
	 * 
	 * @param name
	 *            the name
	 * @return the value of
	 */
	public static LookupDefination getValueOf(String name) {
		for (LookupDefination defination : LookupDefination.values()) {
			if (defination.getName().endsWith(name)) {
				return defination;
			}
		}
		return null;
	}

}
