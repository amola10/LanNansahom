package eg.net.lanNansahom.dao.impl;

public class VictimDao extends BaseHibernateDao {

	protected boolean isAlfIncluded(char pCharacter) {
		char[] alfCharacters = getAlfCharacters();
		for (char character : alfCharacters) {
			if (pCharacter == character) {
				return true;
			}
		}
		return false;
	}

	protected boolean isYa2Included(char pCharacter) {
		char[] alfCharacters = getYa2Characters();
		for (char character : alfCharacters) {
			if (pCharacter == character) {
				return true;
			}
		}
		return false;
	}

	protected boolean isTahIncluded(char pCharacter) {
		char[] alfCharacters = getTahCharacters();
		for (char character : alfCharacters) {
			if (pCharacter == character) {
				return true;
			}
		}
		return false;
	}

	protected char[] getAlfCharacters() {
		return new char[] { '\u0622', '\u0623', '\u0625', '\u0627' };
	}

	protected char[] getYa2Characters() {
		return new char[] { '\u0649', '\u064A' };
	}

	protected char[] getTahCharacters() {
		return new char[] { '\u0629', '\u0647' };
	}

	protected String[] extractKeyWords(String pName) {
		String result[] = pName.split(" ");
		for (int i = 0; i < result.length; i++) {
			result[i] = extractKeyWord(result[i]);
		}
		return result;
	}

	protected String extractKeyWord(String pName) {
		String keyword = "";
		for (int i = 0; i < pName.length(); i++) {
			if (isAlfIncluded(pName.charAt(i)) && i == 0) {
				keyword += "[" + new String(getAlfCharacters()) + "]";

			} else if (isYa2Included(pName.charAt(i)) && i == (pName.length() - 1)) {
				keyword += "[" + new String(getYa2Characters()) + "]";

			} else if (isTahIncluded(pName.charAt(i)) && i == (pName.length() - 1)) {
				keyword += "[" + new String(getTahCharacters()) + "]";

			} else {
				keyword += pName.charAt(i);
			}

		}

		return keyword;
	}

}
