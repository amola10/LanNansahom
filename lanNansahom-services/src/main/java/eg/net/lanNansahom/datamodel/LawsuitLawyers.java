package eg.net.lanNansahom.datamodel;

// Generated Aug 19, 2011 8:10:22 PM by Hibernate Tools 3.4.0.CR1

/**
 * LawsuitLawyers generated by hbm2java
 */
public class LawsuitLawyers implements java.io.Serializable {

	private static final long serialVersionUID = -5046974021884042502L;
	private LawsuitLawyersId id;
	private Lawsuit lawsuit;
	private Lawyer lawyer;

	public LawsuitLawyers() {
	}

	public LawsuitLawyersId getId() {
		return this.id;
	}

	public void setId(LawsuitLawyersId id) {
		this.id = id;
	}

	public Lawsuit getLawsuit() {
		return this.lawsuit;
	}

	public void setLawsuit(Lawsuit lawsuit) {
		this.lawsuit = lawsuit;
	}

	public Lawyer getLawyer() {
		return this.lawyer;
	}

	public void setLawyer(Lawyer lawyer) {
		this.lawyer = lawyer;
	}

}