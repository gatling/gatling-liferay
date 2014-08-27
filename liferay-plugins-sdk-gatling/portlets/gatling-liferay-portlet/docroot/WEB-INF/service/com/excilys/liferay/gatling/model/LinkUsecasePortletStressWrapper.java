/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.excilys.liferay.gatling.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LinkUsecasePortletStress}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkUsecasePortletStress
 * @generated
 */
public class LinkUsecasePortletStressWrapper implements LinkUsecasePortletStress,
	ModelWrapper<LinkUsecasePortletStress> {
	public LinkUsecasePortletStressWrapper(
		LinkUsecasePortletStress linkUsecasePortletStress) {
		_linkUsecasePortletStress = linkUsecasePortletStress;
	}

	@Override
	public Class<?> getModelClass() {
		return LinkUsecasePortletStress.class;
	}

	@Override
	public String getModelClassName() {
		return LinkUsecasePortletStress.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("linkUsecasePortletStressId",
			getLinkUsecasePortletStressId());
		attributes.put("portletStressId", getPortletStressId());
		attributes.put("usecaseId", getUsecaseId());
		attributes.put("weight", getWeight());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long linkUsecasePortletStressId = (Long)attributes.get(
				"linkUsecasePortletStressId");

		if (linkUsecasePortletStressId != null) {
			setLinkUsecasePortletStressId(linkUsecasePortletStressId);
		}

		Long portletStressId = (Long)attributes.get("portletStressId");

		if (portletStressId != null) {
			setPortletStressId(portletStressId);
		}

		Long usecaseId = (Long)attributes.get("usecaseId");

		if (usecaseId != null) {
			setUsecaseId(usecaseId);
		}

		Double weight = (Double)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}
	}

	/**
	* Returns the primary key of this link usecase portlet stress.
	*
	* @return the primary key of this link usecase portlet stress
	*/
	@Override
	public long getPrimaryKey() {
		return _linkUsecasePortletStress.getPrimaryKey();
	}

	/**
	* Sets the primary key of this link usecase portlet stress.
	*
	* @param primaryKey the primary key of this link usecase portlet stress
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_linkUsecasePortletStress.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the link usecase portlet stress ID of this link usecase portlet stress.
	*
	* @return the link usecase portlet stress ID of this link usecase portlet stress
	*/
	@Override
	public long getLinkUsecasePortletStressId() {
		return _linkUsecasePortletStress.getLinkUsecasePortletStressId();
	}

	/**
	* Sets the link usecase portlet stress ID of this link usecase portlet stress.
	*
	* @param linkUsecasePortletStressId the link usecase portlet stress ID of this link usecase portlet stress
	*/
	@Override
	public void setLinkUsecasePortletStressId(long linkUsecasePortletStressId) {
		_linkUsecasePortletStress.setLinkUsecasePortletStressId(linkUsecasePortletStressId);
	}

	/**
	* Returns the portlet stress ID of this link usecase portlet stress.
	*
	* @return the portlet stress ID of this link usecase portlet stress
	*/
	@Override
	public long getPortletStressId() {
		return _linkUsecasePortletStress.getPortletStressId();
	}

	/**
	* Sets the portlet stress ID of this link usecase portlet stress.
	*
	* @param portletStressId the portlet stress ID of this link usecase portlet stress
	*/
	@Override
	public void setPortletStressId(long portletStressId) {
		_linkUsecasePortletStress.setPortletStressId(portletStressId);
	}

	/**
	* Returns the usecase ID of this link usecase portlet stress.
	*
	* @return the usecase ID of this link usecase portlet stress
	*/
	@Override
	public long getUsecaseId() {
		return _linkUsecasePortletStress.getUsecaseId();
	}

	/**
	* Sets the usecase ID of this link usecase portlet stress.
	*
	* @param usecaseId the usecase ID of this link usecase portlet stress
	*/
	@Override
	public void setUsecaseId(long usecaseId) {
		_linkUsecasePortletStress.setUsecaseId(usecaseId);
	}

	/**
	* Returns the weight of this link usecase portlet stress.
	*
	* @return the weight of this link usecase portlet stress
	*/
	@Override
	public double getWeight() {
		return _linkUsecasePortletStress.getWeight();
	}

	/**
	* Sets the weight of this link usecase portlet stress.
	*
	* @param weight the weight of this link usecase portlet stress
	*/
	@Override
	public void setWeight(double weight) {
		_linkUsecasePortletStress.setWeight(weight);
	}

	@Override
	public boolean isNew() {
		return _linkUsecasePortletStress.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_linkUsecasePortletStress.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _linkUsecasePortletStress.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_linkUsecasePortletStress.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _linkUsecasePortletStress.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _linkUsecasePortletStress.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_linkUsecasePortletStress.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _linkUsecasePortletStress.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_linkUsecasePortletStress.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_linkUsecasePortletStress.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_linkUsecasePortletStress.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LinkUsecasePortletStressWrapper((LinkUsecasePortletStress)_linkUsecasePortletStress.clone());
	}

	@Override
	public int compareTo(
		com.excilys.liferay.gatling.model.LinkUsecasePortletStress linkUsecasePortletStress) {
		return _linkUsecasePortletStress.compareTo(linkUsecasePortletStress);
	}

	@Override
	public int hashCode() {
		return _linkUsecasePortletStress.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.excilys.liferay.gatling.model.LinkUsecasePortletStress> toCacheModel() {
		return _linkUsecasePortletStress.toCacheModel();
	}

	@Override
	public com.excilys.liferay.gatling.model.LinkUsecasePortletStress toEscapedModel() {
		return new LinkUsecasePortletStressWrapper(_linkUsecasePortletStress.toEscapedModel());
	}

	@Override
	public com.excilys.liferay.gatling.model.LinkUsecasePortletStress toUnescapedModel() {
		return new LinkUsecasePortletStressWrapper(_linkUsecasePortletStress.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _linkUsecasePortletStress.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _linkUsecasePortletStress.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_linkUsecasePortletStress.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LinkUsecasePortletStressWrapper)) {
			return false;
		}

		LinkUsecasePortletStressWrapper linkUsecasePortletStressWrapper = (LinkUsecasePortletStressWrapper)obj;

		if (Validator.equals(_linkUsecasePortletStress,
					linkUsecasePortletStressWrapper._linkUsecasePortletStress)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LinkUsecasePortletStress getWrappedLinkUsecasePortletStress() {
		return _linkUsecasePortletStress;
	}

	@Override
	public LinkUsecasePortletStress getWrappedModel() {
		return _linkUsecasePortletStress;
	}

	@Override
	public void resetOriginalValues() {
		_linkUsecasePortletStress.resetOriginalValues();
	}

	private LinkUsecasePortletStress _linkUsecasePortletStress;
}