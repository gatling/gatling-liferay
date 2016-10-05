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
package io.gatling.liferay.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import io.gatling.liferay.model.Process;
import io.gatling.liferay.service.ProcessLocalServiceUtil;

/**
 * The extended model base implementation for the Process service. Represents a row in the &quot;StressTool_Process&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProcessImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcessImpl
 * @see io.gatling.liferay.model.Process
 * @generated
 */
public abstract class ProcessBaseImpl extends ProcessModelImpl
    implements Process {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a process model instance should use the {@link Process} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ProcessLocalServiceUtil.addProcess(this);
        } else {
            ProcessLocalServiceUtil.updateProcess(this);
        }
    }
}
