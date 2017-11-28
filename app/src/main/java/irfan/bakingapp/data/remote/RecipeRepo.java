package irfan.bakingapp.data.remote;

import irfan.bakingapp.data.remote.model.Recipe;

import java.util.List;

import rx.Observable;

/**
 * Created by codedentwickler on 6/10/17.
 */

public interface RecipeRepo {
    Observable<List<Recipe>> getRecipes();
}