/*
 * package com.honda.user.provisioning.util.test;
 * 
 * import com.honda.user.provisioning.util.UserProvisioningHelper; import
 * com.liferay.arquillian.extension.junit.bridge.junit.Arquillian; import
 * com.liferay.portal.kernel.exception.PortalException; import
 * com.liferay.portal.kernel.model.User; import
 * com.liferay.portal.test.rule.Inject;
 * 
 * import javax.portlet.ActionRequest;
 * 
 * import org.junit.Assert; import org.junit.Test; import
 * org.junit.runner.RunWith;
 * 
 * @RunWith(Arquillian.class) public class UserProvisioningHelperTest {
 * 
 * @Test public void onboardUser() throws PortalException{
 * 
 * User user = null; try { user =
 * proUserProvisioningHelper.onboardUser(actionRequest, "firstName", "lastName",
 * "emailAddress");
 * 
 * } catch (PortalException e) {
 * 
 * }
 * 
 * Assert.assertNotNull(user);
 * 
 * }
 * 
 * @Inject private UserProvisioningHelper proUserProvisioningHelper;
 * 
 * 
 * @Inject ActionRequest actionRequest;
 * 
 * 
 * }
 */