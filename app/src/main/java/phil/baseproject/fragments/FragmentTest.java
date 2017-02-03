package phil.baseproject.fragments;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import phil.baseproject.R;
import phil.baseproject.fragments.base.BaseFragment;

/**
 * Created by phil-apposing on 02/02/2017.
 */

public class FragmentTest extends BaseFragment {

    public static BaseFragment newInstance() {
        return new FragmentTest();
    }

    @BindView(R.id.tvHelloWorld)
    TextView tvHelloWorld;

    @Override
    public int getLayout() {
        return R.layout.fragment_test;
    }

    @Override
    public void setupView() {
        tvHelloWorld.setText(mainController.getParentInstance().getPackageName());
        getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainController.goBack();
            }
        });
    }
}
