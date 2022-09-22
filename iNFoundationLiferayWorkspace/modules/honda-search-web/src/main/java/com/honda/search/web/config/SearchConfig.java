package com.honda.search.web.config;

import aQute.bnd.annotation.metatype.Meta;

public interface SearchConfig {
	@Meta.AD(deflt="",required = true)
	public String configuredAssetLibraryId();

}
