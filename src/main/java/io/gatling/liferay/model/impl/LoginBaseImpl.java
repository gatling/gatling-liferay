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
package io.gatling.liferay.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import io.gatling.liferay.model.Login;
import io.gatling.liferay.service.LoginLocalServiceUtil;

/**
 * The extended model base implementation for the Login service. Represents a row in the &quot;StressTool_Login&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LoginImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoginImpl
 * @see io.gatling.liferay.model.Login
 * @generated
 */
public abstract class LoginBaseImpl extends LoginModelImpl implements Login {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a login model instance should use the {@link Login} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LoginLocalServiceUtil.addLogin(this);
        } else {
            LoginLocalServiceUtil.updateLogin(this);
        }
    }
}
