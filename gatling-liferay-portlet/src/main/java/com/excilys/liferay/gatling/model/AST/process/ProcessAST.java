package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;

import java.util.List;

public abstract class ProcessAST {
	protected String scalaObject;
	protected String scalaFunction;
	protected List<String> params;
	
	public String printCode() {
		String paramContent = "";
		
		//Following code set the param content in an ugly way, java8 improvement would clean this up with Streams
		for (String param : params) {
			paramContent += ("\""+param+"\""+", ");
		}
		
		// Remove the comma for the last param 
		if (!params.isEmpty())
			paramContent = paramContent.substring(0, paramContent.length() -2);
		
		return scalaObject + "." + scalaFunction + "(" +paramContent+ ")";
	}
	
	/**
	 * Return the several feeders that contains the data associated with the process
	 * @return the process's feeder
	 */
	public abstract List<FeederFileAST> getFeederFiles();
	
	@Override
	public String toString() {
		return "Object: " + scalaObject + "\tFunction: " + scalaFunction +"\tFeederFile:"+params.toString(); 
	}
}
