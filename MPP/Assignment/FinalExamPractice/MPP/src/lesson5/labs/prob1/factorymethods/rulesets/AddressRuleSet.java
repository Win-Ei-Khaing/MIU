package lesson5.labs.prob1.factorymethods.rulesets;

import java.awt.Component;

import lesson5.labs.prob1.factorymethods.RuleException;
import lesson5.labs.prob1.factorymethods.RuleSet;
import lesson5.labs.prob1.ui.AddrWindow;

public class AddressRuleSet implements RuleSet {

	@Override
	public void applyRules(Component ob) throws RuleException {
		AddrWindow addr = (AddrWindow) ob;
		// comment
		String id = addr.getIdValue();
		String street = addr.getStreetValue();
		String city = addr.getCityValue();
		String state = addr.getStateValue();
		String zip = addr.getZipValue();
		if (id.isEmpty() || street.isEmpty() || city.isEmpty()
				|| state.isEmpty() || zip.isEmpty())
		{
			throw new RuleException("All fields must be nonempty.");
		}
		
		if (!id.matches("\\d+")){
			throw new RuleException("ID field must be numeric.");
		}

		if (!zip.matches("\\d{5}")){
			throw new RuleException("Zip must be numeric with exactly 5 digits.");
		}	

		if (!state.matches("[A-Z]{2}")){
			throw new RuleException("State must have exactly two characters in the range A-Z.");
		}	

		if (id.equals(zip)){
			throw new RuleException("ID field should be different from zip field.");
		}	
	}
}
