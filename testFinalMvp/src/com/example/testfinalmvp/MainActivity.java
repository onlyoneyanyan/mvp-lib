package com.example.testfinalmvp;

import com.org.finalmvp.view.BaseView;
import com.presenter.UserPresenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements BaseView, OnClickListener {

	Context context = MainActivity.this;

	UserPresenter userpresenter;

	TextView tv_info;
	Button btStart;
	Button btStop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		userpresenter = new UserPresenter(this);
	}

	private void initView() {
		tv_info = (TextView) findViewById(R.id.tv_info);
		btStart = (Button) findViewById(R.id.bt_start);
		btStart.setOnClickListener(this);
		btStop = (Button) findViewById(R.id.bt_stop);
		btStop.setOnClickListener(this);
	}

	/**
	 * ����֪ͨ�ؼ���״̬�ı� û�з������ݵ�����
	 */
	@Override
	public void onDataChanage(int dataId) {
		tv_info.setText(String.valueOf(dataId));
	}

	/**
	 * ���𽫷��ص��������� ����ı�ؼ�������
	 */
	@Override
	public void onChanageUi(int tag, Object msg) {
		switch (tag) {
		case UserPresenter.START_LOAD_DATA:
			tv_info.setText("start action...");
			break;
		case UserPresenter.STOP_LOAD_DATA:
			tv_info.setText("stop action....");
			break;
		default:
			break;
		}
		Toast.makeText(MainActivity.this, msg + " tab:=" + tag, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_start:
			startOnclick(v);
			break;
		case R.id.bt_stop:
			stopOnclick(v);
			break;
		default:
			break;
		}
	}

	private void stopOnclick(View v) {
		userpresenter.stopAction();
	}

	private void startOnclick(View v) {
		userpresenter.startAction();
	}

}
