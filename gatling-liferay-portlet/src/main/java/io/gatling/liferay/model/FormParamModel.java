/**
 * Copyright 2011-2015 GatlingCorp (http://gatling.io)
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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the FormParam service. Represents a row in the &quot;StressTool_FormParam&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link io.gatling.liferay.model.impl.FormParamModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link io.gatling.liferay.model.impl.FormParamImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormParam
 * @see io.gatling.liferay.model.impl.FormParamImpl
 * @see io.gatling.liferay.model.impl.FormParamModelImpl
 * @generated
 */
public interface FormParamModel extends BaseModel<FormParam> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a form param model instance should use the {@link FormParam} interface instead.
     */

    /**
     * Returns the primary key of this form param.
     *
     * @return the primary key of this form param
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this form param.
     *
     * @param primaryKey the primary key of this form param
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the form param ID of this form param.
     *
     * @return the form param ID of this form param
     */
    public long getFormParamId();

    /**
     * Sets the form param ID of this form param.
     *
     * @param formParamId the form param ID of this form param
     */
    public void setFormParamId(long formParamId);

    /**
     * Returns the url record ID of this form param.
     *
     * @return the url record ID of this form param
     */
    public long getUrlRecordId();

    /**
     * Sets the url record ID of this form param.
     *
     * @param urlRecordId the url record ID of this form param
     */
    public void setUrlRecordId(long urlRecordId);

    /**
     * Returns the data of this form param.
     *
     * @return the data of this form param
     */
    @AutoEscape
    public String getData();

    /**
     * Sets the data of this form param.
     *
     * @param data the data of this form param
     */
    public void setData(String data);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(FormParam formParam);

    @Override
    public int hashCode();

    @Override
    public CacheModel<FormParam> toCacheModel();

    @Override
    public FormParam toEscapedModel();

    @Override
    public FormParam toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
