package com.model;

import com.org.finalmvp.model.BaseModel;

public class User extends BaseModel {

	@Override
	public void loadData(final int tag, Object msg) {

		new Thread() {
			public void run() {
				// ִ�к�ʱ����,��ִ��http����,��sqlite�ж�ȡ���������
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// ���صõ�����������,�����ݷ���
				chanageData(tag, "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
			};
		}.start();

	}

}
