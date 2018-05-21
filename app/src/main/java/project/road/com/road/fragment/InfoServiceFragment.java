package project.road.com.road.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import project.road.com.road.R;
import project.road.com.road.base.BaseFragment;
import project.road.com.road.utils.UIUtils;

/**
 * Created by Administrator on 2018/3/17.
 */

public class InfoServiceFragment extends BaseFragment {
    @Bind(R.id.Hot_text)
    TextView HotText;
    @Bind(R.id.Music_text)
    TextView MusicText;
    @Bind(R.id.Movie_text)
    TextView MovieText;
    @Bind(R.id.btnhot)
    Button btnhot;
    @Bind(R.id.btnmusic)
    Button btnmusic;
    @Bind(R.id.btnmovie)
    Button btnmovie;


    public Activity mActivity;
    private HotActivity hotActivity;
    private MusicActivity musicActivity;
    private MovieActivity movieActivity;
    private FragmentTransaction ft;
    @Override
    public View initView() {
        View view = UIUtils.getXmlView(R.layout.main_music);
        ButterKnife.bind(getActivity());
        return view;
    }
    @OnClick({R.id.Hot_text,R.id.Music_text,R.id.Movie_text})
    public void changeTab(View view){
        switch (view.getId()){
            case R.id.Hot_text:
                setSelect(0);
                break;
            case R.id.Music_text:
                setSelect(1);
                break;
            case R.id.Movie_text:
                setSelect(2);
                break;
        }
    }

    private void setSelect(int i) {
        android.support.v4.app.FragmentManager fm = getFragmentManager();
        ft = fm.beginTransaction();
        hideFragment();
        resetTab();
        switch (i){
            case 0:
                if (hotActivity == null) {
                    hotActivity = new HotActivity();
                    ft.add(R.id.fl_activity, hotActivity);
                }
                btnhot.setBackgroundColor(UIUtils.getcolor(R.color.white));
                HotText.setTextColor(UIUtils.getcolor(R.color.back_blue));
                ft.show(hotActivity);
                break;
            case 1:
                if (musicActivity == null) {
                    musicActivity = new MusicActivity();
                    ft.add(R.id.fl_activity, musicActivity);
                }
                btnmusic.setBackgroundColor(UIUtils.getcolor(R.color.white));
                MusicText.setTextColor(UIUtils.getcolor(R.color.back_blue));
                ft.show(hotActivity);
                break;
            case 2:
                if (movieActivity == null) {
                    movieActivity = new MovieActivity();
                    ft.add(R.id.fl_activity, movieActivity);
                }
                btnmovie.setBackgroundColor(UIUtils.getcolor(R.color.white));
                MovieText.setTextColor(UIUtils.getcolor(R.color.back_blue));
                ft.show(movieActivity);
                break;
        }
        ft.commit();
    }
    //重置Fragment状态.
    private void resetTab() {
        btnhot.setBackgroundColor(UIUtils.getcolor(R.color.blackred));
        btnmusic.setBackgroundColor(UIUtils.getcolor(R.color.blackred));
        btnmovie.setBackgroundColor(UIUtils.getcolor(R.color.blackred));

        HotText.setTextColor(UIUtils.getcolor(R.color.white));
        MusicText.setTextColor(UIUtils.getcolor(R.color.white));
        MovieText.setTextColor(UIUtils.getcolor(R.color.white));
    }
    //隐藏前一个显示的Fragment
    private void hideFragment() {
        if (hotActivity != null) {
            ft.hide(hotActivity);
        }
        if (musicActivity != null) {
            ft.hide(musicActivity);
        }
        if (movieActivity != null) {
            ft.hide(movieActivity);
        }
    }


    @Override
    public void initData() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
