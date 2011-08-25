SpringNet - Java Web Application
========================================


Using technologies
------------------

* DB Management: SQL Server 2008, MySQL 5.x

* Server-side: Servlet, Spring MVC, JPA with Hibernate, OSGi with ?

* Client-side: jQuery, Dojo

* Integrated Developement Environment: Eclipse 3.7+ (Indigo) or Netbeans 7.0.1+

    Plugins:

  * Spring IDE (http://springide.org/updatesite)
  * Maven (required)
  * Ant Build (optional)
  * EGit (optional)

* Web Server: Tomcat 7.0.20+


Hướng dẫn mở đề án
------------------

### Tổng quát

Đề án đã được cấu hình để có thể mở được bằng Eclipse và Netbeans (chọn đúng phiên bản được yêu cầu).
Lưu ý: Eclipse và Netbeans phải được cài đặt plugin hỗ trợ Maven 3 trở lên.
Đề án được lưu trữ tại Github và Assembla tại URL:

  * https://github.com/lilylnx/cncaptech/
  * http://www.assembla.com/code/cncaptech/git/nodes

Sử dụng công cụ [Git](http://git-scm.com/) để tải về. Trên Windows, sử dụng
[msysgit](http://code.google.com/p/msysgit/downloads/list) để tải về.
Sau khi tải về, điều cần làm là sao chép toàn bộ file trong thư mục `copy-to-project` vào đề án.
Như vậy đã có thể mở được đề án.

Việc cần làm tiếp theo khi mở đề án là apply Tomcat webserver vào đề án.
Nếu cả Eclipse hoặc Netbeans sau khi mở "không báo cáo thiếu library", như vậy là thành công.

Đối với Eclipse nên cài đặt thêm Spring plugin bằng cách vào `Help > Eclipse Marketplace`.

Nếu không xài Maven, thì các library trong classpath bạn phải chịu khó tìm kiếm và tự đưa vào đề án,
cũng như phải tự tìm sourcecode và javadoc.


### Hiệu chỉnh IDE

Việc quy định quy ước source code khá quan trọng, chẳng hạn phần header của tập tin, phần ghi chú
tác giả và version (gồm tên tập tin, version, ngày/tháng/năm giờ:phút:giây), một số thứ linh tinh.

Ví dụ: mô tả header một file .java

    /**
     * Written by Tien Nguyen <lilylnx@users.sf.net>
     * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
     */
    package net.lilylnx.springnet

Ví dụ: mô tả một Class

    /**
     * Phần mô tả class.
     * 
     * @author Tien Nguyen
     * @version $Id: TenTapTin.java,v 1.0 2011/12/28 1:23:45 lilylnx Exp $
     */
    public class TenTapTin {

      // TODO code here
    }

Trong tập tin `.java`, một `<tab>` được chuyển thành 2 kí tự space.
Tập tin `.xml` hoặc `.jsp`, một `<tab>` vẫn được giữ nguyên kí tự 'tab', nhưng có kích thước là 2 kí tự space.
Nên phân biệt rõ 2 cách hiển thị này để mã nguồn được rõ ràng. Nếu không có thể bị tình trạng, trên cùng một dòng
vừa tab và space để thụt đầu dòng hỗn độn.

Trong Eclipse và Netbeans, nên hạn chế dùng tính năng `format` mã nguồn để làm đẹp, nên cố gắng tự mình
trình bày quy ước một cách tốt nhất.

Ở đây tớ đã export sẵn 2 tập tin `eclipse-preferences.epf` và `netbeans-options.zip`
chứa phần hiệu chỉnh format, color, template cho 2 IDE.

  * Đối với Eclipse, đưa vào bằng cách: `File > Import... > General > Preferences`,
    chọn tập tin `.epf`.
  * Đối với Netbeans, đưa vào bằng cách: `Tools > Options > Import...`,
    chọn tập tin `.zip`


Testing
-------

    Updating...


--
Tien Nguyen ([Blog](http://lilylnx.wordpress.com/))