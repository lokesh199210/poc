package com.honda.filter.web.config;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.honda.filter.web.config.FilterWebConfig")
public interface FilterWebConfig {
	@Meta.AD(deflt="",required = true)
	public String portletView();
}
