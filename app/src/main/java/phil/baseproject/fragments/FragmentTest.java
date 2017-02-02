package phil.baseproject.fragments;

import android.widget.TextView;

import butterknife.BindView;
import phil.baseproject.R;
import phil.baseproject.fragments.base.BaseFragment;

/**
 * Created by phil-apposing on 02/02/2017.
 */

public class FragmentTest extends BaseFragment {

    @BindView(R.id.tvHelloWorld)
    TextView tvHelloWorld;

    @Override
    public int getLayout() {
        return R.layout.fragment_test;
    }

    @Override
    public void setupView() {

    }
}
