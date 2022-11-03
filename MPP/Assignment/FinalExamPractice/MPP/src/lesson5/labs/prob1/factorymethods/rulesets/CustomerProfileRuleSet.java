package lesson5.labs.prob1.factorymethods.rulesets;

import java.awt.Component;

import lesson5.labs.prob1.factorymethods.RuleException;
import lesson5.labs.prob1.factorymethods.RuleSet;
import lesson5.labs.prob1.ui.ProfileWindow;

public class CustomerProfileRuleSet implements RuleSet {

	@Override
	public void applyRules(Component ob) throws RuleException {
		ProfileWindow custProf = (ProfileWindow) ob;
		// check data
		String profileId = custProf.getIdValue();
		String firstName = custProf.getFirstNameValue();
		String lastName = custProf.getLastNameValue();
		String favoriteMovie = custProf.getFavoriteMovieValue();
		String favoriteRestaurant = custProf.getFavoriteRestaurantValue();
		
		if(favoriteMovie.toLowerCase().equals(favoriteRestaurant.toLowerCase()))
		{
			throw new RuleException("Favorite restaurant cannot equal favorite movie");
		}
		
		if (profileId.isEmpty() || firstName.isEmpty() || lastName.isEmpty()
				|| favoriteMovie.isEmpty() || favoriteRestaurant.isEmpty())
		{
			throw new RuleException("All fields must be nonempty.");
		}
		
		if (!profileId.matches("\\d+")){
			throw new RuleException("ID field must be numeric.");
		}
		
		if(!firstName.matches("([a-z]|[A-Z])+") || !lastName.matches("([a-z]|[A-Z])+"))
		{
			throw new RuleException("firstname and lastname fields may not contain spaces or characters other than a-z, A-Z.");
		}
		
	}

}
