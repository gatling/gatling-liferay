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

package com.excilys.liferay.gatling.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class LinkUsecaseScenarioPK implements Comparable<LinkUsecaseScenarioPK>,
	Serializable {
	public long scenario_id;
	public long usecaseId;

	public LinkUsecaseScenarioPK() {
	}

	public LinkUsecaseScenarioPK(long scenario_id, long usecaseId) {
		this.scenario_id = scenario_id;
		this.usecaseId = usecaseId;
	}

	public long getScenario_id() {
		return scenario_id;
	}

	public void setScenario_id(long scenario_id) {
		this.scenario_id = scenario_id;
	}

	public long getUsecaseId() {
		return usecaseId;
	}

	public void setUsecaseId(long usecaseId) {
		this.usecaseId = usecaseId;
	}

	@Override
	public int compareTo(LinkUsecaseScenarioPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (scenario_id < pk.scenario_id) {
			value = -1;
		}
		else if (scenario_id > pk.scenario_id) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (usecaseId < pk.usecaseId) {
			value = -1;
		}
		else if (usecaseId > pk.usecaseId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LinkUsecaseScenarioPK)) {
			return false;
		}

		LinkUsecaseScenarioPK pk = (LinkUsecaseScenarioPK)obj;

		if ((scenario_id == pk.scenario_id) && (usecaseId == pk.usecaseId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(scenario_id) + String.valueOf(usecaseId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("scenario_id");
		sb.append(StringPool.EQUAL);
		sb.append(scenario_id);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("usecaseId");
		sb.append(StringPool.EQUAL);
		sb.append(usecaseId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}