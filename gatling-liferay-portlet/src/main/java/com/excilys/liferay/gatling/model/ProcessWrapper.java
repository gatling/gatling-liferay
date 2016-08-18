package com.excilys.liferay.gatling.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Process}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Process
 * @generated
 */
public class ProcessWrapper implements Process, ModelWrapper<Process> {
    private Process _process;

    public ProcessWrapper(Process process) {
        _process = process;
    }

    @Override
    public Class<?> getModelClass() {
        return Process.class;
    }

    @Override
    public String getModelClassName() {
        return Process.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("process_id", getProcess_id());
        attributes.put("name", getName());
        attributes.put("type", getType());
        attributes.put("order", getOrder());
        attributes.put("scenario_id", getScenario_id());
        attributes.put("recordId", getRecordId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long process_id = (Long) attributes.get("process_id");

        if (process_id != null) {
            setProcess_id(process_id);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String type = (String) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        Integer order = (Integer) attributes.get("order");

        if (order != null) {
            setOrder(order);
        }

        Long scenario_id = (Long) attributes.get("scenario_id");

        if (scenario_id != null) {
            setScenario_id(scenario_id);
        }

        Long recordId = (Long) attributes.get("recordId");

        if (recordId != null) {
            setRecordId(recordId);
        }
    }

    /**
    * Returns the primary key of this process.
    *
    * @return the primary key of this process
    */
    @Override
    public long getPrimaryKey() {
        return _process.getPrimaryKey();
    }

    /**
    * Sets the primary key of this process.
    *
    * @param primaryKey the primary key of this process
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _process.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the process_id of this process.
    *
    * @return the process_id of this process
    */
    @Override
    public long getProcess_id() {
        return _process.getProcess_id();
    }

    /**
    * Sets the process_id of this process.
    *
    * @param process_id the process_id of this process
    */
    @Override
    public void setProcess_id(long process_id) {
        _process.setProcess_id(process_id);
    }

    /**
    * Returns the name of this process.
    *
    * @return the name of this process
    */
    @Override
    public java.lang.String getName() {
        return _process.getName();
    }

    /**
    * Sets the name of this process.
    *
    * @param name the name of this process
    */
    @Override
    public void setName(java.lang.String name) {
        _process.setName(name);
    }

    /**
    * Returns the type of this process.
    *
    * @return the type of this process
    */
    @Override
    public java.lang.String getType() {
        return _process.getType();
    }

    /**
    * Sets the type of this process.
    *
    * @param type the type of this process
    */
    @Override
    public void setType(java.lang.String type) {
        _process.setType(type);
    }

    /**
    * Returns the order of this process.
    *
    * @return the order of this process
    */
    @Override
    public int getOrder() {
        return _process.getOrder();
    }

    /**
    * Sets the order of this process.
    *
    * @param order the order of this process
    */
    @Override
    public void setOrder(int order) {
        _process.setOrder(order);
    }

    /**
    * Returns the scenario_id of this process.
    *
    * @return the scenario_id of this process
    */
    @Override
    public long getScenario_id() {
        return _process.getScenario_id();
    }

    /**
    * Sets the scenario_id of this process.
    *
    * @param scenario_id the scenario_id of this process
    */
    @Override
    public void setScenario_id(long scenario_id) {
        _process.setScenario_id(scenario_id);
    }

    /**
    * Returns the record ID of this process.
    *
    * @return the record ID of this process
    */
    @Override
    public java.lang.Long getRecordId() {
        return _process.getRecordId();
    }

    /**
    * Sets the record ID of this process.
    *
    * @param recordId the record ID of this process
    */
    @Override
    public void setRecordId(java.lang.Long recordId) {
        _process.setRecordId(recordId);
    }

    @Override
    public boolean isNew() {
        return _process.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _process.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _process.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _process.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _process.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _process.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _process.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _process.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _process.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _process.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _process.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ProcessWrapper((Process) _process.clone());
    }

    @Override
    public int compareTo(com.excilys.liferay.gatling.model.Process process) {
        return _process.compareTo(process);
    }

    @Override
    public int hashCode() {
        return _process.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.excilys.liferay.gatling.model.Process> toCacheModel() {
        return _process.toCacheModel();
    }

    @Override
    public com.excilys.liferay.gatling.model.Process toEscapedModel() {
        return new ProcessWrapper(_process.toEscapedModel());
    }

    @Override
    public com.excilys.liferay.gatling.model.Process toUnescapedModel() {
        return new ProcessWrapper(_process.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _process.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _process.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _process.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ProcessWrapper)) {
            return false;
        }

        ProcessWrapper processWrapper = (ProcessWrapper) obj;

        if (Validator.equals(_process, processWrapper._process)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Process getWrappedProcess() {
        return _process;
    }

    @Override
    public Process getWrappedModel() {
        return _process;
    }

    @Override
    public void resetOriginalValues() {
        _process.resetOriginalValues();
    }
}
