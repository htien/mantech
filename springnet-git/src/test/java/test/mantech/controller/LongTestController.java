/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package test.mantech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mantech.domain.User;
import mantech.repository.UserRepository;

import net.lilylnx.springnet.util.ClientUtils;

/**
 * 
 * @author Long Nguyen
 * @version $Id: LongTestController.java,v 1.0 2011/09/07 3:23:07 nguyenlong Exp $
 */
@Controller
public class LongTestController {
  
  @Autowired
  private ClientUtils utils;
  
  @Autowired
  private UserRepository userRepo;
  
  @RequestMapping(value = "/abc", method = RequestMethod.GET)
  public String abc() {
    return "test/long_test";
  }
  
  @RequestMapping(value = "/long", method = RequestMethod.GET)
  public ResponseEntity<String> list() {
    User user = userRepo.get(1);
    return utils.createJsonResponse(user); 
  }

}