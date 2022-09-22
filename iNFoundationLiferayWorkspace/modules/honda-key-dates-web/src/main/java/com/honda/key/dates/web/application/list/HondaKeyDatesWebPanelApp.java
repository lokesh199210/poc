package com.honda.key.dates.web.application.list;

import com.honda.key.dates.web.constants.HondaKeyDatesWebPanelCategoryKeys;
import com.honda.key.dates.web.constants.HondaKeyDatesWebPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Lokesh Sharma2
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + HondaKeyDatesWebPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class HondaKeyDatesWebPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return HondaKeyDatesWebPortletKeys.HONDAKEYDATESWEB;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + HondaKeyDatesWebPortletKeys.HONDAKEYDATESWEB + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}