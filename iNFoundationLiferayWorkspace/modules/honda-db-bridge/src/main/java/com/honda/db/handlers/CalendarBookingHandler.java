package com.honda.db.handlers;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
	immediate = true,
	service = CalendarBookingHandler.class
)
public class CalendarBookingHandler {

	
	public List<CalendarBooking> getCalenderBookingsByGrp(long groupId) {
		
		DynamicQuery dq = calendarBookingLocalService.dynamicQuery();
		
		dq.add(RestrictionsFactoryUtil.eq("groupId", groupId));
		
		return calendarBookingLocalService.dynamicQuery(dq);
		
	}
	
	@Reference
	private CalendarBookingLocalService calendarBookingLocalService;
	
}
