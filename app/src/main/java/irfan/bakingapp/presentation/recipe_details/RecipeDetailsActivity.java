package irfan.bakingapp.presentation.recipe_details;

import android.os.Bundle;

import irfan.bakingapp.R;
import irfan.bakingapp.data.remote.model.Recipe;
import irfan.bakingapp.presentation.base.BaseActivity;
import irfan.bakingapp.utils.ActivityUtils;

public class RecipeDetailsActivity extends BaseActivity {

    public static final String RECIPE_KEY = "RECIPE_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        Recipe recipe = getIntent().getParcelableExtra(RECIPE_KEY);
        Bundle bundle = new Bundle();
        bundle.putParcelable(RECIPE_KEY, recipe);

        RecipeDetailsContract.Presenter mPresenter = new RecipeDetailsPresenter(recipe);

        RecipeDetailsFragment fragment =
                (RecipeDetailsFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.content_frame_recipe_details);

        if (fragment == null) {

            fragment= RecipeDetailsFragment.newInstance(bundle);
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(),
                    fragment, R.id.content_frame_recipe_details);

            fragment.setPresenter(mPresenter);
        }
    }

    @Override
    public void showSnackBarMessage(String message) {
        onError(message);
    }
}
