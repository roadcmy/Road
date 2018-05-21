package project.road.com.road.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import project.road.com.road.R;
import project.road.com.road.base.BaseFragment;
import project.road.com.road.utils.UIUtils;

/**
 * Created by biabia on 2018/5/8.
 */

public class MusicActivity extends BaseFragment{

    private List<Music> musicList = new ArrayList<>();

    //音乐会图片、标题、简介
    public class Music {
        private String title;
        private String introduce;
        private int picture;

        public Music(String title,String introduce,int picture) {
            this.title = title;
            this.introduce = introduce;
            this.picture = picture;
        }

        public String getTitle(){
            return title;
        }

        public String getIntroduce(){
            return introduce;
        }

        public int getPicture(){
            return picture;
        }
    }

    public class MusicAdapter extends ArrayAdapter<Music> {
        private int resourceId;

        public MusicAdapter(@NonNull Context context, int textViewResourceId, List<Music> object) {
            super(context, textViewResourceId,object);
            resourceId = textViewResourceId;

        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Music music = getItem(position);//获取当前项的Music实例
            View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            ImageView musicPicture = (ImageView) view.findViewById(R.id.iv_mpicture);
            TextView musicTitle = (TextView) view.findViewById(R.id.tv_musicTitle);
            TextView musicIntroduce = (TextView) view.findViewById(R.id.tv_musicintroduce);
            musicPicture.setImageResource(music.getPicture());
            musicTitle.setText(music.getTitle());
            musicIntroduce.setText(music.getIntroduce());
            return view;
        }
    }

    @Override
    public View initView() {
        View view = UIUtils.getXmlView(R.layout.music);
        initMusic();//初始化音乐会数据
        MusicAdapter adapter = new MusicAdapter(getActivity(),R.layout.music_fragment,musicList);
        ListView listView = (ListView)view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        return view;
    }

    private void initMusic() {
        for(int i=0;i<3;i++){
            Music a = new Music("《四月是你的谎言》——“公主”与“熏”的钢琴小提琴","介绍：\n" +
                    "正因为有了音乐",R.mipmap.a);
            musicList.add(a);
            Music b = new Music("《发顺丰是的回复》——都是身高多少个","介绍：\n" +
                    "正地方三个地方混淆是非",R.mipmap.b);
            musicList.add(b);
            Music c= new Music("《啊师傅安抚个干事》——撒发发地方是否是发","介绍：\n" +
                    "舒服速度杠杠的过分",R.mipmap.a);
            musicList.add(c);
        }
    }

    @Override
    public void initData() {

    }
}
