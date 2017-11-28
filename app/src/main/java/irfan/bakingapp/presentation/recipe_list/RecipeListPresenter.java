package irfan.bakingapp.presentation.recipe_list;

import irfan.bakingapp.schedulers.BaseSchedulerProvider;
import irfan.bakingapp.data.remote.RecipeRepo;
import irfan.bakingapp.data.remote.model.Recipe;
import irfan.bakingapp.idlingresource.RecipesIdlingResource;
import irfan.bakingapp.presentation.base.BasePresenter;

import java.util.List;

import rx.Subscriber;
import rx.functions.Action0;
import timber.log.Timber;

/**
 * Created by codedentwickler on 6/10/17.
 */

class RecipeListPresenter extends BasePresenter<RecipeListContract.View>
        implements RecipeListContract.Presenter{

    private final RecipeRepo mRecipeRepo;
    private final BaseSchedulerProvider mSchedulerProvider;

    RecipeListPresenter(RecipeRepo mRecipeRepo, BaseSchedulerProvider mSchedulerProvider) {
        this.mRecipeRepo = mRecipeRepo;
        this.mSchedulerProvider = mSchedulerProvider;
    }


    @Override
    public void loadRecipes(final RecipesIdlingResource idlingResource) {
        checkViewAttached();
        getView().showLoading();
        mRecipeRepo.getRecipes()
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        if (idlingResource != null) idlingResource.setIdleState(false);
                    }
                })
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Subscriber<List<Recipe>>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        getView().hideLoading();
                        getView().onError(e.getMessage());
                        Timber.e(e);
                    }

                    @Override
                    public void onNext(List<Recipe> recipes) {
                        Timber.d(recipes.toString());
                        if (idlingResource != null) idlingResource.setIdleState(true);
                        getView().hideLoading();
                        getView().showRecipes(recipes);
                    }
                });

    }

    @Override
    public void navigateToRecipeSteps(Recipe recipe) {
        getView().showToRecipeDetails(recipe);
    }


}
