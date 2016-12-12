package com.alexoro.simplepool.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alexoro.simplepool.ObjectFactory;
import com.alexoro.simplepool.SimplePool;
import com.alexoro.simplepool.SimplePoolBase;

/**
 * Created by uas.sorokin@gmail.com
 */
public class MainActivity extends Activity {

    private SimplePool<Object> mSimplePool;
    private Object mObjectFromPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mSimplePool = new SimplePoolBase<>(new ObjectFactory<Object>() {
            // required callback
            @Override
            public Object newObject() {
                return new Object();
            }

            // optional callback
            @Override
            public void reset(Object object) {
                super.reset(object);
            }
        });
        mObjectFromPool = null;

        Button buttonAcquire = (Button) findViewById(R.id.acquire);
        Button buttonRelease = (Button) findViewById(R.id.release);
        buttonAcquire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acquire();
            }
        });
        buttonRelease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                release();
            }
        });
    }

    private void acquire() {
        mObjectFromPool = mSimplePool.acquire();
    }

    private void release() {
        if (mObjectFromPool != null) {
            mSimplePool.release(mObjectFromPool);
        }
    }

}