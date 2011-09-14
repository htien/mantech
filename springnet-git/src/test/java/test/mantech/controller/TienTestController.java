/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package test.mantech.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mantech.domain.Complaint;
import mantech.domain.User;
import mantech.repository.ComplaintRepository;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: TienTestController.java,v 1.0 2011/09/07 4:35:11 lilylnx Exp $
 */
@Controller
public class TienTestController {

  @Autowired
  private ComplaintRepository complaintRepo;

  @Autowired
  private SessionFactory sessionFactory;

  public TienTestController() {}

  @SuppressWarnings("unchecked")
  @RequestMapping(value = "/tien/test", method = RequestMethod.GET)
  public String list(ModelMap model) {
    Query q = sessionFactory.getCurrentSession().createQuery("select new mantech.domain.UserStats(u.username) from User u left join u.complaints as c group by u.username");
    model.addAttribute("listUser", (List<User>)q.list());
    return "test/tien_test";
  }

  @RequestMapping(value = "/tien/complaintEdit", method = RequestMethod.POST)
  public String showEditForm(ModelMap model) {
    List<Complaint> listComplaint = complaintRepo.findAll();
    model.addAttribute("listComplaint", listComplaint);
    return "test/complaint_edit";
  }

}
