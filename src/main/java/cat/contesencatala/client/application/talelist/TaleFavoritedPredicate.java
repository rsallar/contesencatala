package cat.contesencatala.client.application.talelist;

import com.google.common.base.Predicate;

import cat.contesencatala.client.application.model.Tale;

public class TaleFavoritedPredicate implements Predicate<Tale>{
	
	public static TaleFavoritedPredicate INSTANCE = new TaleFavoritedPredicate();

	@Override
	public boolean apply(Tale tale) {
		return tale.favorite;
	}

}
