/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.sso;

import java.util.Map;

import mantech.domain.User;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: LoginAuthenticator.java,v 1.0 Sep 3, 2011 3:56:42 AM lilylnx Exp $
 */
public interface LoginAuthenticator {
  
  /**
   * Kiểm tra tài khoản người dùng dựa vào username và password.
   * @param username Tên người dùng hoặc email
   * @param password Mật khẩu
   * @param extraParams Các thông số đính kèm
   * @return Thực thể <code>User</code> nếu đăng nhập thành công.
   *         Ngược lại trả về <code>null</code>.
   */
  User validateLogin(String unameOrEmail, String password, Map<String, Object> extraParams) throws Exception;

}
