/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mantech.domain.Student;
import mantech.repository.StudentRepository;







/**
 * @author Tien Nguyen
 * @version $Id: IndexController.java,v 1.0 2011/06/07 23:56:07 lilylnx Exp $
 */
@Controller
@RequestMapping("/index")
public class IndexController {

  @Autowired
  private StudentRepository studentRepo;

  public IndexController() {}

  @RequestMapping(method = RequestMethod.GET)
  public String list(ModelMap model) {
    Student student = studentRepo.get(1); 
    
    model.addAttribute("welcomeMsg", "SpringFramework!")
        .addAttribute("student", student);
    return "index";
  }

}