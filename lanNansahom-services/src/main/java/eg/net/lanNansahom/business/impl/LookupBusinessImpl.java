package eg.net.lanNansahom.business.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.lanNansahom.ServicesErorrCodes;
import eg.net.lanNansahom.business.LookupBusiness;
import eg.net.lanNansahom.dao.LookupDao;
import eg.net.lanNansahom.datamodel.LookupDefination;
import eg.net.lanNansahom.services.beans.Lookup;
import eg.net.lanNansahom.services.beans.LookupList;
import eg.net.lanNansahom.shared.LookupType;
import eg.net.services.BeansMapper;
import eg.net.services.ServiceException;

/**
 * The Class LookupBusinessImpl.
 */
public class LookupBusinessImpl implements LookupBusiness {

	/** The lookup dao. */
	@Autowired
	private LookupDao lookupDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.lanNansahom.business.LookupBusiness#retrieveAllLookup()
	 */
	public HashMap<String, LookupList> retrieveAllLookup() throws ServiceException {
		HashMap<String, LookupList> result = new HashMap<String, LookupList>();
		for (final LookupType lookupType : LookupType.values()) {
			if (LookupDefination.getValueOf(lookupType.name()) != null) {
				result.put(lookupType.name(), new LookupList(searchLookup(lookupType)));
			} else {
				throw new ServiceException(ServicesErorrCodes.UNDEFINED_LOOKUP_TYPE.name(), "Undefined Lookup type "
						+ lookupType);
			}
		}
		return result;
	}

	public void addLookup(LookupType lookupType, Lookup lookup) {
		Class<? extends eg.net.lanNansahom.datamodel.Lookup> clazz = LookupDefination.valueOf(lookupType.name())
				.getClazz();
		lookupDao.addLookup(BeansMapper.map(lookup, clazz));
	}

	public void updateLookup(LookupType lookupType, Lookup lookup) {
		Class<? extends eg.net.lanNansahom.datamodel.Lookup> clazz = LookupDefination.valueOf(lookupType.name())
				.getClazz();
		eg.net.lanNansahom.datamodel.Lookup orginal = lookupDao.getLookupById(clazz, lookup.getId());
		lookupDao.updateLookup(BeansMapper.map(lookup, orginal, clazz));
	}

	public List<Lookup> searchLookup(LookupType lookupType) {
		Class<? extends eg.net.lanNansahom.datamodel.Lookup> clazz = LookupDefination.valueOf(lookupType.name())
				.getClazz();
		List<Lookup> result = BeansMapper.map(lookupDao.getAll(clazz), Lookup.class);
		for (Lookup lookup : result) {
			lookup.setLookupType(lookupType);
		}
		return result;
	}

}
