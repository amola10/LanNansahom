package eg.net.lanNansahom.datamodel;

// Generated Aug 19, 2011 8:10:22 PM by Hibernate Tools 3.4.0.CR1

/**
 * LawsuitLawyersId generated by hbm2java
 */
public class LawsuitLawyersId implements java.io.Serializable {

	private static final long serialVersionUID = 3583750442821723550L;
	private int lawyerId;
	private int lawSuitId;

	public LawsuitLawyersId() {
	}

	public int getLawyerId() {
		return this.lawyerId;
	}

	public void setLawyerId(int lawyerId) {
		this.lawyerId = lawyerId;
	}

	public int getLawSuitId() {
		return this.lawSuitId;
	}

	public void setLawSuitId(int lawSuitId) {
		this.lawSuitId = lawSuitId;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LawsuitLawyersId))
			return false;
		LawsuitLawyersId castOther = (LawsuitLawyersId) other;

		return (this.getLawyerId() == castOther.getLawyerId())
				&& (this.getLawSuitId() == castOther.getLawSuitId());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getLawyerId();
		result = 37 * result + this.getLawSuitId();
		return result;
	}

}
