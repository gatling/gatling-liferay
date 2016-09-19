package io.gatling.liferay.service.impl;

import io.gatling.liferay.model.ProcessScenarioLink;
import io.gatling.liferay.service.base.ProcessScenarioLinkLocalServiceBaseImpl;
import io.gatling.liferay.service.persistence.ProcessScenarioLinkUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the process scenario link local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link io.gatling.liferay.service.ProcessScenarioLinkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see io.gatling.liferay.service.base.ProcessScenarioLinkLocalServiceBaseImpl
 * @see io.gatling.liferay.service.ProcessScenarioLinkLocalServiceUtil
 */
public class ProcessScenarioLinkLocalServiceImpl
    extends ProcessScenarioLinkLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link io.gatling.liferay.service.ProcessScenarioLinkLocalServiceUtil} to access the process scenario link local service.
     */	
	
	@Override
	public ProcessScenarioLink createLink(long scenarioId, long processId, int order, int pause) throws SystemException{
		ProcessScenarioLink link = ProcessScenarioLinkUtil.create(CounterLocalServiceUtil.increment(ProcessScenarioLink.class.getName()));
		link.setScenario_id(scenarioId);
		link.setProcess_id(processId);
		link.setOrder(order);
		link.setPause(pause);
		link.persist();
		return link;
	}
	
	public List<ProcessScenarioLink> findByscenarioId(long scenarioId) throws SystemException {
    	return processScenarioLinkPersistence.findByscenarioId(scenarioId);
	}
	
}
