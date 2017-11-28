package irfan.bakingapp.presentation.recipe_step;

import irfan.bakingapp.data.remote.model.Recipe;
import irfan.bakingapp.presentation.base.BasePresenter;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by codedentwickler on 6/21/17.
 */

class RecipeStepPresenter extends BasePresenter<RecipeStepContract.View>
        implements RecipeStepContract.Presenter {

    private final Recipe mRecipe;

    RecipeStepPresenter(Recipe recipe) {
        this.mRecipe = checkNotNull( recipe);
    }

    @Override
    public void attachView(RecipeStepContract.View mvpView) {
        super.attachView(mvpView);
        loadStepsToAdapter();
        loadRecipeName();
    }

    @Override
    public void loadStepsToAdapter() {
        getView().showStepsInViewpager(mRecipe.getSteps());
    }

    @Override
    public void loadRecipeName() {
        getView().showRecipeNameInAppBar(mRecipe.getName());

    }
}
