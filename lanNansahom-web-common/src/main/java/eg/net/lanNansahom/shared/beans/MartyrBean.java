package eg.net.lanNansahom.shared.beans;

import java.util.Date;

public class MartyrBean extends VictimBean {

	private static final long serialVersionUID = -7415405664707820650L;
	public static final String BINDING_DEATH_AREA = "BINDING_DEATH_AREA";
	public static final String BINDING_DEATH_DATE = "BINDING_DEATH_DATE";

	public static final String BINDING_CORPSE_DISCOVERY_AREA = "BINDING_CORPSE_DISCOVERY_AREA";
	public static final String BINDING_CORPSE_DISCOVERY_DATE = "BINDING_CORPSE_DISCOVERY_DATE";

	public MartyrBean() {
		super();
		setMartyr(true);
	}

	/**
	 * @return the deathArea
	 */
	public LookupBean getDeathArea() {
		return get(BINDING_DEATH_AREA);
	}

	/**
	 * @param deathArea
	 *            the deathArea to set
	 */
	public void setDeathArea(LookupBean deathArea) {
		set(BINDING_DEATH_AREA, deathArea);
	}

	/**
	 * @return the deathDate
	 */
	public Date getDeathDate() {
		return get(BINDING_DEATH_DATE);
	}

	/**
	 * @param deathDate
	 *            the deathDate to set
	 */
	public void setDeathDate(Date deathDate) {
		set(BINDING_DEATH_DATE, deathDate);
	}

	/**
	 * @return the corpseDiscoveryArea
	 */
	public LookupBean getCorpseDiscoveryArea() {
		return get(BINDING_CORPSE_DISCOVERY_AREA);
	}

	/**
	 * @param corpseDiscoveryArea
	 *            the corpseDiscoveryArea to set
	 */
	public void setCorpseDiscoveryArea(LookupBean corpseDiscoveryArea) {
		set(BINDING_CORPSE_DISCOVERY_AREA, corpseDiscoveryArea);
	}

	/**
	 * @return the corpseDiscoveryDate
	 */
	public Date getCorpseDiscoveryDate() {
		return get(BINDING_CORPSE_DISCOVERY_DATE);
	}

	/**
	 * @param corpseDiscoveryDate
	 *            the corpseDiscoveryDate to set
	 */
	public void setCorpseDiscoveryDate(Date corpseDiscoveryDate) {
		set(BINDING_CORPSE_DISCOVERY_DATE, corpseDiscoveryDate);
	}
}
