package project.road.com.road.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import project.road.com.road.R;
import project.road.com.road.fragment.InfoServiceFragment;
import project.road.com.road.fragment.MapServiceFragment;
import project.road.com.road.fragment.SystemManageFragment;
import project.road.com.road.utils.UIUtils;

public class MainActivity extends FragmentActivity {

    public Activity mActivity;
    @Bind(R.id.tv_map)
    TextView tvMap;
    @Bind(R.id.tv_information)
    TextView tvInformation;
    @Bind(R.id.tv_setup)
    TextView tvSetup;
    @Bind(R.id.ll_content)
    FrameLayout llcontent;
    @Bind(R.id.iv_map)
    ImageView ivmap;
    @Bind(R.id.ll_map)
    RelativeLayout llmap;
    @Bind(R.id.iv_information)
    ImageView ivinformation;
    @Bind(R.id.ll_information)
    RelativeLayout llinformation;
    @Bind(R.id.iv_setup)
    ImageView ivsetup;
    @Bind(R.id.ll_setup)
    RelativeLayout llsetup;


    private InfoServiceFragment infoServiceFragment;
    private MapServiceFragment mapServiceFragment;
    private SystemManageFragment systemManageFragment;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSelect(0);
    }


    @OnClick({R.id.ll_map, R.id.ll_information, R.id.ll_setup})
    public void changeTab(View view) {
        switch (view.getId()) {
            case R.id.ll_map:
                setSelect(1);
                break;
            case R.id.ll_information:
                setSelect(0);
                break;
            case R.id.ll_setup:
                setSelect(2);
                break;
        }
    }


    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        hideFragment();
        resetTab();
        switch (i) {
            case 1:
                if (mapServiceFragment == null) {
                    mapServiceFragment = new MapServiceFragment();
                    ft.add(R.id.ll_content, mapServiceFragment);
                }
                ivmap.setImageResource(R.mipmap.map_red);
                tvMap.setTextColor(UIUtils.getcolor(R.color.login_red));
                ft.show(mapServiceFragment);
                break;
            case 0:
                if (infoServiceFragment == null) {
                    infoServiceFragment = new InfoServiceFragment();
                    ft.add(R.id.ll_content, infoServiceFragment);
                }
                ivinformation.setImageResource(R.mipmap.activity_red);
                tvInformation.setTextColor(UIUtils.getcolor(R.color.login_red));
                ft.show(infoServiceFragment);
                break;
            case 2:
                if (systemManageFragment == null) {
                    systemManageFragment = new SystemManageFragment();
                    ft.add(R.id.ll_content, systemManageFragment);
                }
                ivsetup.setImageResource(R.mipmap.setup_red);
                tvSetup.setTextColor(UIUtils.getcolor(R.color.login_red));
                ft.show(systemManageFragment);
                break;
        }
        ft.commit();
    }

    //重置Fragment状态
    private void resetTab() {
        ivmap.setImageResource(R.mipmap.map);
        ivinformation.setImageResource(R.mipmap.activity);
        ivsetup.setImageResource(R.mipmap.setup);

        tvMap.setTextColor(UIUtils.getcolor(R.color.gray_gray));
        tvInformation.setTextColor(UIUtils.getcolor(R.color.gray_gray));
        tvSetup.setTextColor(UIUtils.getcolor(R.color.gray_gray));
    }


    //隐藏前一个显示的Fragment
    private void hideFragment() {
        if (infoServiceFragment != null) {
            ft.hide(infoServiceFragment);
        }
        if (mapServiceFragment != null) {
            ft.hide(mapServiceFragment);
        }
        if (systemManageFragment != null) {
            ft.hide(systemManageFragment);
        }
    }

}
