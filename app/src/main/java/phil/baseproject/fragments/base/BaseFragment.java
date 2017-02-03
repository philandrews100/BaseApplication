package phil.baseproject.fragments.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import phil.baseproject.activities.controllers.ActivityMainController;

/**
 * Created by phil-apposing on 02/02/2017.
 */

public abstract class BaseFragment extends Fragment {

    public abstract int getLayout();

    public abstract void setupView();

    private Unbinder fragUnbinder;
    private View view;
    public ActivityMainController mainController;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getLayout(), container, false);
        fragUnbinder = ButterKnife.bind(this, view);
        setupView();
        return view;
    }

    @Nullable
    @Override
    public View getView() {
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainController = new ActivityMainController(context);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (fragUnbinder != null)
            fragUnbinder.unbind();
    }
}
