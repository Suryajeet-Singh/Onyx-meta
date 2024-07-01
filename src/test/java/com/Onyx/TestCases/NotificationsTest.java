package com.Onyx.TestCases;

import com.bwp.pageobjects.NotificationsPage;
import com.bwp.resources.BaseClass;

public class NotificationsTest extends BaseClass{

	public void runNotificationsTest() {
		NotificationsPage np = new NotificationsPage(util);
		np.OM_TC_LPN_001();
		np.OM_TC_LPN_002();
		np.OM_TC_NP_002_006();
		np.OM_TC_NP_006();
	}
}
