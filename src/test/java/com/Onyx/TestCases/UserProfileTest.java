package com.Onyx.TestCases;

import com.bwp.pageobjects.UserProfilePage;
import com.bwp.resources.BaseClass;

public class UserProfileTest extends BaseClass{

	public void runUserProfileTest() {
		UserProfilePage opp = new UserProfilePage(util);
		opp.OM_TC_SET_001();
		opp.OM_TC_LOG_001();
		opp.OM_TC_LOG_002();
		opp.OM_TC_LOG_003();
		opp.OM_TC_LOG_004();
	}
}
