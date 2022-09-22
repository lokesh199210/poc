package com.honda.in.admin.web.config;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.honda.in.admin.web.config.ModuleConfig")
public interface ModuleConfig {

	@Meta.AD(deflt="",required = true)
	public String portletView();
}
