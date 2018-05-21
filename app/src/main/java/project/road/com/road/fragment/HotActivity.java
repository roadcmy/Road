package project.road.com.road.fragment;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import project.road.com.road.R;
import project.road.com.road.activity.MainActivity;
import project.road.com.road.base.BaseFragment;
import project.road.com.road.utils.UIUtils;

/**
 * Created by biabia on 2018/5/8.
 */

public class HotActivity extends BaseFragment{

    private ViewPager viewPager;
    private int[] imageRseIds;
    private ArrayList<ImageView> imageViewList;
    private LinearLayout ll_point_container;
    private int lastEnablePoint=0;
    boolean isRunning=false;

    @Override
    public View initView() {
        View view = UIUtils.getXmlView(R.layout.main_hot);

//        initViews();
//
//        initData();
//
//        initAdapter();

//        new Thread(){
//            public void run(){
//                isRunning = true;
//                while (isRunning){
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    getActivity().runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            System.out.println("设置当前位置:"+viewPager.getCurrentItem());
//                            viewPager.setCurrentItem(viewPager.getCurrentItem());
//                        }
//                    });
//                }
//            }
//        }.start();
        return view;
    }

    //    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        isRunning=false;
//    }
//
//    private void initViews() {
//        viewPager = getView().findViewById(R.id.iv_picture);
//        viewPager.setOnPageChangeListener(this);
//        ll_point_container = getView().findViewById(R.id.point);
//    }
//
    public void initData(){
//
//        imageRseIds = new int[]{R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e};
//
//        imageViewList = new ArrayList<ImageView>();
//
//        ImageView imageView;
//        View pointView;
//        LinearLayout.LayoutParams layoutParams;
//
//        for(int i=0;i<imageRseIds.length;i++) {
//            imageView = new ImageView(getActivity());
//            imageView.setBackgroundResource(imageRseIds[i]);
//            imageViewList.add(imageView);
//
//            //加小白点 指示器
//            pointView = new View(getActivity());
//            pointView.setBackgroundResource(R.drawable.point_bg);
//            layoutParams = new LinearLayout.LayoutParams(16,16);
//
//            if(i!=0){
//                layoutParams.leftMargin = 50;
//
//                pointView.setEnabled(false);
//                ll_point_container.addView(pointView,layoutParams);
//            }
//        }
    }
//
//    private void initAdapter() {
//        ll_point_container.getChildAt(0).setEnabled(true);
//        lastEnablePoint=0;
//        viewPager.setAdapter(new MyAdapter());
//
//        int pos = Integer.MAX_VALUE/2-(Integer.MAX_VALUE / 2 % imageViewList.size());
//        viewPager.setCurrentItem(pos);
//    }
//
//
//    class MyAdapter extends PagerAdapter {
//        @Override
//        public int getCount() {
//            return Integer.MAX_VALUE;
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view ==object;
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            System.out.println("instantiateItem初始化:" + position);
//            int newPosition = position % imageViewList.size();
//            ImageView imageView = imageViewList.get(newPosition);
//            container.addView(imageView);
//            return imageView;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            System.out.println("destroyItem销毁:" + position);
//
//            container.removeView((View)object);
//        }
//    }
//
//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        //滚动时调用
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//        //新的条目被选中时调用
//        System.out.println("onPageSelected：" + position);
//        int newPosition = position % imageViewList.size();
//
//        ll_point_container.getChildAt(lastEnablePoint).setEnabled(false);
//        ll_point_container.getChildAt(newPosition).setEnabled(true);
//        lastEnablePoint=newPosition;
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//    }
}