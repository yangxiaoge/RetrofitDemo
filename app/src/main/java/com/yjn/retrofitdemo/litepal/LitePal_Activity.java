package com.yjn.retrofitdemo.litepal;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yjn.retrofitdemo.R;
import com.yjn.retrofitdemo.litepal.models.Song;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by yjn on 2016/11/18.
 */

public class LitePal_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.litepal);

        // 根据 litepal.xml中 mapping, dbname等配置,创建数据库
        SQLiteDatabase db = LitePal.getDatabase();

        /*Album album = new Album();
        album.setName("我在江苏南京");
        album.setPrice(10.09f);
        //album.setCover("1,2,3,4,5".getBytes());
        album.save();

        Song song1 = new Song();
        song1.setName("my love");
        song1.setDuration(320);
        song1.setAlbum(album);
        song1.save();

        Song song2 = new Song();
        song2.setName("我爱的人");
        song2.setDuration(356);
        song2.setAlbum(album);
        song2.save();

        //查询
        List<Song> songList = DataSupport.findAll(Song.class);
        String str = "";
        for (Song item : songList) {
            str += item.toString() + "\n";
        }
        System.out.println("Alum中的歌曲: " + str);*/

        // 按条件查询
        List<Song> whereQry = DataSupport.where("name like ?", "%爱%").order("duration").find(Song.class);
        String str = "";
        for (Song item : whereQry) {
            str += item.toString() + "\n";
        }
        System.out.println("按名字查询歌曲: \n" + str);
    }
}