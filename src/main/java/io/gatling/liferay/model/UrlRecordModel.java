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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the UrlRecord service. Represents a row in the &quot;StressTool_UrlRecord&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link io.gatling.liferay.model.impl.UrlRecordModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link io.gatling.liferay.model.impl.UrlRecordImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UrlRecord
 * @see io.gatling.liferay.model.impl.UrlRecordImpl
 * @see io.gatling.liferay.model.impl.UrlRecordModelImpl
 * @generated
 */
public interface UrlRecordModel extends BaseModel<UrlRecord> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a url record model instance should use the {@link UrlRecord} interface instead.
     */

    /**
     * Returns the primary key of this url record.
     *
     * @return the primary key of this url record
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this url record.
     *
     * @param primaryKey the primary key of this url record
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the url record ID of this url record.
     *
     * @return the url record ID of this url record
     */
    public long getUrlRecordId();

    /**
     * Sets the url record ID of this url record.
     *
     * @param urlRecordId the url record ID of this url record
     */
    public void setUrlRecordId(long urlRecordId);

    /**
     * Returns the record ID of this url record.
     *
     * @return the record ID of this url record
     */
    public long getRecordId();

    /**
     * Sets the record ID of this url record.
     *
     * @param recordId the record ID of this url record
     */
    public void setRecordId(long recordId);

    /**
     * Returns the url of this url record.
     *
     * @return the url of this url record
     */
    @AutoEscape
    public String getUrl();

    /**
     * Sets the url of this url record.
     *
     * @param url the url of this url record
     */
    public void setUrl(String url);

    /**
     * Returns the type of this url record.
     *
     * @return the type of this url record
     */
    @AutoEscape
    public String getType();

    /**
     * Sets the type of this url record.
     *
     * @param type the type of this url record
     */
    public void setType(String type);

    /**
     * Returns the order of this url record.
     *
     * @return the order of this url record
     */
    public int getOrder();

    /**
     * Sets the order of this url record.
     *
     * @param order the order of this url record
     */
    public void setOrder(int order);

    /**
     * Returns the pause time of this url record.
     *
     * @return the pause time of this url record
     */
    public int getPauseTime();

    /**
     * Sets the pause time of this url record.
     *
     * @param pauseTime the pause time of this url record
     */
    public void setPauseTime(int pauseTime);

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
    public int compareTo(UrlRecord urlRecord);

    @Override
    public int hashCode();

    @Override
    public CacheModel<UrlRecord> toCacheModel();

    @Override
    public UrlRecord toEscapedModel();

    @Override
    public UrlRecord toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
