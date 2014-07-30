package com.excilys.liferay.gatling.mustache;

import java.util.List;

public interface ScriptGeneratorGatling {

	List<MustacheScenario> mustacheScenario() throws Exception;
	void setId(long id)throws Exception;
	

}
