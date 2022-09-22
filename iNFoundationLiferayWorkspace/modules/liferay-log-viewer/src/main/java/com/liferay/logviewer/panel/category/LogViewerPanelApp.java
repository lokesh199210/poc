package com.liferay.logviewer.panel.category;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.log.viewer.constants.LiferayLogViewerPortletKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"panel.app.order:Integer=500",
			"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_CONFIGURATION
		},
		service = PanelApp.class
	)
public class LogViewerPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return LiferayLogViewerPortletKeys.LIFERAYLOGVIEWER;
	}

	@Override
	@Reference(
			target = "(javax.portlet.name=" + LiferayLogViewerPortletKeys.LIFERAYLOGVIEWER + ")",
			unbind = "-"
		)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}
