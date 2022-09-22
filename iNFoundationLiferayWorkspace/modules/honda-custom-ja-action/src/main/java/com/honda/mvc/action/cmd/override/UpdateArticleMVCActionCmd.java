package com.honda.mvc.action.cmd.override;

import com.honda.ws.invokers.LucidworksIndexWebService;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.dynamic.data.mapping.util.DDMUtil;
import com.liferay.journal.constants.JournalPortletKeys;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Lokesh Sharma
 */
@Component(
	  immediate = true,
	  property = {
	     "javax.portlet.name=" + JournalPortletKeys.JOURNAL,
	     "mvc.command.name=/journal/add_article",
	     "service.ranking:Integer=100"
	  },
	  service = MVCActionCommand.class
)
public class UpdateArticleMVCActionCmd extends BaseMVCActionCommand{
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		if(mvcActionCommand.processAction(actionRequest, actionResponse)) {
			
		
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			Map<String,String> attributeMap = new HashMap<>();
			
			UploadPortletRequest uploadPortletRequest = portal.getUploadPortletRequest(actionRequest);
	
			long groupId = ParamUtil.getLong(uploadPortletRequest, "groupId");
				
			String articleId = ParamUtil.getString(uploadPortletRequest, "articleId");
			
			attributeMap.put("articleId", articleId);
			
			Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(actionRequest, "titleMapAsXML");
			
			attributeMap.put("title", HtmlUtil.extractText(titleMap.get(themeDisplay.getLocale())));
			
			String ddmStructureKey = ParamUtil.getString(uploadPortletRequest, "ddmStructureKey");
	
			DDMStructure ddmStructure = ddmStructureLocalService.getStructure(portal.getSiteGroupId(groupId),
					portal.getClassNameId(JournalArticle.class), ddmStructureKey, true);
	
			ServiceContext serviceContext = ServiceContextFactory.getInstance(JournalArticle.class.getName(),
					uploadPortletRequest);
	
			Fields fields = DDMUtil.getFields(ddmStructure.getStructureId(), serviceContext);
					
			fields.forEach(obj -> attributeMap.put(obj.getName(), HtmlUtil.extractText(obj.getValue().toString())));
	
			Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(actionRequest,
					"descriptionMapAsXML");
			
			attributeMap.put("description", HtmlUtil.extractText(descriptionMap.get(themeDisplay.getLocale())));
			
			
			// Fetch categories
			
			//if service  - send notification to service user
			
			
			
			lucidWorksWebService.indexContent(attributeMap);
			
		}
	}
	


	@Reference(target = "(component.name=com.liferay.journal.web.internal.portlet.action.UpdateArticleMVCActionCommand)")
	protected MVCActionCommand mvcActionCommand;
	
	@Reference
	private DDMStructureLocalService ddmStructureLocalService;
	
	@Reference
	private JournalArticleService journalArticleService;
	
	@Reference
	private Portal portal;
	
	@Reference
	private LucidworksIndexWebService lucidWorksWebService;

}