package net.alepuzio.authsys.domain.user;

import net.alepuzio.authsys.domain.User;

public class Italian implements User {

	private User origin = null;
	
	public Italian (User user){
		this.origin = user;
	}

	@Override
	/**@return true if the origin.data() return true and if the vatIn follow the rules of Italian "codice fiscale"
	 *  **/
	public boolean valid() {
		boolean result = false;
		if (this.origin.valid()){
			 /*TODO improve logic with these rules from https://en.wikipedia.org/wiki/Italian_fiscal_code
			Surname (3 letters)
			the first three consonants of the surname are used. If there is more than one surname, both are considered as if they were one. If the surname has less than three consonants, then vowels will replace the blank spaces, in the same order they appear in the surname (e.g. "Rossi" would be RSS, "Masi" would be MSA). If the whole surname has less than three letters, the blank spaces are replaced with an X (e.g. "Fo" would be FOX, "Hu" would be HUX). The surname used is always the name that appears in the person's primary identification document: for native Italians, this is the carta d'identità (identity card).
			It is important to note that in Italy women do not 'officially' change their surnames when they marry: therefore, a woman does not require a new fiscal code (or identity card, or passport) if she already has one at the time of her marriage. However, when a woman obtains a fiscal code after she is married (generally, this applies only to foreigners born outside Italy) then the surname that appears in her primary identification document (usually, her passport) must be used to produce the fiscal code: in many cases, this will be the surname of her husband.[1]
			First name (3 letters)
			the first three consonants of the name are used. If there is more than one name, both are considered as if they were one. If the name has less than three consonants, then vowels will replace the blank spaces, in the same order they appear in the name (e.g. "Marco" would be MRC, "Paola" would be PLA). If the whole name has less than three letters, the blank spaces are filled with an X (e.g. Chinese name "Na" would be NAX). Some indian immigrants in Italy are registered with a triple X instead of their first name, since their passport only indicates a single word which is used as a surname by the Italian register office. If the name has more than three consonants, the 2nd is skipped (e.g. "Riccardo" would be RCR; "Martina" would be MTN). This second-consonant skipping rule for names that have more than three consonants is only used for first names, not for surnames.
			*/
			result = true;
		}
		return result;
	}
	
}
