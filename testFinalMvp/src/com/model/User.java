package com.model;

import com.org.finalmvp.model.BaseModel;

public class User extends BaseModel {

	@Override
	public void loadData(final int tag, Object msg) {

		new Thread() {
			public void run() {
				// 执行耗时操作,如执行http请求,从sqlite中读取或计算数据
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 返回得到计算后的数据,将数据返回
				chanageData(tag, "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
			};
		}.start();

	}

}
