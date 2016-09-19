package io.gatling.liferay.service.impl;

import io.gatling.liferay.NoSuchFormParamException;
import io.gatling.liferay.model.FormParam;
import io.gatling.liferay.service.base.FormParamLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the form param local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link io.gatling.liferay.service.FormParamLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see io.gatling.liferay.service.base.FormParamLocalServiceBaseImpl
 * @see io.gatling.liferay.service.FormParamLocalServiceUtil
 */
public class FormParamLocalServiceImpl extends FormParamLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link io.gatling.liferay.service.FormParamLocalServiceUtil} to access the form param local service.
     */
	
	@Override
	public FormParam findByUrlRecordId(long urlRecordId) throws SystemException, NoSuchFormParamException {
		return formParamPersistence.findByUrlRecordId(urlRecordId);
	}
	
	@Override
	public void save(long urlRecordId, String data) throws SystemException{
		long primaryKeyUrl = CounterLocalServiceUtil.increment(FormParam.class.getName());
		FormParam formParam = formParamPersistence.create(primaryKeyUrl);
		formParam.setUrlRecordId(urlRecordId);
		formParam.setData(data);
		//final List<String> errors = FormParamValidator.validateFormParam(formParam);
		//TODO: Create Validator
		final List<String> errors = new ArrayList<String>();
		if(errors.isEmpty()) {
			formParam.persist();
		}
	}
	
}
