package project.road.com.road.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import project.road.com.road.R;
import project.road.com.road.fragment.ActivityCenterFragment;
import project.road.com.road.fragment.InfoServiceFragment;
import project.road.com.road.fragment.MapServiceFragment;
import project.road.com.road.fragment.SystemManageFragment;
import project.road.com.road.utils.UIUtils;

public class MainActivity extends FragmentActivity {

    @Bind(R.id.iv_activity_icon)
    ImageView ivActivityIcon;
    @Bind(R.id.ll_activity_icon)
    LinearLayout llActivityIcon;
    @Bind(R.id.iv_map_icon)
    ImageView ivMapIcon;
    @Bind(R.id.ll_map_icon)
    LinearLayout llMapIcon;
    @Bind(R.id.iv_info_icon)
    ImageView ivInfoIcon;
    @Bind(R.id.ll_info_icon)
    LinearLayout llInfoIcon;
    @Bind(R.id.iv_set_icon)
    ImageView ivSetIcon;
    @Bind(R.id.ll_set_icon)
    LinearLayout llSetIcon;
    @Bind(R.id.tv_activity_icon)
    TextView tvActivityIcon;
    @Bind(R.id.tv_map_icon)
    TextView tvMapIcon;
    @Bind(R.id.tv_info_icon)
    TextView tvInfoIcon;
    @Bind(R.id.tv_set_icon)
    TextView tvSetIcon;

    public Activity mActivity;
    private ActivityCenterFragment activityCenterFragment;
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


    @OnClick({R.id.ll_activity_icon, R.id.ll_map_icon, R.id.ll_info_icon, R.id.ll_set_icon})
    public void changeTab(View view) {
        switch (view.getId()) {
            case R.id.ll_activity_icon:
                setSelect(0);
                break;
            case R.id.ll_map_icon:
                setSelect(1);
                break;
            case R.id.ll_info_icon:
                setSelect(2);
                break;
            case R.id.ll_set_icon:
                setSelect(3);
                break;
        }
    }


    //重置Fragment的状态
    private void resetTab() {
        ivActivityIcon.setImageResource(R.mipmap.activity_off);
        ivInfoIcon.setImageResource(R.mipmap.info_off);
        ivMapIcon.setImageResource(R.mipmap.map_off);
        ivSetIcon.setImageResource(R.mipmap.set_off);

        tvActivityIcon.setTextColor(UIUtils.getcolor(R.color.home_back_unselected));
        tvInfoIcon.setTextColor(UIUtils.getcolor(R.color.home_back_unselected));
        tvMapIcon.setTextColor(UIUtils.getcolor(R.color.home_back_unselected));
        tvSetIcon.setTextColor(UIUtils.getcolor(R.color.home_back_unselected));
    }


    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        hideFragment();
        resetTab();
        switch (i) {
            case 0:
                if (activityCenterFragment == null) {
                    activityCenterFragment = new ActivityCenterFragment();
                    ft.add(R.id.fl_main_fagment, activityCenterFragment);
                }
                ivActivityIcon.setImageResource(R.mipmap.activity_on);
                tvActivityIcon.setTextColor(UIUtils.getcolor(R.color.home_back_selected));
                ft.show(activityCenterFragment);
                break;
            case 1:
                if (mapServiceFragment == null) {
                    mapServiceFragment = new MapServiceFragment();
                    ft.add(R.id.fl_main_fagment, mapServiceFragment);
                }
                ivMapIcon.setImageResource(R.mipmap.map_on);
                tvMapIcon.setTextColor(UIUtils.getcolor(R.color.home_back_selected));
                ft.show(mapServiceFragment);
                break;
            case 2:
                if (infoServiceFragment == null) {
                    infoServiceFragment = new InfoServiceFragment();
                    ft.add(R.id.fl_main_fagment, infoServiceFragment);
                }
                ivInfoIcon.setImageResource(R.mipmap.info_on);
                tvInfoIcon.setTextColor(UIUtils.getcolor(R.color.home_back_selected));
                ft.show(infoServiceFragment);
                break;
            case 3:
                if (systemManageFragment == null) {
                    systemManageFragment = new SystemManageFragment();
                    ft.add(R.id.fl_main_fagment, systemManageFragment);
                }
                ivSetIcon.setImageResource(R.mipmap.set_on);
                tvSetIcon.setTextColor(UIUtils.getcolor(R.color.home_back_selected));
                ft.show(systemManageFragment);
                break;
        }
        ft.commit();
    }


    //隐藏前一个显示的Fragment
    private void hideFragment() {
        if (activityCenterFragment != null) {
            ft.hide(activityCenterFragment);
        }
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
