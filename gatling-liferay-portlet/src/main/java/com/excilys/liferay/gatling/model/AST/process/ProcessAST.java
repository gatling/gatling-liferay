package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;

import java.util.List;

public abstract class ProcessAST {
	protected String scalaObject;
	protected String scalaFunction;
	
	public ProcessAST(String scalaObject, String scalaFunction){
		this.scalaObject = scalaObject;
		this.scalaFunction = scalaFunction;
	}
	
	/**
	 * Computes the code of the process
	 * 
	 * @return The process's code
	 */
	public String printCode() {
		StringBuilder codeBuilder = new StringBuilder(scalaObject)
				.append(".")
				.append(scalaFunction)
				.append("(")
				.append(computeArguments())
				.append(")");
		return codeBuilder.toString();
	}

	/**
	 * Computes a String that will represents the process function call's arguments
	 * separeted with commas.
	 * @return The String representation of the arguments
	 */
	protected abstract String computeArguments();
	
	/**
	 * Return the several feeders that contains the data associated with the
	 * process
	 * 
	 * @return the process's feeder
	 */
	public abstract List<FeederFileAST> getFeederFiles();

	@Override
	public String toString() {
		return "Object: " + scalaObject + "\tFunction: " + scalaFunction;
	}
}
