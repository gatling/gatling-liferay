/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProcessScenarioLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcessScenarioLink
 * @generated
 */
public class ProcessScenarioLinkWrapper implements ProcessScenarioLink,
    ModelWrapper<ProcessScenarioLink> {
    private ProcessScenarioLink _processScenarioLink;

    public ProcessScenarioLinkWrapper(ProcessScenarioLink processScenarioLink) {
        _processScenarioLink = processScenarioLink;
    }

    @Override
    public Class<?> getModelClass() {
        return ProcessScenarioLink.class;
    }

    @Override
    public String getModelClassName() {
        return ProcessScenarioLink.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("psl_id", getPsl_id());
        attributes.put("process_id", getProcess_id());
        attributes.put("scenario_id", getScenario_id());
        attributes.put("order", getOrder());
        attributes.put("pause", getPause());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long psl_id = (Long) attributes.get("psl_id");

        if (psl_id != null) {
            setPsl_id(psl_id);
        }

        Long process_id = (Long) attributes.get("process_id");

        if (process_id != null) {
            setProcess_id(process_id);
        }

        Long scenario_id = (Long) attributes.get("scenario_id");

        if (scenario_id != null) {
            setScenario_id(scenario_id);
        }

        Integer order = (Integer) attributes.get("order");

        if (order != null) {
            setOrder(order);
        }

        Integer pause = (Integer) attributes.get("pause");

        if (pause != null) {
            setPause(pause);
        }
    }

    /**
    * Returns the primary key of this process scenario link.
    *
    * @return the primary key of this process scenario link
    */
    @Override
    public long getPrimaryKey() {
        return _processScenarioLink.getPrimaryKey();
    }

    /**
    * Sets the primary key of this process scenario link.
    *
    * @param primaryKey the primary key of this process scenario link
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _processScenarioLink.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the psl_id of this process scenario link.
    *
    * @return the psl_id of this process scenario link
    */
    @Override
    public long getPsl_id() {
        return _processScenarioLink.getPsl_id();
    }

    /**
    * Sets the psl_id of this process scenario link.
    *
    * @param psl_id the psl_id of this process scenario link
    */
    @Override
    public void setPsl_id(long psl_id) {
        _processScenarioLink.setPsl_id(psl_id);
    }

    /**
    * Returns the process_id of this process scenario link.
    *
    * @return the process_id of this process scenario link
    */
    @Override
    public long getProcess_id() {
        return _processScenarioLink.getProcess_id();
    }

    /**
    * Sets the process_id of this process scenario link.
    *
    * @param process_id the process_id of this process scenario link
    */
    @Override
    public void setProcess_id(long process_id) {
        _processScenarioLink.setProcess_id(process_id);
    }

    /**
    * Returns the scenario_id of this process scenario link.
    *
    * @return the scenario_id of this process scenario link
    */
    @Override
    public long getScenario_id() {
        return _processScenarioLink.getScenario_id();
    }

    /**
    * Sets the scenario_id of this process scenario link.
    *
    * @param scenario_id the scenario_id of this process scenario link
    */
    @Override
    public void setScenario_id(long scenario_id) {
        _processScenarioLink.setScenario_id(scenario_id);
    }

    /**
    * Returns the order of this process scenario link.
    *
    * @return the order of this process scenario link
    */
    @Override
    public int getOrder() {
        return _processScenarioLink.getOrder();
    }

    /**
    * Sets the order of this process scenario link.
    *
    * @param order the order of this process scenario link
    */
    @Override
    public void setOrder(int order) {
        _processScenarioLink.setOrder(order);
    }

    /**
    * Returns the pause of this process scenario link.
    *
    * @return the pause of this process scenario link
    */
    @Override
    public int getPause() {
        return _processScenarioLink.getPause();
    }

    /**
    * Sets the pause of this process scenario link.
    *
    * @param pause the pause of this process scenario link
    */
    @Override
    public void setPause(int pause) {
        _processScenarioLink.setPause(pause);
    }

    @Override
    public boolean isNew() {
        return _processScenarioLink.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _processScenarioLink.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _processScenarioLink.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _processScenarioLink.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _processScenarioLink.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _processScenarioLink.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _processScenarioLink.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _processScenarioLink.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _processScenarioLink.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _processScenarioLink.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _processScenarioLink.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ProcessScenarioLinkWrapper((ProcessScenarioLink) _processScenarioLink.clone());
    }

    @Override
    public int compareTo(
        io.gatling.liferay.model.ProcessScenarioLink processScenarioLink) {
        return _processScenarioLink.compareTo(processScenarioLink);
    }

    @Override
    public int hashCode() {
        return _processScenarioLink.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<io.gatling.liferay.model.ProcessScenarioLink> toCacheModel() {
        return _processScenarioLink.toCacheModel();
    }

    @Override
    public io.gatling.liferay.model.ProcessScenarioLink toEscapedModel() {
        return new ProcessScenarioLinkWrapper(_processScenarioLink.toEscapedModel());
    }

    @Override
    public io.gatling.liferay.model.ProcessScenarioLink toUnescapedModel() {
        return new ProcessScenarioLinkWrapper(_processScenarioLink.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _processScenarioLink.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _processScenarioLink.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _processScenarioLink.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ProcessScenarioLinkWrapper)) {
            return false;
        }

        ProcessScenarioLinkWrapper processScenarioLinkWrapper = (ProcessScenarioLinkWrapper) obj;

        if (Validator.equals(_processScenarioLink,
                    processScenarioLinkWrapper._processScenarioLink)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ProcessScenarioLink getWrappedProcessScenarioLink() {
        return _processScenarioLink;
    }

    @Override
    public ProcessScenarioLink getWrappedModel() {
        return _processScenarioLink;
    }

    @Override
    public void resetOriginalValues() {
        _processScenarioLink.resetOriginalValues();
    }
}
