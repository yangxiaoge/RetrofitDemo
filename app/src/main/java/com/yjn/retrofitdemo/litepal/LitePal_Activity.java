package com.yjn.retrofitdemo.litepal;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yjn.retrofitdemo.R;
import com.yjn.retrofitdemo.litepal.models.Album;
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

//        Album album = new Album();
//        album.setName("我在南京");
//        album.setPrice(10.09f);
//        album.setCover("1,2,3,4,5".getBytes());
//        album.save();
//
//        Song song1 = new Song();
//        song1.setName("my love");
//        song1.setDuration(320);
//        song1.setAlbum(album);
//        song1.save();
//
//        Song song2 = new Song();
//        song2.setName("我爱的人");
//        song2.setDuration(356);
//        song2.setAlbum(album);
//
//        List<Song> songList = DataSupport.findAll(Song.class);
//        System.out.println("Alum中的歌曲: "+ songList.toString());
    }
}