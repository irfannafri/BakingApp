package irfan.bakingapp.presentation.recipe_step;

import irfan.bakingapp.data.remote.model.Step;
import irfan.bakingapp.presentation.base.MvpPresenter;
import irfan.bakingapp.presentation.base.MvpView;

import java.util.List;

interface RecipeStepContract {

  interface View extends MvpView {

    void showStepsInViewpager(List<Step> steps);

    void showRecipeNameInAppBar(String recipeName);

    void moveToCurrentStepPage();
  }

  interface Presenter extends MvpPresenter<View> {

    void loadStepsToAdapter();

    void loadRecipeName();

  }
}
