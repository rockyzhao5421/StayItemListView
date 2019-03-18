package com.bignerdranch.android.stayitemlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mBlockHeader;
    private ListView mListView;
    private String[] mStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initStrArray();
        mBlockHeader = findViewById(R.id.block_header);
        mListView = findViewById(R.id.list_view);
        View header = View.inflate(this, R.layout.view_list_view_header_view, null);
        mListView.addHeaderView(header);
        mListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mStrings));
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem >= 1) {  //头部部分是0，悬浮部分是1
                    mBlockHeader.setVisibility(View.VISIBLE);
                } else {

                    mBlockHeader.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initStrArray() {
        mStrings = new String[50];
        for (int i = 0; i < mStrings.length; i++) {
            mStrings[i] = "Item " + i;
        }
    }
}
