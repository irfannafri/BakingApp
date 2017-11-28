package irfan.bakingapp.presentation.recipe_list;

import irfan.bakingapp.data.remote.model.Recipe;
import irfan.bakingapp.idlingresource.RecipesIdlingResource;
import irfan.bakingapp.presentation.base.MvpPresenter;
import irfan.bakingapp.presentation.base.MvpView;

import java.util.List;

/**
 * Created by codedentwickler on 6/10/17.
 */

interface RecipeListContract {

    interface View extends MvpView {

        void showRecipes(List<Recipe> recipes);

        void showToRecipeDetails(Recipe recipe);
    }

    interface Presenter extends MvpPresenter<RecipeListContract.View> {

        void loadRecipes(RecipesIdlingResource idlingResource);

        void navigateToRecipeSteps(Recipe recipe);
    }
}
