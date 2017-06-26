package demo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.model.DefaultUser;
import com.bstek.bdf2.core.security.IRetrivePreAuthenticatedUser;
@Component
public class LoginUserProvider implements IRetrivePreAuthenticatedUser {

	@Override
	public IUser retrive(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		DefaultUser dUser = new DefaultUser();
		dUser.setUsername("admin");
		dUser.setAdministrator(true);
		dUser.setCompanyId("companyId");
		return dUser;
	}

}
