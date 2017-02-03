package phil.baseproject.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import phil.baseproject.R;
import phil.baseproject.activities.controllers.interfaces.ActivityMainInterface;
import phil.baseproject.fragments.FragmentTest;
import phil.baseproject.fragments.base.BaseFragment;

public class ActivityMain extends AppCompatActivity implements ActivityMainInterface {

    private FragmentManager fragManager;
    private FragmentTransaction fragTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupFragmentManager();
        launchFragmentTest();
    }

    @Override
    public void onBackPressed() {
        if (getBaseFragmentManager().getBackStackEntryCount() != 1) {
            getBaseFragmentManager().popBackStack();
            if (getBaseFragmentManager().getBackStackEntryCount() == 0) {
                super.onBackPressed();
            }
        } else {
            finish();
        }
    }

    @Override
    public void goBack() {
        onBackPressed();
    }

    @Override
    public Context getParentInstance() {
        return this;
    }

    @Override
    public void launchFragmentTest() {
        switchFragment(FragmentTest.newInstance(), FragmentTest.class.getSimpleName());
    }

    private void switchFragment(BaseFragment fragment, String fragmentName) {
        this.fragTransaction = getBaseFragmentManager().beginTransaction();
        this.fragTransaction.replace(R.id.flContainer, fragment, fragmentName);
        this.fragTransaction.addToBackStack(fragmentName);
        this.fragTransaction.commit();
    }

    private FragmentManager getBaseFragmentManager() {
        if (null == this.fragManager) {
            throw new IllegalStateException(ActivityMain.class.getSimpleName() +
                    " is not initialized, call setupFragmentManager(...) first");
        }
        return this.fragManager;
    }


    private void setupFragmentManager() {
        fragManager = getFragmentManager();
    }

}
