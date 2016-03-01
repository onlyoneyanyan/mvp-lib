package com.presenter;

import com.model.User;
import com.org.finalmvp.model.BaseModel;
import com.org.finalmvp.presenter.BasePresenter;
import com.org.finalmvp.view.BaseView;

public class UserPresenter extends BasePresenter {

	public static final int START_LOAD_DATA = 1;

	public static final int STOP_LOAD_DATA = 2;

	public UserPresenter(BaseView view) {
		super(view);
	}

	@Override
	public BaseModel initModel() {
		return new User();
	}

	@Override
	public void onModelCallBack(int tag, Object obj) {
		switch (tag) {
		case START_LOAD_DATA:
			chanageViewUi(tag, obj);
			break;

		case STOP_LOAD_DATA:
			chanageViewUi(tag, obj);
			break;

		default:
			break;
		}
	}

	@Override
	public void onModelErrorBack(int tag, String msg) {

	}

	public void startAction() {
		loadData(START_LOAD_DATA, "http://xxxxx");
	}

	public void stopAction() {
		loadData(STOP_LOAD_DATA, "http://xxxxx");
	}

}
