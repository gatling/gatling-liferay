package io.gatling.liferay.model.AST.process;

import io.gatling.liferay.model.AST.resource.ResourceFileAST;

import java.util.List;

/**
 * ProcessAST represents the structure of a process.
 * This class handles the source code generation of a
 * process.
 */
public abstract class ProcessAST {
	
	/**
	 * The scala Object name
	 */
	protected String scalaObject;
	
	/**
	 *  The scala function name
	 */
	protected String scalaFunction;
	
	/**
	 * The pause between this process and the next one
	 */
	protected int pause;
	
	
	
	
	protected ProcessAST(String scalaObject, String scalaFunction){
		this.scalaObject = scalaObject;
		this.scalaFunction = scalaFunction;
	}
	

	/**
	 * Gets the pause that will be performed after this process.
	 * @return The pause after this process
	 */
	public int getPause() {
		return this.pause;
	}
	
	/**
	 * Sets the pause that will be performed after this process.
	 * @param p the pause after this process
	 */
	public void setPause(int p){
		this.pause = p;
	}
	
	
	
	
	/**
	 * Computes the code of the process
	 * 
	 * All process are used as the following way: Object.function(...args...)
	 * (for example: GetPage.randomPage(feederFile)
	 * 
	 * 
	 * Since Mustache is logicless, we used polymorphisme for code generation:
	 * all processes compute arguments their own way through the computeArguments method
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
	 * Computes a String that will represent the process function call's arguments
	 * separeted with commas.
	 * 
	 * @return The String representation of the arguments
	 */
	protected abstract String computeArguments();
	
	/**
	 * Return the several feeders that contains the data associated with the
	 * process
	 * 
	 * @return the process's feeder
	 */
	public abstract List<ResourceFileAST> getFeederFiles();
	
	
	@Override
	public String toString() {
		return "Object: " + scalaObject + "\tFunction: " + scalaFunction;
	}
	
}
