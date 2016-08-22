package com.excilys.liferay.gatling.service.impl;

import com.excilys.liferay.gatling.NoSuchFormParamException;
import com.excilys.liferay.gatling.model.FormParam;
import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.service.base.FormParamLocalServiceBaseImpl;
import com.excilys.liferay.gatling.service.persistence.FormParamPersistence;
import com.excilys.liferay.gatling.validator.UrlRecordValidator;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the form param local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.excilys.liferay.gatling.service.FormParamLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.excilys.liferay.gatling.service.base.FormParamLocalServiceBaseImpl
 * @see com.excilys.liferay.gatling.service.FormParamLocalServiceUtil
 */
public class FormParamLocalServiceImpl extends FormParamLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.excilys.liferay.gatling.service.FormParamLocalServiceUtil} to access the form param local service.
     */
	
	@Override
	public FormParam findByUrlRecordId(long urlRecordId) throws SystemException, NoSuchFormParamException {
		return formParamPersistence.findByUrlRecordId(urlRecordId);
	}
	
	@Override
	public void save(long urlRecordId, String data, String type) throws SystemException{
		long primaryKeyUrl = CounterLocalServiceUtil.increment(FormParam.class.getName());
		FormParam formParam = formParamPersistence.create(primaryKeyUrl);
		formParam.setUrlRecordId(urlRecordId);
		formParam.setData(data);
		formParam.setType(type);
		//final List<String> errors = FormParamValidator.validateFormParam(formParam);
		//TODO: Create Validator
		final List<String> errors = new ArrayList<String>();
		if(errors.isEmpty()) {
			formParam.persist();
		}
	}
	
}
