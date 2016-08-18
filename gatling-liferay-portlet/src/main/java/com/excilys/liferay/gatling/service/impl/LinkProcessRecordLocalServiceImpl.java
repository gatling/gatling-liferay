package com.excilys.liferay.gatling.service.impl;

import com.excilys.liferay.gatling.NoSuchLinkProcessRecordException;
import com.excilys.liferay.gatling.model.LinkProcessRecord;
import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.service.ProcessLocalServiceUtil;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.excilys.liferay.gatling.service.base.LinkProcessRecordLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the link process record local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.excilys.liferay.gatling.service.LinkProcessRecordLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.excilys.liferay.gatling.service.base.LinkProcessRecordLocalServiceBaseImpl
 * @see com.excilys.liferay.gatling.service.LinkProcessRecordLocalServiceUtil
 */
public class LinkProcessRecordLocalServiceImpl
    extends LinkProcessRecordLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.excilys.liferay.gatling.service.LinkProcessRecordLocalServiceUtil} to access the link process record local service.
     */
	
	/**
	 * Finds the Process associated with the given record id
	 * @param recordId The id of the record
	 * @return The Process associated with the given record id or
	 * 		null if no process is associated with the given record id
	 */
	@Override
	public com.excilys.liferay.gatling.model.Process findProcessFromRecordId(long recordId) throws SystemException, PortalException {
		try {
			LinkProcessRecord link = linkProcessRecordPersistence.findByRecordId(recordId);
			return ProcessLocalServiceUtil.getProcess(link.getProcess_id());
		} catch (NoSuchLinkProcessRecordException e) {
			return null;
		}
	}
	
	/**
	 * Finds the Record associated with the given process id
	 * @param processId The id of the process
	 * @return The Record associated with the given process id or
	 * 		null if no record is associated with the given process id
	 */
	@Override
	public Record findRecordFromProcessId(long processId) throws SystemException, PortalException {
		try {
			LinkProcessRecord link = linkProcessRecordPersistence.findByProcessId(processId);
			return RecordLocalServiceUtil.getRecord(link.getRecordId());
		} catch (NoSuchLinkProcessRecordException e) {
			return null;
		}
	}
	
}
