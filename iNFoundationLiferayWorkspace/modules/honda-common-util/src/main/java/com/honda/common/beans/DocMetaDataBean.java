package com.honda.common.beans;

import com.honda.commom.utils.CommonUtil;
import com.honda.commom.utils.ObjectMapperUtil;
import com.honda.obj.mapper.beans.ABGapRateGuideBean;
import com.honda.obj.mapper.beans.AccessoryInstallationBean;
import com.honda.obj.mapper.beans.AccessoryMarketingPromotionsBean;
import com.honda.obj.mapper.beans.DfsFinanceBean;
import com.honda.obj.mapper.beans.DivionCodeBean;
import com.honda.obj.mapper.beans.INDocumentBean;
import com.honda.obj.mapper.beans.MCAccessoryMarketingBean;
import com.honda.obj.mapper.beans.MGAPRateGuideBean;
import com.honda.obj.mapper.beans.MRetailRatesBean;
import com.honda.obj.mapper.beans.PartsBulletinBean;
import com.honda.obj.mapper.beans.PartsMarketingPromotionsBean;
import com.honda.obj.mapper.beans.ServiceBulletinsBean;
import com.honda.obj.mapper.beans.SetupInstructionsBean;
import com.honda.obj.mapper.beans.SpecialToolsBean;
import com.honda.obj.mapper.beans.WarrantyVinBean;
import com.liferay.petra.string.StringPool;

public class DocMetaDataBean {


	public DocMetaDataBean(String contentType,String metaDataJSON) {
		super();
		this.metaDataJSON = metaDataJSON;
		this.contentType = contentType;
		setObject();
	}

	public String getMetaDataJSON() {
		return metaDataJSON;
	}
	
	public String getContentType() {
		return contentType;
	}
	
	private void setObject() {
		
		if(CommonUtil.checkDocumentType(contentType)){
			object = ObjectMapperUtil.parseToBean(metaDataJSON, DivionCodeBean.class);
		}else {
		
			switch(contentType) {
			
			case "iN Document" :
				
				object = ObjectMapperUtil.parseToBean(metaDataJSON, INDocumentBean.class);
				break;
				
			case "Parts Bulletins" :
				
				object = ObjectMapperUtil.parseToBean(metaDataJSON, PartsBulletinBean.class);
				break;
				
			case "Accessory Installation Instructions" :
				object = ObjectMapperUtil.parseToBean(metaDataJSON, AccessoryInstallationBean.class);
				break;
				
			case "Special Tools" :
				object = ObjectMapperUtil.parseToBean(metaDataJSON, SpecialToolsBean.class);
				break;
				
			case "Accessory Marketing Promotions" :
					object = ObjectMapperUtil.parseToBean(metaDataJSON, AccessoryMarketingPromotionsBean.class);
				break;
				
			case "M GAP - Rate Guide" :
				object = ObjectMapperUtil.parseToBean(metaDataJSON, MGAPRateGuideBean.class);
				break;
				
			case "DFS Finance Programs" :
				object = ObjectMapperUtil.parseToBean(metaDataJSON, DfsFinanceBean.class);
				break;
				
			case "AB GAP - Rate Guide" :
				object = ObjectMapperUtil.parseToBean(metaDataJSON, ABGapRateGuideBean.class);
			    break;
			    
			case "Setup Instructions" :
				object = ObjectMapperUtil.parseToBean(metaDataJSON, SetupInstructionsBean.class);
			    break;
			    
			case "Parts Marketing Promotions" :
				object = ObjectMapperUtil.parseToBean(metaDataJSON, PartsMarketingPromotionsBean.class);
			    break;
			   
			case "MC Accessory Marketing" :
				object = ObjectMapperUtil.parseToBean(metaDataJSON, MCAccessoryMarketingBean.class);
			break;
			
			case "Warranty & VIN Guide" :
				object = ObjectMapperUtil.parseToBean(metaDataJSON, WarrantyVinBean.class);
			break;
			
			case "M Retail Rates" :
				object = ObjectMapperUtil.parseToBean(metaDataJSON, MRetailRatesBean.class);
				break;
			
			case "Bulletins - Service Bulletins": 
		          object = ObjectMapperUtil.parseToBean(metaDataJSON, ServiceBulletinsBean.class); 			
				  break;
				  

			default :
					
				break;
			
			}
		}
	}
	
	public String getValueByName(String name) {
		
		if(CommonUtil.checkDocumentType(contentType))
			return ((DivionCodeBean)object).getValueByName(name);
		
		switch(contentType) {
		
		case "iN Document" :
			
			return ((INDocumentBean)object).getValueByName(name);
			
		case "Parts Bulletins" :
			
			return ((PartsBulletinBean)object).getValueByName(name);
			
		case "Accessory Installation Instructions":
			return ((AccessoryInstallationBean)object).getValueByName(name);
			
		case "Special Tools":
			return ((SpecialToolsBean)object).getValueByName(name);
			
		case "Accessory Marketing Promotions":
			return ((AccessoryMarketingPromotionsBean)object).getValueByName(name);
			
		case "M GAP - Rate Guide":
			return ((MGAPRateGuideBean)object).getValueByName(name);
			
		case "DFS Finance Programs":
			return ((DfsFinanceBean)object).getValueByName(name);
			
		case "AB GAP - Rate Guide":
			return ((ABGapRateGuideBean)object).getValueByName(name);
		case "Bulletins - Service Bulletins":
			return((ServiceBulletinsBean)object).getValueByName(name);
			
		case "Setup Instructions":
			return ((SetupInstructionsBean)object).getValueByName(name);
		
		case "Parts Marketing Promotions":
			return ((PartsMarketingPromotionsBean)object).getValueByName(name);
			
		case "MC Accessory Marketing":
			return ((MCAccessoryMarketingBean)object).getValueByName(name);
			
		case "Warranty & VIN Guide":
			return ((WarrantyVinBean)object).getValueByName(name);
			
		case "M Retail Rates":
			return ((MRetailRatesBean)object).getValueByName(name);
			
		default :
				
			return StringPool.BLANK;
		
		}
	}
	
	private String contentType;
	
	private String metaDataJSON ;
	
	private Object object ;
	
}
