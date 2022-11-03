package lesson5.labs.prob1.factorymethods;

import java.awt.Component;
import java.util.HashMap;

import lesson5.labs.prob1.factorymethods.rulesets.AddressRuleSet;
import lesson5.labs.prob1.factorymethods.rulesets.CustomerProfileRuleSet;
import lesson5.labs.prob1.ui.AddrWindow;
import lesson5.labs.prob1.ui.ProfileWindow;

public class RuleSetFactory {
	static HashMap<Class<? extends Component>, RuleSet> map = new HashMap<>();
	static {
		map.put(AddrWindow.class, new AddressRuleSet());
		map.put(ProfileWindow.class, new CustomerProfileRuleSet());
	}
	public static RuleSet getRuleSet(Component c) {
		Class<? extends Component> cl = c.getClass();
		if(!map.containsKey(cl)) {
			throw new IllegalArgumentException("No RuleSet found for this Component");
		}
		return map.get(cl);
	}
}
