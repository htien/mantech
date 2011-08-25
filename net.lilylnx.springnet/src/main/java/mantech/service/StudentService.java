/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.service;

import mantech.repository.StudentRepository;

/**
 * @author Tien Nguyen
 * @version $Id: StudentService.java,v 1.0 2011/08/26 00:53:16 lilylnx Exp $
 */
public class StudentService {
  
  private StudentRepository studentRepository;
  
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

}
